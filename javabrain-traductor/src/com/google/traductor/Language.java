package com.google.traductor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author QualtopGroup
 */
public class Language extends Object{

    public static Language SPANISH =  new Language("es");
    public static Language ENGLISH = new Language("en");
    public static Language FRENCH = new Language("fr");
    public static Language ITALIAN = new Language("it");
    public static Language PORTUGUESE = new Language("pt");
    public static Language GERMAN = new Language("de");
    public static Language RUSSIAN = new Language("ru");
    public static Language ARAB = new Language("ar");
    public static Language TURKISH = new Language("tr");
    
    private String type;

    public Language(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
