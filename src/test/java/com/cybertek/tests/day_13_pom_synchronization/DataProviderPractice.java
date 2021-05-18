package com.cybertek.tests.day_13_pom_synchronization;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

    @Test(description = "Verifying page title", dataProvider = "testData")
    public void test_page_title(String url, String title){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get(url);

        Assert.assertTrue(driver.getTitle().contains(title));
    }

    @DataProvider(name = "testData")
    public Object[][] testData(){
        return new Object[][] {{"http://www.google.com","Google"},
                               {"http://www.amazon.com","Amazon"},
                               {"http://www.etsy.com","Etsy"}};
    }


}
