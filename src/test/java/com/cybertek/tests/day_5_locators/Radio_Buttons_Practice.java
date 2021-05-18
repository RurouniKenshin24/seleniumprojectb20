package com.cybertek.tests.day_5_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Radio_Buttons_Practice {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethods(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/radio_buttons");
    }

    @AfterMethod
    public void tearDownMethods() throws Exception{
        Thread.sleep(2000);
//        driver.close();
    }

    @Test
    public void radioButtonTest(){
        List<WebElement> radioButtons = driver.findElements(By.xpath("//label[@class='form-check-label']"));
        WebElement radioButton = driver.findElement(By.id("red"));
        radioButton.click();

        for (WebElement button: radioButtons){
            wait(2);
            button.click();
            System.out.println(button.getText());
        }
    }

    static void wait(int seconds){
        try{
            Thread.sleep(seconds * 1000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
