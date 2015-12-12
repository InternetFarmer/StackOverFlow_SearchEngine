/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.is2140.stackneverflow.model;

import edu.pitt.sis.is2140.stackneverflow.config.RankingModel;
import java.io.Serializable;

/**
 *
 * @author Wu
 */
public class Answer implements Serializable, Comparable<Answer> {

    private final int answer_id;
    private final Question question;

    private boolean is_accepted;
    private int score;
    private double normalized_score;
    private String body;
    private String link;
    private String creation_date;
    
    private String owner;
    private String last_editor;

    public Answer(int answer_id, Question question) {
        this.answer_id = answer_id;
        this.question = question;
    }

    public int getAnswer_id() {
        return answer_id;
    }

    public Question getQuestion() {
        return question;
    }

    public boolean isIs_accepted() {
        return is_accepted;
    }

    public void setIs_accepted(boolean is_accepted) {
        this.is_accepted = is_accepted;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getLast_editor() {
        return last_editor;
    }

    public void setLast_editor(String last_editor) {
        this.last_editor = last_editor;
    }
    
    public double getNormalized_score() {
        return normalized_score;
    }

    public void setNormalized_score(double normalized_score) {
        this.normalized_score = normalized_score;
    }

    @Override
    public String toString() {
        return "Answer{" + "answer_id=" + answer_id + ", is_accepted=" + is_accepted + ", score=" + score + ", link=" + link + '}';
    }

    @Override
    public int compareTo(Answer o) {
        double point1 = this.question.getNormalized_rank() * RankingModel.rank_weight
                + this.question.getNormalized_score() * RankingModel.question_score_weight
                + this.question.getNormalized_view_count() * RankingModel.view_count_weight
                + this.normalized_score * RankingModel.answer_score_weight
                + (this.is_accepted ? 1 : 0) * RankingModel.is_accepted_weight;

        double point2 = o.question.getNormalized_rank() * RankingModel.rank_weight
                + o.question.getNormalized_score() * RankingModel.question_score_weight
                + o.question.getNormalized_view_count() * RankingModel.view_count_weight
                + o.normalized_score * RankingModel.answer_score_weight
                + (o.is_accepted ? 1 : 0) * RankingModel.is_accepted_weight;
        return point1 > point2 ? 1 : -1;
    }

}
