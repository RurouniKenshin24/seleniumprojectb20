package com.cybertek.tests.day_10_testbase_properties_driverUtil;

import com.cybertek.utilities.BrowserUtilities;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebAlertPractices {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/javascript_alerts");
    }

    @Test
    public void p3_prompt_alert_practice(){
        WebElement JSPromptButton = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        JSPromptButton.click();

        Alert alert = driver.switchTo().alert();

        BrowserUtilities.wait(2);
        String input = "something is happening!!!";

        alert.sendKeys(input);

        alert.accept();

        String actualResult = driver.findElement(By.id("result")).getText();

        Assert.assertTrue(actualResult.contains(input),"The result text is not displayed!!!");
    }
}
