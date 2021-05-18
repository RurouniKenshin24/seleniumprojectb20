package com.cybertek.tests.day_10_testbase_properties_driverUtil;

import com.cybertek.tests.base.TestBase;
import com.cybertek.utilities.SmartBearUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

public class SmartBearTask9 extends TestBase {

    @Test
    public void p9_delete_order_task() throws Exception {
        Properties properties = new Properties();
        FileInputStream file = new FileInputStream("configuration.properties");
        properties.load(file);
        String url = properties.getProperty("smartbearURL");
        driver.get(url);

        SmartBearUtilities.loginToSmartBear(driver);

        WebElement checkBox = driver.findElement(By.xpath("//td[.='Mark Smith']/../td[1]"));
        //WebElement checkBox = driver.findElement(By.xpath("//td[.='Mark Smith']/preceding-sibling::td[1]"));
        //driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr[2]//td[1]"));
        checkBox.click();

        WebElement deleteButton = driver.findElement(By.id("ctl00_MainContent_btnDelete"));
        deleteButton.click();

        List<WebElement> listOFNames = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));

        for (WebElement names: listOFNames) {
            Assert.assertFalse(names.getText().equals("Mark Smith"));
        }
    }

}
