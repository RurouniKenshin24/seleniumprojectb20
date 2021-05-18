package com.cybertek.tests.day_7_testNG;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task1 {

        WebDriver driver;

        @BeforeMethod
        public void setUpMethods(){
            driver = WebDriverFactory.getDriver("chrome");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.get("http://practice.cybertekschool.com/dropdown");
        }

        @AfterMethod
        public void tearDownMethods() throws Exception{
            Thread.sleep(2000);
            driver.close();
        }

    @Test
    public void test1(){
        WebElement dropdownMenu = driver.findElement(By.id("dropdown"));
        Select simpleDropdownMenu = new Select(dropdownMenu);

        String actualText = simpleDropdownMenu.getFirstSelectedOption().getText();
        String expectedText = "Please select an option";

        Assert.assertEquals(actualText,expectedText,"Verification Failed!!!");
    }

    @Test
    public void test2(){
        WebElement dropdownMenu = driver.findElement(By.id("state"));
        Select stateDropdownMenu = new Select(dropdownMenu);

        String actualSelection = stateDropdownMenu.getFirstSelectedOption().getText();
        String expectedSelection = "Select a State";

        Assert.assertEquals(actualSelection,expectedSelection,"Verification Failed!!!");
    }

    @Test
    public void test3() throws InterruptedException {
        WebElement dropdownMenu = driver.findElement(By.id("state"));
        Select stateDropdownMenu = new Select(dropdownMenu);

        stateDropdownMenu.selectByVisibleText("Illinois");
        Thread.sleep(1000);
        stateDropdownMenu.selectByValue("VA");
        Thread.sleep(1000);
        stateDropdownMenu.selectByIndex(5);

        String actualSelection = stateDropdownMenu.getFirstSelectedOption().getText();
        String expectedSelection = "California";

        Assert.assertEquals(actualSelection,expectedSelection,"States are not matching! Verification Failed");
    }

    @Test
    public void test4(){

        WebElement dropdownMenu1 = driver.findElement(By.id("year"));
        WebElement dropdownMenu2 = driver.findElement(By.id("month"));
        WebElement dropdownMenu3 = driver.findElement(By.id("day"));

        Select yearDropdownMenu = new Select(dropdownMenu1);
        Select monthDropdownMenu = new Select(dropdownMenu2);
        Select dayDropdownMenu = new Select(dropdownMenu3);

        yearDropdownMenu.selectByVisibleText("1922");
        monthDropdownMenu.selectByValue("11");
        dayDropdownMenu.selectByIndex(0);

        String actualYear = yearDropdownMenu.getFirstSelectedOption().getText();
        String actualMonth = monthDropdownMenu.getFirstSelectedOption().getText();
        String actualDay = dayDropdownMenu.getFirstSelectedOption().getText();

        String expectedYear = "1922";
        String expectedMonth = "December";
        String expectedDay = "1";

        Assert.assertEquals(actualYear,expectedYear,"Years are not matching!!!");
        Assert.assertEquals(actualMonth,expectedMonth,"Months are not matching!!!");
        Assert.assertEquals(actualDay,expectedDay,"Days are not matching!!!");
    }

    @Test
    public void test5() throws InterruptedException {
        WebElement dropdownMenu = driver.findElement(By.name("Languages"));
        Select multipleDropdownMenu = new Select(dropdownMenu);

        List<WebElement> languageList = multipleDropdownMenu.getOptions();

        for (WebElement each: languageList){
            each.click();
        }

        Thread.sleep(1000);

        multipleDropdownMenu.deselectAll();
    }

    @Test
    public void test6() throws InterruptedException {
        driver.findElement(By.xpath("//a[@id='dropdownMenuLink']")).click();

        WebElement facebookLink = driver.findElement(By.xpath("//a[contains(@href,'facebook')]"));
        facebookLink.click();

        Thread.sleep(1000);

        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebook - Log In or Sign Up";

        Assert.assertEquals(actualTitle,expectedTitle);
    }
}
