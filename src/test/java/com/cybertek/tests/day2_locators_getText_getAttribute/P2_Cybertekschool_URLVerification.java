package com.cybertek.tests.day2_locators_getText_getAttribute;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P2_Cybertekschool_URLVerification {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        String url = "https://practice.cybertekschool.com";
        driver.get(url);

        String expectedElement = "cybertekschool";
        String actualURL = driver.getCurrentUrl();

        System.out.println(actualURL.contains(expectedElement));
    }
}
