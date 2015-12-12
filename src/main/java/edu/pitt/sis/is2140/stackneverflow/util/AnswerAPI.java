/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.is2140.stackneverflow.util;

/**
 *
 * @author Wu
 */
public class AnswerAPI {

    private static final String SEARCHADVANCEDAPI = "https://api.stackexchange.com/2.2/questions/";
    private String questionID = "";
    private String filter = "!)rh-4RYRj-SAZntA1WTu";
    private String site = "stackoverflow";
    private String order = "desc";
    private String sort = "activity";

    public AnswerAPI(String question_id) {
        this.questionID = question_id;
    }

    public void setQuestionid(String questionID) {
        this.questionID = questionID;
    }

    public void addQuestionid(String questionID) {
        this.questionID += ";" + questionID;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getURL() {
        StringBuilder sb = new StringBuilder();
        sb.append(SEARCHADVANCEDAPI);
        sb.append(questionID);
        sb.append("?order=");
        sb.append(order);
        sb.append("&sort=");
        sb.append(sort);
        sb.append("&site=");
        sb.append(site);
        sb.append("&filter=");
        sb.append(filter);
        return sb.toString();
    }
}
