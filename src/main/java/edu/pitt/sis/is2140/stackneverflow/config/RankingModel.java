/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.is2140.stackneverflow.config;

/**
 *
 * @author Wu
 */
public class RankingModel {
    public static final double rank_weight = .8;
    public static final double view_count_weight = 0.05;
    public static final double question_score_weight = 0.02;
    public static final double is_accepted_weight = 0.07;
    public static final double answer_score_weight = 0.06;
    public static final double accept_percentage = .4;
}
