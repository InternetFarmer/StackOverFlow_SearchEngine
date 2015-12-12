/*
 * The class is used for invoking stackover apis
 */
package edu.pitt.sis.is2140.stackneverflow.core;

import edu.pitt.sis.is2140.stackneverflow.util.AnswerAPI;
import edu.pitt.sis.is2140.stackneverflow.util.QuestionAPI;
import edu.pitt.sis.is2140.stackneverflow.model.Answer;
import edu.pitt.sis.is2140.stackneverflow.util.FormatUtil;
import edu.pitt.sis.is2140.stackneverflow.util.ZipUtil;
import edu.pitt.sis.is2140.stackneverflow.model.Question;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.json.*;

/**
 *
 * @author Wu
 */
public class StackOverFlowAPI {
    
    public static final StackOverFlowAPI soa = new StackOverFlowAPI();
    private final HttpClient httpClient;
    
    public static StackOverFlowAPI getINSTANCE() {
        return soa;
    }
    
    private StackOverFlowAPI() {
        httpClient = new HttpClient();
        httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
    }

    /**
     * Use StackOverFlow API to retrieval questions
     *
     * @param key
     * @return
     * @throws org.json.JSONException
     */
    public List<Answer> searchRelevantAnswer(String key) throws Exception {
        QuestionAPI q_api = new QuestionAPI(key);
        GetMethod getMethod = new GetMethod(q_api.getURL());
        Map<Integer, Integer> rank = new HashMap();
        System.out.println(q_api.getURL());

        // receive and decode response
        String response = null;
        try {
            int statusCode = httpClient.executeMethod(getMethod);
            if (statusCode == HttpStatus.SC_OK) {
                byte[] responseBody = getMethod.getResponseBody();
                response = ZipUtil.decodeResponseToString(responseBody, "UTF-8");
            }
        } catch (Exception e) {
            System.out.println("error: " + e.getLocalizedMessage());
        } finally {
            getMethod.releaseConnection();
        }

        // generate list of question_id
        List<Integer> questionIDList = new ArrayList<Integer>();
        if (response != null) {
            JSONObject resObj = new JSONObject(response);
            JSONArray array = resObj.getJSONArray("items");
            for (int i = 0; i < array.length(); i++) {
                JSONObject questionObj = array.getJSONObject(i);
                
                int question_id = questionObj.getInt("question_id");
                
                rank.put(question_id, i);
                questionIDList.add(question_id);
            }
            
        }
        List<Answer> res = searchAnswers(questionIDList, rank);
        return res;
    }

    /**
     * Use StackOverFlow API to retrieval answers for question list
     *
     * @param questionList
     * @return List<Answer>
     */
    private List<Answer> searchAnswers(List<Integer> questionIDList, Map<Integer, Integer> rank) throws JSONException {
        if (questionIDList == null || questionIDList.isEmpty()) {
            return null;
        }
        AnswerAPI a_api = new AnswerAPI(String.valueOf(questionIDList.remove(0)));
        for (int questionID : questionIDList) {
            a_api.addQuestionid(String.valueOf(questionID));
        }
        GetMethod getMethod = new GetMethod(a_api.getURL());

        // receive and decode response
        String response = null;
        try {
            int statusCode = httpClient.executeMethod(getMethod);
            if (statusCode == HttpStatus.SC_OK) {
                byte[] responseBody = getMethod.getResponseBody();
                response = ZipUtil.decodeResponseToString(responseBody, "UTF-8");
            }
        } catch (Exception e) {
            System.out.println("error: " + e.getLocalizedMessage());
        } finally {
            getMethod.releaseConnection();
        }

        // generate list of answer object
        List<Answer> answerList = new ArrayList<Answer>();
        if (response != null) {
            JSONObject resObj = new JSONObject(response);
            JSONArray array = resObj.getJSONArray("items");
            
            int max_view_count = 0;
            int max_question_score = 0;
            int max_answer_score = 0;
            
            for (int i = 0; i < array.length(); i++) {
                JSONObject questionObj = array.getJSONObject(i);
                
                Question question = new Question();
                question.setQuestion_id(questionObj.getInt("question_id"));
                question.setIs_answered(questionObj.getBoolean("is_answered"));
                question.setView_count(questionObj.getInt("view_count"));
                question.setAnswer_count(questionObj.getInt("answer_count"));
                question.setScore(questionObj.getInt("score"));
                question.setLink(questionObj.getString("link"));
                question.setBody(questionObj.getString("body"));
                question.setRank(rank.get(question.getQuestion_id()));
                question.setNormalized_rank((rank.size() - rank.get(question.getQuestion_id())) / (double)rank.size());
                
                max_view_count = Math.max(max_view_count, questionObj.getInt("view_count"));
                max_question_score = Math.max(max_question_score, questionObj.getInt("score"));
                
                String title = questionObj.getString("title");
                title = FormatUtil.NormalizeHTML(title);
                question.setTitle(title);
                
                JSONArray answerArray = questionObj.getJSONArray("answers");
                for (int j = 0; j < answerArray.length(); j++) {
                    JSONObject answerObj = answerArray.getJSONObject(j);
                    int answer_id = answerObj.getInt("answer_id");
                    
                    Answer answer = new Answer(answer_id, question);
                    answer.setIs_accepted(answerObj.getBoolean("is_accepted"));
                    answer.setScore(answerObj.getInt("score"));
                    answer.setLink(answerObj.getString("link"));
                    answer.setBody(answerObj.getString("body"));
                    
                    max_answer_score = Math.max(max_answer_score, answerObj.getInt("score"));
                    
                    answerList.add(answer);
                }
            }
            
            for (Answer a : answerList) {
                a.setNormalized_score(a.getScore() / (double) max_answer_score);
                a.getQuestion().setNormalized_score(a.getQuestion().getScore() / (double) max_question_score);
                a.getQuestion().setNormalized_view_count(a.getQuestion().getView_count() / (double) max_view_count);
            }
            
        }
        
        return answerList;
    }

    /**
     * For test only
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        StackOverFlowAPI.getINSTANCE().searchRelevantAnswer("JAVA");
        
    }
}
