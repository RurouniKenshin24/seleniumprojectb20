package com.cybertek.tests.day1_selenium_intro;

import org.openqa.selenium.chrome.ChromeDriver;

public class WarmUpTask01 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();

        String url1 = "https://www.google.com";

        driver.get(url1);
        if (driver.getTitle().equals("Google")){
            System.out.println(true);
        }else{
            System.out.println(false);
        }

        String url2 = "https://practice.cybertekschool.com";

        driver.get(url2);

        System.out.println(url2.contains("cybertekschool"));
    }
}
