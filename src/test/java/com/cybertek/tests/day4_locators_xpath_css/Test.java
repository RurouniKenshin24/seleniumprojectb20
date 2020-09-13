package com.cybertek.tests.day4_locators_xpath_css;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class Test {
    public static void main(String[] args) {

        WebDriver driver1 = WebDriverFactory.getDriver("chrome");
        WebDriver driver2 = WebDriverFactory.getDriver("explorer");
    }
}
