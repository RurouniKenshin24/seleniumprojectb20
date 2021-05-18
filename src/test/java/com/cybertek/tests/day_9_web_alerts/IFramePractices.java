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

public class IFramePractices {
    WebDriver driver;
    Alert alert;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/iframe");
    }

    @Test
    public void p1_IFrame_test(){
//        driver.switchTo().frame(0);

//        driver.switchTo().frame("mce_0_ifr");

        WebElement iFrame = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrame);

        String defaultMessage = driver.findElement(By.xpath("//p")).getText();
        String expectedMessage = "Your content goes here.";

        BrowserUtilities.wait(1);

        Assert.assertTrue(defaultMessage.equalsIgnoreCase(expectedMessage));

        driver.switchTo().parentFrame();
        //driver.switchTo().defaultContent(); It has same function but return first html frame!!!

        String actualEditor = driver.findElement(By.tagName("h3")).getText();
        String expectedEditor = "An iFrame containing the TinyMCE WYSIWYG Editor";

        Assert.assertTrue(actualEditor.equalsIgnoreCase(expectedEditor));
    }

}
