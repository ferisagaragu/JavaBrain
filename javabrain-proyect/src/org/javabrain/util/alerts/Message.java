package org.javabrain.util.alerts;

/**
 * Created by Fernando García on 02/02/2018.
 */

public class Message {

    private static String firm = "\n      by JavaBrain\033[0m\n";
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

    public static void error(String message,boolean showException){
        if (language.equals("EN")){
            System.out.println("\033[31m---Error---\n");
        }
        else{
            System.out.println("\033[31m---Algo salio mal---\n");
        }
        System.out.println("\033[31m"+message);
        System.out.println(firm);
        if(showException){
            System.out.println("\033[31mException:\033[0m\n");
        }
    }

    public static void warning(String message){
        if (language.equals("EN")){
            System.out.println("\033[33m---Warning---\n");
        }
        else{
            System.out.println("\033[33m---Advertencia---\n");
        }

        System.out.print("\033[33m"+message.replace("\n","\n"));
        System.out.println(firm);
    }
    
    public static void custom(String message,String title){
        System.out.println("\033[35m---"+title+"---\n");
        System.out.println("\033[35m"+message);
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