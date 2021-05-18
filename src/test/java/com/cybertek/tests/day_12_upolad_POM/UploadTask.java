package com.cybertek.tests.day_12_upolad_POM;

import com.cybertek.utilities.BrowserUtilities;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Properties;

public class UploadTask {

    @Test
    public void p1_upload_test() throws Exception {
        FileInputStream file = new FileInputStream("configuration.properties");
        Properties properties = new Properties();
        properties.load(file);

        String url = ConfigurationReader.getProperty("uploadURL");

        Driver.getDriver().get(url);
        Driver.getDriver().manage().window().maximize();

        String path ="C:\\Users\\ogzhn.DESKTOP-KPJS3PT\\Downloads\\LevelsinIT.png";
        WebElement fileInput = Driver.getDriver().findElement(By.id("file-upload"));
        BrowserUtilities.wait(1);
        fileInput.sendKeys(path);

        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));
        BrowserUtilities.wait(2);
        uploadButton.click();

        String actualText = Driver.getDriver().findElement(By.id("uploaded-files")).getText();
        String expectedText = "LevelsinIT.png";

        Assert.assertEquals(actualText,expectedText);
    }
}
