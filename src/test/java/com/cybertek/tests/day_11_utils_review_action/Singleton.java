package com.cybertek.tests.day_11_utils_review_action;

public class Singleton {

    private Singleton(){};

    private static String word;

    public static String getWord(){
        if (word == null){
            System.out.println("First time call.Word object is null...Assigning value to it now!!!");
            word = "Something";
        }else{
            System.out.println("Word has already value");
        }

        return word;
    }
}
