package org.javabrain.util.alerts;

/**
 *
 * @author QualtopGroup
 */
public class Consol {
    
    public static void red(Object message){
        System.out.println("\033[31m"+message+"\033[30m");
    }
    
    public static void green(Object message){
        System.out.println("\033[32m"+message+"\033[30m");
    }
    
    public static void yellow(Object message){
        System.out.println("\033[33m"+message+"\033[30m");
    }
    
    public static void blue(Object message){
        System.out.println("\033[34m"+message+"\033[30m");
    }

    public static void magenta(Object message){
        System.out.println("\033[35m"+message+"\033[30m");
    }
    
    public static void cyan(Object message){
        System.out.println("\033[36m"+message+"\033[30m");
    }

    public static void white(Object message){
        System.out.println("\033[37m"+message+"\033[30m");
    }
    
}
