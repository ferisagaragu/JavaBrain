package org.javabrain.util.alerts;

/**
 * @author Fernando García
 * @version 0.0.1
 */
public class Console {
    
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

    public static void color(int i,Object message){
        switch (i)
        {
            case 0: red(message); return;
            case 1: green(message); return;
            case 2: yellow(message); return;
            case 3: blue(message); return;
            case 4: red(message); return;
            case 5: magenta(message); return;
            case 6: cyan(message); return;
            case 7: white(message); return;
        }
    }
}
