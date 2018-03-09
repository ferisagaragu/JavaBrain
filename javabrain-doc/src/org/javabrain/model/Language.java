package org.javabrain.model;

import java.util.ArrayList;

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

    public static Language SPANISH =  new Language("es","Español");
    public static Language ENGLISH = new Language("en","English");
    public static Language FRENCH = new Language("fr","French");
    public static Language ITALIAN = new Language("it","Italian");
    public static Language PORTUGUESE = new Language("pt","Portugues");
    public static Language GERMAN = new Language("de","German");
    public static Language RUSSIAN = new Language("ru","Russian");
    public static Language ARAB = new Language("ar","Arab");
    public static Language TURKISH = new Language("tr","Turkish");
    public static ArrayList<Language> LANGUAGES = languages();
    
    private String type;
    private String name;

    public Language(String type,String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    private static ArrayList<Language> languages(){
        LANGUAGES = new ArrayList<>();
        LANGUAGES.add(SPANISH);
        LANGUAGES.add(ENGLISH);
        LANGUAGES.add(FRENCH);
        LANGUAGES.add(ITALIAN);
        LANGUAGES.add(PORTUGUESE);
        LANGUAGES.add(GERMAN);
        LANGUAGES.add(RUSSIAN);
        LANGUAGES.add(ARAB);
        LANGUAGES.add(TURKISH);
        
        return LANGUAGES;
    } 

}
