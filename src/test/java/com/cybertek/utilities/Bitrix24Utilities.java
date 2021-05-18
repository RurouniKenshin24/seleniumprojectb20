package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Bitrix24Utilities {

    public static void loginToBitrix24(WebDriver driver){
        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));

        userName.sendKeys("helpdesk17@cybertekschool.com");
        password.sendKeys("UserUser");

        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
    }

    public static void clickOnMessageTab(WebDriver driver){
        WebElement messageTab = driver.findElement(By.id("feed-add-post-form-tab-message"));
        messageTab.click();
    }
}
