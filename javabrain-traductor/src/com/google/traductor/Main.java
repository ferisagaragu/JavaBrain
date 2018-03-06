package com.google.traductor;

public class Main {
 
    public static void main(String[] args) {
 
        String a = Traductor.autoTraslate(Language.ENGLISH,"Estas bien feo niño estupído de mierda");
        System.out.println(a);
    }
}