package com.cybertek.tests.vytrack;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://qa2.vytrack.com/user/login");

        driver.findElement(By.id("prependedInput")).sendKeys("user167");
        Thread.sleep(1000);
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123" + Keys.ENTER);

        String actualTitle = driver.getTitle();
        String expectedTitle = "Dashboard";
        Thread.sleep(1000);

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Logged in");
            driver.get("https://qa2.vytrack.com/entity/Extend_Entity_Carreservation");

            String vehiclesPageTitle = driver.getTitle();
            String expectedPageTitle = "Car - Entities - System - Car - Entities - System";

            if (vehiclesPageTitle.equals(expectedPageTitle)){
                System.out.println("User is on vehicles page");
            }else{
                System.out.println("User cannot go vehicles page");
            }

        }else{
            System.out.println("Could not log in");
            System.exit(0);
        }

    }
}
