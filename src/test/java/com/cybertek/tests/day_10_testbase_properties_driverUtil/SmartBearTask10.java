package com.cybertek.tests.day_10_testbase_properties_driverUtil;

import com.cybertek.utilities.Driver;
import com.cybertek.utilities.SmartBearUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Properties;

public class SmartBearTask10 {

    @Test
    public void p10_edit_order_task() throws Exception {
        Properties properties = new Properties();
        FileInputStream file = new FileInputStream("configuration.properties");
        properties.load(file);
        String url = properties.getProperty("smartbearURL");

        Driver.getDriver().get(url);

        SmartBearUtilities.loginToSmartBear(Driver.getDriver());

        WebElement editBoxOfSteve = Driver.getDriver().findElement(By.xpath("//td[.='Steve Johns']/../td[13]"));
        editBoxOfSteve.click();

        WebElement customerName = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        customerName.clear();
        customerName.sendKeys("Michael Jordan");

        WebElement updateButton = Driver.getDriver().findElement(By.linkText("Update"));
        updateButton.click();
    }
}
