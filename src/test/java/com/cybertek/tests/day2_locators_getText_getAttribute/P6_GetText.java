package com.cybertek.tests.day2_locators_getText_getAttribute;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P6_GetText {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://zero.webappsecurity.com/login.html");

        //getText() provides text where between the tags we search and returns string!!!
        String str1 = driver.findElement(By.tagName("h3")).getText();
        System.out.println(str1);

        //getAttribute() provides value attribute that we search and returns string!!!
        String str2 = driver.findElement(By.name("user_remember_me")).getAttribute("id");
        String expectedIdValue = "user_remember_me";

        System.out.println(str2.equals(expectedIdValue));

        str2 = driver.findElement(By.name("user_remember_me")).getAttribute("tabindex");
        expectedIdValue = "3";

        System.out.println(str2.equals(expectedIdValue));

    }
}
