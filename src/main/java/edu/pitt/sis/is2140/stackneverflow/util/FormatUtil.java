/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.sis.is2140.stackneverflow.util;

/**
 *
 * @author yanyanzhou
 */
public class FormatUtil {

    /**
     * Normalize HTML content into Java String, escape back the specific symbols
     *
     * @param content
     * @return
     */
    public static String NormalizeHTML(String content) {
        if (content == null) {
            return "";
        }

        content = content.replace("&apos;", "'");
        content = content.replace("&quot;", "\"");
        //content = content.replace("&nbsp;&nbsp;", "\t");  
        content = content.replace("&nbsp;", " ");
        content = content.replace("&lt;", "<");
        content = content.replace("&gt;", ">");

        return content;
    }
    
    /**
     * Encode String 
     * 
     * @param content
     * @return 
     */
    public static String StringEncode(String content) {
        if (content == null) {
            return "";
        }

        content = content.replace(" ", "%20");
        content = content.replace("+", "%2B");
        content = content.replace("/", "%2F");
        content = content.replace("%", "%25");
        content = content.replace("?", "%3F");
        content = content.replace("=", "%3D");

        return content;
    }

    /**
     * For test only
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        String s = "&lt;hello&gt;";
        s = NormalizeHTML(s);
        System.out.println(s);
    }

}
