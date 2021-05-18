package com.cybertek.tests.day_7_testNG;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerExamples {

    @Test
    public void faker_test(){
        //Faker class creates any type of fake data for testing purposes!!!
        Faker fakeDataCreator = new Faker();

        String firstName = fakeDataCreator.name().firstName();
        System.out.println("firstName = " + firstName);

        String userName = fakeDataCreator.name().username();
        System.out.println("userName = " + userName);

        String fullName = fakeDataCreator.name().fullName();
        System.out.println("fullName = " + fullName);

        String address = fakeDataCreator.address().fullAddress();
        System.out.println("address = " + address);

        String house = fakeDataCreator.gameOfThrones().house();
        System.out.println("house = " + house);

        String fact = fakeDataCreator.chuckNorris().fact();
        System.out.println("fact = " + fact);
    }
}
