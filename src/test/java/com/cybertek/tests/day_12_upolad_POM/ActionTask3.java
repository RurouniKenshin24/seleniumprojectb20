package com.cybertek.tests.day_12_upolad_POM;

import com.cybertek.utilities.BrowserUtilities;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Properties;

public class ActionTask3 {

    @Test
    public void p3_drag_drop_test() throws Exception {
        Properties properties = new Properties();
        FileInputStream file = new FileInputStream("configuration.properties");
        properties.load(file);

        String url = ConfigurationReader.getProperty("dragdropURL");
        Driver.getDriver().get(url);

        Driver.getDriver().manage().window().maximize();

        BrowserUtilities.wait(1);
        WebElement cookiesBox = Driver.getDriver().findElement(By.id("onetrust-accept-btn-handler"));
        cookiesBox.click();

        Actions actions = new Actions(Driver.getDriver());

        WebElement source = Driver.getDriver().findElement(By.id("draggable"));
        WebElement target = Driver.getDriver().findElement(By.id("droptarget"));

        BrowserUtilities.wait(1);

        actions.dragAndDrop(source, target).perform();

        BrowserUtilities.wait(2);

        String actualResult = target.getText();
        String expectedResult = "You did great!";

        Assert.assertEquals(actualResult,expectedResult);
    }
}
