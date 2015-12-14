/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.is2140.stackneverflow.test;

import java.util.*;

/**
 *
 * @author yanyanzhou
 */
public class RelevantAnswerSet {

    private HashSet<Integer> set;
    public static final int[] answerID = {40878, 40512, 40522, 20519518, 1041798,
        7644118, 10372667, 30108941, 6382927, 2704023, 2704005, 20526985, 20527033,
        29092307, 29092189, 15591465, 19388076, 19388099, 32222411, 5161508, 5161497,
        671132, 671508, 13444382, 3950863, 671159, 29648972, 9100303, 17619692,
        680559, 2598249, 680613, 1688301, 8569847, 8569850, 8569893, 33515159,
        33015570, 3951264, 3951265, 3951270, 19594432};

    public RelevantAnswerSet() {
        this.set = new HashSet<Integer>();
        for (int i = 0; i < answerID.length; i++) {
            this.set.add(answerID[i]);
        }
    }

    public HashSet<Integer> getSet() {
        return set;
    }

}
