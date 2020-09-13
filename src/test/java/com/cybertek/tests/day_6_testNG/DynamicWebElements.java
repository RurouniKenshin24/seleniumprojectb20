package com.cybertek.tests.day_6_testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebElements {
    public static void main(String[] args) {
        System.setProperty("web.driver.chrome", System.getProperty("user.dir") + "/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        //"//tagName[contains(@attribute, 'attribute value')]" It provides handling with dynamic web elements!!!
        driver.findElement(By.xpath("//input[contains(@data-ved, 'UDCAc')]"));


    }
}
