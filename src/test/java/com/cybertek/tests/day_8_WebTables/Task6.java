package com.cybertek.tests.day_8_WebTables;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task6 {

    WebDriver driver;
    Faker faker;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/registration_form");
    }

    @Test
    public void test1(){
        WebElement firstNameInput = driver.findElement(By.xpath("//input[@name='firstname']"));
        WebElement lastNameInput = driver.findElement(By.name("lastname"));
        WebElement userNameInput = driver.findElement(By.name("username"));
        WebElement emailInput = driver.findElement(By.name("email"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement phoneNumberInput = driver.findElement(By.name("phone"));

        firstNameInput.sendKeys(faker.name().firstName());
        lastNameInput.sendKeys(faker.name().lastName());
        userNameInput.sendKeys(faker.name().username());
        emailInput.sendKeys(faker.internet().emailAddress());
    }
}
