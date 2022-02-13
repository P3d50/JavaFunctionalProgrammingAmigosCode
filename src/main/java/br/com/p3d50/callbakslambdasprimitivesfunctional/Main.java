package br.com.p3d50.callbakslambdasprimitivesfunctional;

import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        hello("P3d50", null, value->{
            System.out.println("last name not provided for "+value);
        });

        helloRunnable("P3d50", null, ()->{
            System.out.println("last name not provided");
        });

    }

    static void hello(String firstName, String lastName, Consumer<String> callback){
        System.out.println(firstName);
        if(lastName!=null){
            System.out.println(lastName);
        }else{
            callback.accept(firstName);
        }
    }

    static void helloRunnable(String firstName, String lastName, Runnable callback){
        System.out.println(firstName);
        if(lastName!=null){
            System.out.println(lastName);
        }else{
            callback.run();
        }
    }
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
}
