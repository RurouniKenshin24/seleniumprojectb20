package com.cybertek.tests.day_6_testNG;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Dropdown_Intro {

    /*

    TC#1: Verifying “Simple dropdown” and “State selection” dropdown default values

    1. Open Chrome browser
    2. Go to http://practice.cybertekschool.com/dropdown
    3. Verify “Simple dropdown” default selected value is correct
    Expected: “Please select an option”
    4. Verify “State selection” default selected value is correct
    Expected: “Select a State”

     */

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {

        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void dropdownTest1(){

        WebElement dropdownObject = driver.findElement(By.id("dropdown"));
        Select simpleDropdown = new Select(dropdownObject);

        simpleDropdown.selectByVisibleText("Option 2");

        String actualDefaultText = simpleDropdown.getFirstSelectedOption().getText();
        String expectedDefaultText = "Please select an option";

        Assert.assertEquals(actualDefaultText,expectedDefaultText);
    }

    @Test
    public void dropDownTest2(){
        WebElement dropdownObject = driver.findElement(By.id("state"));
        Select stateDropdown = new Select(dropdownObject);

        String actualDefaultText = stateDropdown.getFirstSelectedOption().getText();
        String expectedDefaultText = "Select a State";

        Assert.assertEquals(actualDefaultText,expectedDefaultText);
    }
}
