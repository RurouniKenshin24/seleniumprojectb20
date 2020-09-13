package com.cybertek.tests.day3_locators_continue.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task4 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");

        sleep(2);

        String actualLink = driver.findElement(By.className("_8esh")).getAttribute("href");
        String expectedLink = "registration_form";

        System.out.println(actualLink.contains(expectedLink));
    }

    public static void sleep(int seconds){
        try{
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){

        }
    }
}
