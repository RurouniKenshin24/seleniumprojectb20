package com.cybertek.tests.day_6_testNG;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro {

    //"@BeforeMethod" annotation is used with other annotations(@Test) for setting up something (driver, wait)
    // and it will run each time before other annotations!!!
    @BeforeMethod
    public void setUpMethod(){
        System.out.println("Before method is running...");
    }

    //"@BeforeMethod" annotation is used with other annotations(@Test) for tearing down something(close, quit)
    // and it will run each time after other annotations!!!
    @AfterMethod
    public void tearDownMethod(){
        System.out.println("After method is running...");
    }

    //"@BeforeClass"annotation is used for just one and it will run before everything!!!
    @BeforeClass
    public void tearDownClass(){
        System.out.println("Before class is running...");
    }

    //"@AfterClass"annotation is used for just one and it will run after everything!!!
    @AfterClass
    public void setUpClass(){
        System.out.println("After class is running...");
    }

    //Without main method we can run methods with TestNG annotations because we implement it in our pom.xml file!!!
    @Test
    public void test1(){
        System.out.println("Test1 is running...");
    }

    //Each test
    @Test
    public void test2(){
        System.out.println("Test2 is running...");
    }

    //Each test will run in an alphabetic order!!! So the test below will run first!!!
    // However we can specify priority in between them!!!
    @Test
    public void test(){
        System.out.println("Test is running");
    }

    //"Assert.assertTrue(boolean)" is used for verify whether test passed or not!!!
    //Moreover, if we want to add message(String) after put comma in args!!!
    //If we put many assertions in one test and one them failed,
    //others which after failed assertion will NOT RUN!!!
    @Test
    public void test3(){
        String str1 = "TestNG";
        String str2 = "TestNG";
        String str3 = "Test";

        Assert.assertTrue(str1.equals(str2),"Str1 is not equal Str2!");
        //Assert.assertTrue(str1.equals(str3), "Str1 is not equal Str3!");
        // The test below is the same thing so we don't need it anymore!!!

        //These methods compare two String objects without using extra equal method
        // or int, double etc variables!!!
        Assert.assertEquals(str1,str2);
        Assert.assertEquals(str1,str3,"Str1 is not equal Str3!");
    }
}
