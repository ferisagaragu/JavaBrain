package org.javabrain.console.alerts;

/**
 * Created by Fernando García on 02/02/2018.
 */

public class Message {

    private static String firm = "      by JavaBrain\033[0m\n";
    private static String language = "EN";

    //Static
    public static void susseful(String message){
        if (language.equals("EN")){
            System.out.println("\033[32m---Susseful---\n");
        }
        else{
            System.out.println("\033[32m---En hora buena---\n");
        }

        System.out.println("\033[32m"+message);
        System.out.println(firm);
    }

    public static void information(String message,String title){
        System.out.println("\033[34m---"+title+"---\n");
        System.out.println("\033[34m"+message);
        System.out.println(firm);
    }

    public static void error(String message){
        if (language.equals("EN")){
            System.out.println("\033[31m---Error---\n");
        }
        else{
            System.out.println("\033[31m---Algo salio mal---\n");
        }
        System.out.println("\033[31m"+message);
        System.out.println(firm);
    }

    //get and set
    public static void setFirm(String firm) {
        Message.firm = firm+"\033[0m\n";
    }

    public static void setLanguage(String language) {
        Message.language = language;
    }
}
