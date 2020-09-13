package com.cybertek.tests.day3_locators_continue.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");

        driver.findElement(By.id("email")).sendKeys("turkozbusra@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("kalem123++" + Keys.ENTER);

        sleep(2);

        String pageTitle = driver.getTitle();
        String expectedTitle = "Facebook'a Giriş Yap | Facebook";
        System.out.println(pageTitle.equals(expectedTitle));

    }

    public static void sleep(int seconds){
        try {
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){

        }
    }
}
