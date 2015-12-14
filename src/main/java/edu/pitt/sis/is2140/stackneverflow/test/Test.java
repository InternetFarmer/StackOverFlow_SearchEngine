/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.is2140.stackneverflow.test;

import edu.pitt.sis.is2140.stackneverflow.core.AnswerRanking;
import edu.pitt.sis.is2140.stackneverflow.core.StackOverFlowAPI;
import edu.pitt.sis.is2140.stackneverflow.model.Answer;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author yanyanzhou
 */
public class Test {

    private final int testCount = 6;
    private final String[] query = {"difference HashMap HashTable", "difference add() offer()",
        "convert character to integer", "what is RESTful", "quick sort","java array exception"};
    private final String[] tag = {"", "", "java", "", "", ""};

    /**
     * calculate Average Precision of ranking list
     *
     * @param set: relevant answer ID set
     * @param res: result set
     * @return
     */
    public double getAP(List<Answer> res, HashSet<Integer> set) {
        int count = 0;
        double AP = 0;
        for (int i = 1; i <= res.size(); i++) {
            Answer a = res.get(i - 1);
            if (set.contains(a.getAnswer_id())) {
                count++;
                AP += (double) count / i;
            }
        }
        AP = AP / count;
        System.out.println("AP = " + AP);

        return AP;
    }

    public double getMAP() throws Exception {
        RelevantAnswerSet RAS = new RelevantAnswerSet();
        HashSet<Integer> set = RAS.getSet();
        StackOverFlowAPI api = StackOverFlowAPI.getINSTANCE();

        double MAP = 0;
        for (int i = 0; i < testCount; i++) {
            List<Answer> res = api.searchRelevantAnswer(query[i], tag[i]);
            res = AnswerRanking.ranking(res);
            MAP += getAP(res, set);
        }
        System.out.println("MAP = " + MAP / testCount);
        return MAP;
    }

    public static void main(String[] args) throws Exception {
        Test test = new Test();
        test.getMAP();
    }
}
