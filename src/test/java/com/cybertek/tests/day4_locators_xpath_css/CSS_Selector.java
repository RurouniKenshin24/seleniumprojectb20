package com.cybertek.tests.day4_locators_xpath_css;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSS_Selector {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.amazon.com");

        //cssSelector
        // 1-) Syntax "tagName[attribute="value"]";
        WebElement searchBoxItem1 = driver.findElement(By.cssSelector("input[id=twotabsearchtextbox]"));
        searchBoxItem1.sendKeys("Wooden Spoon" + Keys.ENTER);

        Thread.sleep(2000);

        // 2-) Syntax "tagName.classValue" or "tagName#idValue"!
        // "." stands for class attribute and "#" stands for id attribute;
        WebElement searchBoxItem2 = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
        searchBoxItem2.sendKeys("Metal Spoon" + Keys.ENTER);
    }
}
