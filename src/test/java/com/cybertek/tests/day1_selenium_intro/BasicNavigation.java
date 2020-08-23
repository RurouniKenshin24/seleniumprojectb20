package com.cybertek.tests.day1_selenium_intro;

import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.com.driver", System.getProperty("user.dir") + "/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.tr724.com");

        Thread.sleep(2000);
        driver.close();


    }
}
