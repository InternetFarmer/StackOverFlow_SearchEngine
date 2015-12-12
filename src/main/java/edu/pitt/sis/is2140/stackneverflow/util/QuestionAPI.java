/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.is2140.stackneverflow.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 *
 * @author Wu
 */
public class QuestionAPI {

    private static final String SEARCHADVANCEDAPI = "https://api.stackexchange.com/2.2/search/advanced?";
    private String order = "desc";
    private String sort = "relevance";
    private String answers = "1";
    private String site = "stackoverflow";
    private String key = "";
    private String tags = "";

    public QuestionAPI(String key, String tags) {
        this.key = key;
        this.tags = tags;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getURL() throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        sb.append(SEARCHADVANCEDAPI);
        sb.append("order=");
        sb.append(order);
        sb.append("&sort=");
        sb.append(sort);
        sb.append("&answers=");
        sb.append(answers);
        sb.append("&site=");
        sb.append(site);
        sb.append("&tagged=");
        sb.append(tags);
        sb.append("&q=");
        sb.append(URLEncoder.encode(key, "UTF-8"));
        return sb.toString();
    }

}
