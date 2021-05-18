package com.cybertek.tests.day2_locators_getText_getAttribute;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P4_GoogleSearch {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        //sendKeys() is used for writing something in web!!!
        //Keys.ENTER is used for submitting keys in search box!!!
        driver.findElement(By.name("q")).sendKeys("I am searching in google!" + Keys.ENTER);
        String pageTitle = driver.getTitle();

        System.out.println(pageTitle.equals("I am searching in google! - Google'da Ara"));

    }
}
