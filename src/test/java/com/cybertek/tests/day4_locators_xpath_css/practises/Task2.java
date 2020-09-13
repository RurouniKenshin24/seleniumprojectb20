package com.cybertek.tests.day4_locators_xpath_css.practises;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {
    public static void main(String[] args) {
        System.setProperty("web.driver.chrome", System.getProperty("user.dir") + "/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com");

        sleep(1);

        WebElement searchBox = driver.findElement(By.cssSelector("input[type=text]"));
        searchBox.sendKeys("Game" + Keys.ENTER);
    }

    public static void sleep(int seconds){
        try{
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}
