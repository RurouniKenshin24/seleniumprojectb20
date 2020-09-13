package com.cybertek.tests.day3_locators_continue.zerobank;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task4 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://zero.webappsecurity.com/login.html");

        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password" + Keys.ENTER);

        driver.findElement(By.linkText("Account Activity")).click();

        Thread.sleep(2000);

        String pageTitle = driver.getTitle();
        String expectedTitle = "Zero – Account Activity";

        System.out.println(pageTitle.equals(expectedTitle));

        driver.findElement(By.linkText("Transfer Funds")).click();

        Thread.sleep(2000);

        pageTitle = driver.getTitle();
        expectedTitle = "Zero – Transfer Funds";

        System.out.println(pageTitle.equals(expectedTitle));

        driver.findElement(By.linkText("Pay Bills")).click();

        Thread.sleep(2000);

        pageTitle = driver.getTitle();
        expectedTitle = "Zero - Pay Bills";

        System.out.println(pageTitle.equals(expectedTitle));

        driver.findElement(By.linkText("My Money Map")).click();

        Thread.sleep(2000);

        pageTitle = driver.getTitle();
        expectedTitle = "Zero – My Money Map";

        System.out.println(pageTitle.equals(expectedTitle));

        Thread.sleep(2000);
        driver.findElement(By.linkText("Online Statements")).click();

        pageTitle = driver.getTitle();
        expectedTitle = "Zero – Online Statements";

        System.out.println(pageTitle.equals(expectedTitle));

    }
}
