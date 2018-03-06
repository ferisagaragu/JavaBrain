package com.google.traductor;

public class Main {
 
    public static void main(String[] args) {
 
        String a = Traductor.autoTraslate(Language.ITALIAN,"hola amigo como estas en frances mi rey");
        System.out.println(a);
    }
}