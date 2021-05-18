package com.cybertek.tests.day_10_testbase_properties_driverUtil;

import com.cybertek.utilities.BrowserUtilities;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.SmartBearUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

public class SmartBearTask11 {

    @Test
    public void p11_using_removeNameMethod() throws Exception{
        Properties properties = new Properties();
        FileInputStream file = new FileInputStream("configuration.properties");
        properties.load(file);
        String url = properties.getProperty("smartbearURL");

        Driver.getDriver().get(url);

        SmartBearUtilities.loginToSmartBear(Driver.getDriver());

        BrowserUtilities.wait(2);

        SmartBearUtilities.removeName(Driver.getDriver(),"Steve Johns");

        List<WebElement> listOFNames = Driver.getDriver()
                .findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));

        for (WebElement names: listOFNames) {
            Assert.assertFalse(names.getText().equals("Steve John"));
        }

    }
}
