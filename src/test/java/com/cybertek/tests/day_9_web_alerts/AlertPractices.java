package com.cybertek.tests.day_9_web_alerts;

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

public class AlertPractices {

    WebDriver driver;
    Alert alert;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/javascript_alerts");
    }

    @Test
    public void p1_information_page_alert_practice(){
        WebElement JSAlertButton = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        JSAlertButton.click();

        alert = driver.switchTo().alert();

        BrowserUtilities.wait(2);
        alert.accept();

        WebElement result = driver.findElement(By.id("result"));
        String actualMessage = result.getText();
        String expectedMessage = "You successfuly clicked an alert";

        Assert.assertTrue(result.isDisplayed());
        Assert.assertEquals(actualMessage,expectedMessage,"Messages are not matching!!!");
    }

    @Test
    public void p2_information_page_alert_practice(){
        WebElement JSConfirmButton = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        JSConfirmButton.click();

        alert = driver.switchTo().alert();

        BrowserUtilities.wait(2);
        alert.accept();

        String actualMessage = driver.findElement(By.id("result")).getText();
        WebElement result = driver.findElement(By.id("result"));
        String expectedMessage = "You successfuly clicked an alert";

        Assert.assertTrue(result.isDisplayed());
        Assert.assertEquals(actualMessage,expectedMessage,"Messages are not matching!!!");    }

    @Test
    public void p3_information_page_alert_practice(){
        WebElement JSPromptButton = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        JSPromptButton.click();

        alert = driver.switchTo().alert();

        BrowserUtilities.wait(2);
        alert.sendKeys("hello");
        BrowserUtilities.wait(1);
        alert.accept();
//        alert.dismiss();

        String actualMessage = driver.findElement(By.id("result")).getText();
        WebElement result = driver.findElement(By.id("result"));
        String expectedMessage = "You successfuly clicked an alert";

        Assert.assertTrue(result.isDisplayed());
        Assert.assertEquals(actualMessage,expectedMessage,"Messages are not matching!!!");
    }
}
