package com.cybertek.tests.day_12_upolad_POM;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Properties;

public class ActionTask2 {

    @Test
    public void p4_context_click_test() throws Exception {
        Properties properties = new Properties();
        FileInputStream file = new FileInputStream("configuration.properties");
        properties.load(file);

        String url = ConfigurationReader.getProperty("contextURL");

        Driver.getDriver().get(url);

        Actions actions = new Actions(Driver.getDriver());

        WebElement contextBox = Driver.getDriver().findElement(By.id("hot-spot"));
        actions.contextClick(contextBox).perform();

        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }
}
