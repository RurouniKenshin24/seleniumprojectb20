package com.cybertek.tests.day4_locators_xpath_css;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WarmUpTask {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //driver.findElement(By.name("email")).sendKeys("ogzhn_9225@hotmail.com");

        //This is the same thing which we made above with easier way!!!
        WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys("ogzhn_9225@hotmail.com");

        sleep(1);

        //driver.findElement(By.id("form_submit")).click();

        //This is the same thing which we made above with easier way!!!
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        sleep(2);

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "email_sent";

        System.out.println(actualURL.contains(expectedURL));

        sleep(1);

        String actualText = driver.findElement(By.name("confirmation_message")).getText();
        String expectedText = "Your e-mail's been sent!";

        System.out.println(actualText.equals(expectedText));

        //boolean result = driver.findElement(By.name("confirmation_message")).isDisplayed();
        //This is the same thing which we made above with easier way!!!
        WebElement confirmationMessage = driver.findElement(By.name("confirmation_message"));
        boolean result = confirmationMessage.isDisplayed();
        System.out.println("Confirmation Message is showed: " + result);


    }

    public static void sleep(int seconds){
        try{
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){

        }
    }
}
