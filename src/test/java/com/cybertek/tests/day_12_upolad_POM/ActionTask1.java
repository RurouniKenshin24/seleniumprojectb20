package com.cybertek.tests.day_12_upolad_POM;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Properties;

public class ActionTask1 {

    @Test
    public void p2_double_click_test() throws Exception {
        Properties properties = new Properties();
        FileInputStream file = new FileInputStream("configuration.properties");
        properties.load(file);

        String url = ConfigurationReader.getProperty("doubleclickURL");
        Driver.getDriver().get(url);

        Driver.getDriver().switchTo().frame("iframeResult");

        Actions actions = new Actions(Driver.getDriver());
        WebElement element = Driver.getDriver().findElement(By.id("demo"));

        actions.doubleClick(element).perform();

        String actualColor = Driver.getDriver().findElement(By.xpath("//p[@style='color: red;']")).getAttribute("style");
        String expectedColor = "red";

        System.out.println("actualColor = " + actualColor);

        Assert.assertTrue(actualColor.contains(expectedColor));

    }
}
