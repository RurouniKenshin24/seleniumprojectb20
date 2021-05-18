package com.cybertek.tests.day_9_web_alerts;

import com.cybertek.utilities.BrowserUtilities;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownPractices {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void p7_dropdown_default_value_test(){
        WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
        Select monthDropDown = new Select(month);

        String expectedMonth = LocalDateTime.now().getMonth().name();
        String actualMonth = monthDropDown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualMonth.toLowerCase(),expectedMonth.toLowerCase());

        List<WebElement> monthOptions = monthDropDown.getOptions();
        List<String> actualOptions = new ArrayList<>();

        /*
        for (WebElement each : monthOptions) {
            actualOptions.add(each.getText());
        }*/

        actualOptions = BrowserUtilities.getElementText(monthOptions);

        List<String> expectedOptions = Arrays.asList("January","February","March","April","May","June","July","August"
                ,"September","October","November","December");

        //"assertEquals" accept list type collection and first check size and values of them!!!
        Assert.assertEquals(actualOptions,expectedOptions);
    }
}
