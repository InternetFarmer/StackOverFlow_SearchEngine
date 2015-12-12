/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.is2140.stackneverflow.model;

import java.io.Serializable;

/**
 *
 * @author yanyanzhou
 */
public class Question implements Serializable {

    private int question_id;
    private int view_count;
    private int answer_count;
    private double normalized_view_count;
    private int score;
    private double normalized_score;
    private Boolean is_answered;
    private String title;
    private String body;
    private String link;
    private int rank;
    private double normalized_rank;

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getView_count() {
        return view_count;
    }

    public void setView_count(int view_count) {
        this.view_count = view_count;
    }

    public int getAnswer_count() {
        return answer_count;
    }

    public void setAnswer_count(int answer_count) {
        this.answer_count = answer_count;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Boolean getIs_answered() {
        return is_answered;
    }

    public void setIs_answered(Boolean is_answered) {
        this.is_answered = is_answered;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public double getNormalized_view_count() {
        return normalized_view_count;
    }

    public void setNormalized_view_count(double normalized_view_count) {
        this.normalized_view_count = normalized_view_count;
    }

    public double getNormalized_score() {
        return normalized_score;
    }

    public void setNormalized_score(double normalized_score) {
        this.normalized_score = normalized_score;
    }

    public double getNormalized_rank() {
        return normalized_rank;
    }

    public void setNormalized_rank(double normalized_rank) {
        this.normalized_rank = normalized_rank;
    }
    
    @Override
    public String toString() {
        return "Question{" + "question_id=" + question_id + ", view_count=" + view_count + ", answer_count=" + answer_count + ", score=" + score + ", is_answered=" + is_answered + ", title=" + title + ", link=" + link + '}';
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return this.rank;
    }

}
