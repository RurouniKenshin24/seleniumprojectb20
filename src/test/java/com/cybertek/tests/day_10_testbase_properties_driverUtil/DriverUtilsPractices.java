package com.cybertek.tests.day_10_testbase_properties_driverUtil;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DriverUtilsPractices {

    @Test
    public void simple_google_search_test(){
        Driver.getDriver().get("https://www.google.com");

        WebElement searchBox = Driver.getDriver().findElement(By.name("q"));
        searchBox.sendKeys("Oguzhan Celik" + Keys.ENTER);
    }

}
