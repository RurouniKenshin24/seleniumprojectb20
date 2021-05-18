package com.cybertek.tests.day_13_pom_synchronization;

import com.cybertek.pages.Loading7Page;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Synchronization_Practices {

    Loading7Page loading7Page;

    @Test
    public void explicit_wait_test(){

        loading7Page = new Loading7Page();

        String url = ConfigurationReader.getProperty("explicitwaitURL");
        Driver.getDriver().get(url);

        WebDriverWait wait =  new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.titleIs("Dynamic title"));

        Assert.assertTrue(loading7Page.doneMessage.isDisplayed());
        Assert.assertTrue(loading7Page.image.isDisplayed());

    }
}
