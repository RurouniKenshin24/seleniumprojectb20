package com.cybertek.tests.day1_selenium_intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {

        //WebDriverManager.chromedriver().setup();

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        String title =  driver.getTitle();
        System.out.println("Title of this page is" + title);

        String url = driver.getCurrentUrl();
        System.out.println("URL of this page is " + url);

        driver.get("https://www.facebook.com");

        Thread.sleep(2000);
        driver.navigate().back();

        Thread.sleep(2000);
        driver.navigate().forward();

        driver.navigate().refresh();

        Thread.sleep(3000);
        driver.navigate().to("https://instagram.com");

        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);
    }

}
