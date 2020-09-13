package com.cybertek.tests.day2_locators_getText_getAttribute;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_NavigationsAndTitleVerification {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        //Find element that exact match in anchor html tag(<a </a>)!!!
        driver.findElement(By.linkText("Gmail")).click();

        String gmailTitle = driver.getTitle();

        System.out.println(gmailTitle.contains("Gmail"));

        driver.navigate().back();

        //Find element that partial match in anchor html tag(<a </a>)!!!
        // If there is more than one match just find first one!!!
        driver.findElement(By.partialLinkText("mail")).click();

        gmailTitle = driver.getTitle();

        System.out.println(gmailTitle.contains("Gmail"));

    }
}
