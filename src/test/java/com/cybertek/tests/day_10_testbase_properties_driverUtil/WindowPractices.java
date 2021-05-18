package com.cybertek.tests.day_10_testbase_properties_driverUtil;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowPractices {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/windows");

        String title1 = driver.getTitle();
        Assert.assertTrue(title1.equalsIgnoreCase("Practice"));

        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();

        String windowID = driver.getWindowHandle();
        System.out.println("windowID = " + windowID);

        Set<String> setOfWindow = driver.getWindowHandles();

        for (String each: setOfWindow) {
            driver.switchTo().window(each);
            String actualNewTitle = driver.getTitle();
            System.out.println("Current Title: " + actualNewTitle);
        }

        //It switches back to main page!!!
        driver.switchTo().window(windowID);

        //It closes just current tab/window!!!
        driver.close();

        //It closes all tabs/windows!!!
        driver.quit();

    }

    @Test
    public void test2(){
        driver.get("https://www.amazon.com");

        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");


        Set<String> setOfWindows = driver.getWindowHandles();

        for (String each : setOfWindows) {
            driver.switchTo().window(each);
            if (driver.getCurrentUrl().contains("Etsy")){
                Assert.assertTrue(driver.getTitle().contains("Etsy"));
                break;
            }
        }
    }


}
