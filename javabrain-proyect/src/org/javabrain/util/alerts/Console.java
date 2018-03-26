package org.javabrain.util.alerts;

/**
 * @author Fernando García
 * @version 0.0.1
 */
public class Console {

    private static int count = 0;

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

    public static void black(Object messge){System.out.println(messge);}

    public static void color(Object message){
        if(count == 8){count = 0;}
        switch (count)
        {
            case 0: red(message); count++; return;
            case 1: green(message); count++; return;
            case 2: yellow(message); count++; return;
            case 3: blue(message); count++; return;
            case 4: magenta(message); count++; return;
            case 5: cyan(message); count++; return;
            case 6: white(message); count++; return;
            case 7: black(message); count++; return;
        }
    }
}
