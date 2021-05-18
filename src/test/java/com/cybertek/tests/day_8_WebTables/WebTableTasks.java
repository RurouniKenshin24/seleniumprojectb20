package com.cybertek.tests.day_8_WebTables;

import com.cybertek.utilities.SmartBearUtilities;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebTableTasks {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearUtilities.loginToSmartBear(driver);
    }

    @Test
    public void Task3(){
        driver.findElement(By.linkText("View all orders")).click();

        WebElement dateOfOrderForSusan = driver.findElement(By.xpath("//td[.='Susan McLaren']/following-sibling::td[3]"));
        String actualDate = dateOfOrderForSusan.getText();
        String expectedDate = "01/05/2010";

        System.out.println(actualDate);
        Assert.assertEquals(actualDate,expectedDate,"Dates are not matching!!!");
    }

    @Test
    public void Task4(){
        SmartBearUtilities.verifyOrder(driver,"Mark Smith");

        SmartBearUtilities.printNamesAndCities(driver);
    }
}
