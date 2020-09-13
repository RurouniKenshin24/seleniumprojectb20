package com.cybertek.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    public static WebDriver getDriver(String browserType){

        if (browserType.equalsIgnoreCase("chrome")){
            System.setProperty("web.driver.chrome", System.getProperty("user.dir") + "/chromedriver.exe");
            return new ChromeDriver();
        }else if(browserType.equalsIgnoreCase("firefox")){
            System.setProperty("web.driver.firefox", System.getProperty("user.dir") + "/firefoxdriver.exe");
            return new FirefoxDriver();
        }else{
            System.out.println("Given browser does not exist!!!");
            return null;
        }
    }
}
