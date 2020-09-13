package com.cybertek.tests.day_5_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LocatorsFindElements {
    public static void main(String[] args) {
        System.setProperty("web.driver.chrome", System.getProperty("user.dir") + "/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //"findElements()" method provides list of web elements.
        // It finds more than one located element with locators!!!
        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));

        System.out.println("Number of Links:" + listOfLinks.size());

        for (WebElement each: listOfLinks){
            System.out.println("Link name = " + each.getText());
        }
    }
}
