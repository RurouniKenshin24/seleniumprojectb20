package com.cybertek.tests.day_6_testNG;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNG_Practices {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://www.google.com");
    }

    @Test
    public void google_title_verification(){

        String actualGoogleTitle = driver.getTitle();
        String expectedGoogleTitle = "Google";

        Assert.assertEquals(actualGoogleTitle,expectedGoogleTitle,"Titles are not matching!!!");
    }

    @Test
    public void google_search_title_verification(){

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("apple" + Keys.ENTER);

        String actualTitle = driver.getTitle();
        String expectedTitle = "apple";

        Assert.assertEquals(actualTitle,expectedTitle,"Titles are not matching!!!");

    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }
}
