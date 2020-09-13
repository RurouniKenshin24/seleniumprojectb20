package com.cybertek.tests.day_6_testNG;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_Intro {

    //"@BeforeMethod" annotation is used with other annotations(@Test)
    // and it will run each time before other annotations!!!
    @BeforeMethod
    public void setUpMethod(){
        System.out.println("Before method is running...");
    }

    //Without main method we can run methods with TestNG annotations because we implement it in our pom.xml file!!!
    @Test
    public void test1(){
        System.out.println("Test1 is running...");
    }

    @Test
    public void test2(){
        System.out.println("Test2 is running...");
    }

}
