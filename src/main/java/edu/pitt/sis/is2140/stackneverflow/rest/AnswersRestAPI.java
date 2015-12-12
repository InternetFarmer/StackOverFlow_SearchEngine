/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.is2140.stackneverflow.rest;

import edu.pitt.sis.is2140.stackneverflow.core.AnswerRanking;
import edu.pitt.sis.is2140.stackneverflow.core.StackOverFlowAPI;
import edu.pitt.sis.is2140.stackneverflow.model.Answer;
import java.util.List;
import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Wu
 */
@Controller
@RequestMapping("rest/answers")
public class AnswersRestAPI {

    public AnswersRestAPI() {
        //Initialize controller properties here or 
        //in the Web Application Context

        //setCommandClass(MyCommand.class);
        //setCommandName("MyCommandName");
        //setSuccessView("successView");
        //setFormView("formView");
    }

    /**
     * Search Answers
     *
     * @param key
     * @return list of answers
     * @throws org.json.JSONException
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public @ResponseBody List<Answer> searchAnswers(@RequestParam("key") String key) throws JSONException, Exception {
        List<Answer> input = null;
        List<Answer> res = null;
        System.out.println("rest API: key=" + key);
        if (key.length() != 0) { 
            input = StackOverFlowAPI.getINSTANCE().searchRelevantAnswer(key.trim());
            res = AnswerRanking.ranking(input);
        }
        
        return res;
    }

}
