package com.cybertek.tests.day_5_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practise {
    public static void main(String[] args) {
        System.setProperty("web.driver.chrome", System.getProperty("user.dir") + "/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        //"//div(tagName)[@attribute='value']/Sub tagName" we can use this syntax to reach
        // child web element from parent web element!!! In cssSelector we use ">" sign instead of "/"!!!
        driver.findElement(By.xpath("//div[@class='gb_h gb_i']/a")).click();

        driver.navigate().back();

        //Moreover if there is "div" tagName  more than one in one parent tag we can use "xpath/div[indexNumber]"!!!
        //If the web elements are not siblings to each other, then we need to put the locator inside of
        // parenthesis"()", Then we pass index number!!! "(xpath/div)[indexNumber]"
        driver.findElement(By.xpath("(//div[@class='gb_9d gb_i gb_og gb_fg']/div)[1]/a")).click();

        //On the other hand if we want to reach parent web element from child, we can use this syntax;
        // "Sub tagName[@attribute'value']/.." It means go back to parent web element!!!


    }
}
