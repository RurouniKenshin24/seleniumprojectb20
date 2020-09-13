package com.cybertek.tests.day3_locators_continue.zerobank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
    public static void main(String[] args) {
        System.setProperty("web.driver.chrome", System.getProperty("user.dir") + "/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://zero.webappsecurity.com/login.html");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Zero - Log in";

        System.out.println(actualTitle.equals(expectedTitle));

        sleep(2);

        driver.get("http://zero.webappsecurity.com/login.html");

        String actualLinkText = driver.findElement(By.className("brand")).getText();
        String expectedLinkText = "Zero Bank";

        System.out.println(actualLinkText.equals(expectedLinkText));

        sleep(1);

        String actualValue = driver.findElement(By.className("brand")).getAttribute("href");
        String expectedValue = "index.html";

        System.out.println(actualValue.contains(expectedValue));
    }

    public static void sleep(int seconds){
        try{
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){

        }
    }
}
