package com.cybertek.tests.day_6_testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class P05_SeleniumEasy_Task1 {
    public static void main(String[] args) {
        System.setProperty("web.driver.chrome", System.getProperty("user.dir") + "/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Instead of "Thread.sleep()" method this one is more useful!!!
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement checkBox1 = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
        WebElement successMessage = driver.findElement(By.xpath("//div[@id='txtAge']"));

        if (!successMessage.isDisplayed()){
            System.out.println("Message is NOT displayed.\nVerification PASSED");
        }else{
            System.out.println("Message is displayed.\nVerification FAILED!!!");
        }

        checkBox1.click();

        if (successMessage.isDisplayed()){
            System.out.println("Message is displayed.\nVerification PASSED");
        }else{
            System.out.println("Message is NOT displayed.\nVerification FAILED!!!");
        }

        driver.close();
    }
}
