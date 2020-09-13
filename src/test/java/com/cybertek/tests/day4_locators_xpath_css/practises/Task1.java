package com.cybertek.tests.day4_locators_xpath_css.practises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
    public static void main(String[] args) {

        System.setProperty("web.driver.chrome", System.getProperty("user.dir") + "/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/forgot_password");

        sleep(1);

        WebElement homeLink = driver.findElement(By.cssSelector("a[class=nav-link]"));
        homeLink.click();

        sleep(2);

        driver.navigate().back();

        boolean pageHeader = driver.findElement(By.xpath("//h2[.='Forgot Password']")).isDisplayed();
        String actualPageHeader = driver.findElement(By.xpath("//h2[.='Forgot Password']")).getText();
        String expectedPageHeader = "Forgot Password";

        sleep(1);

        System.out.println(pageHeader);
        System.out.println(actualPageHeader.equals(expectedPageHeader));

        sleep(1);

        String actualEmailText = driver.findElement(By.cssSelector("label[for=email]")).getText();
        String expectedEmailText = "E-mail";

        System.out.println(actualEmailText.equals(expectedEmailText));

        sleep(1);

        WebElement emailInputBox = driver.findElement(By.xpath("//input[@name='email']"));
        emailInputBox.sendKeys("ogzhn_9225@hotmail.com");

        sleep(1);

        WebElement retrieveButton = driver.findElement(By.cssSelector("button[id=form_submit]"));
        retrieveButton.click();

        sleep(1);

        driver.navigate().back();

        WebElement retrieveButtonText = driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']"));
        String actualButtonText = retrieveButtonText.getText();
        String expectedButtonText = "Retrieve password";

        System.out.println(actualButtonText.equals(expectedButtonText));

        sleep(1);

        String actualText = driver.findElement(By.xpath("//div[@style='text-align: center;']")).getText();
        String expectedText = "Powered by Cybertek School";
        System.out.println(actualText.equals(expectedText));
    }

    public static void sleep(int seconds){
        try{
            Thread.sleep(1000*seconds);
        }catch (InterruptedException e){

        }
    }
}
