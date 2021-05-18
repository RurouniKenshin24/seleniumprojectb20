package com.cybertek.tests.day_5_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HeadlessBrowserTest {
    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://www.googlr.com");

        WebElement searchBox = driver.findElement(By.name("q"));

        searchBox.sendKeys("Guru99" + Keys.ENTER);

        System.out.println("Page title: " + driver.getTitle());

        driver.close();
    }
}
