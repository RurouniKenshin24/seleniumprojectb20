package com.cybertek.tests.day_11_utils_review_action;

import com.cybertek.utilities.BrowserUtilities;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionPractices {

    /*
   TC #15: Hover Test
   1. Go to http://practice.cybertekschool.com/hovers
   2. Hover over to first image
   3. Assert:
       a. "name: user1" is displayed
   4. Hover over to second image
   5. Assert:
       a. "name: user2" is displayed
   6. Hover over to third image
   7. Confirm:
       a. "name: user3" is displayed
    */

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        BrowserUtilities.wait(1);

    }

    @Test
    public void hover_over_test(){
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1 = driver.findElement(By.xpath("(//div[@class='figure'])[1]"));
        WebElement img2 = driver.findElement(By.xpath("(//div[@class='figure'])[2]"));
        WebElement img3 = driver.findElement(By.xpath("(//div[@class='figure'])[3]"));

        WebElement user1 = driver.findElement(By.xpath("//h5[.='name: user1']"));
        WebElement user2 = driver.findElement(By.xpath("//h5[.='name: user2']"));
        WebElement user3 = driver.findElement(By.xpath("//h5[.='name: user3']"));

        Actions actions = new Actions(driver);

        BrowserUtilities.wait(2);

        actions.moveToElement(img1).perform();
        Assert.assertTrue(user1.isDisplayed());

        BrowserUtilities.wait(2);

        actions.moveToElement(img2).perform();
        Assert.assertTrue(user2.isDisplayed());

        BrowserUtilities.wait(2);

        actions.moveToElement(img3).perform();
        Assert.assertTrue(user3.isDisplayed());
    }
}
