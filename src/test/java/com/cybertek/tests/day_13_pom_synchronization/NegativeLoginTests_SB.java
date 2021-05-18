package com.cybertek.tests.day_13_pom_synchronization;

import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTests_SB {

    LoginPage loginPage;

    @Test(description = "entering incorrect username")
    public void negative_login_to_SB_test1() throws Exception{
        loginPage = new LoginPage();

/*      We do not need to create it because ConfigurationReader has already done it!!!
        FileInputStream file = new FileInputStream("configuration.properties");
        Properties properties = new Properties();
        properties.load(file);*/

        String url = ConfigurationReader.getProperty("smartbearURL");
        Driver.getDriver().get(url);

        loginPage.userNameInput.sendKeys("asjhd");
        loginPage.userPassword.sendKeys("test");
        loginPage.loginButton.click();

        Assert.assertTrue(loginPage.loginErrorMessage.isDisplayed());
    }

    @Test(description = "entering incorrect password")
    public void negative_login_to_SB_test2() throws Exception{
        loginPage = new LoginPage();

        String url = ConfigurationReader.getProperty("smartbearURL");
        Driver.getDriver().get(url);

        loginPage.userNameInput.sendKeys("Tester");
        loginPage.userPassword.sendKeys("jahskdas");
        loginPage.loginButton.click();

        Assert.assertTrue(loginPage.loginErrorMessage.isDisplayed());
    }

    @Test(description = "using login method for negative test")
    public void negative_login_to_SB_test3(){
        loginPage = new LoginPage();

        String url = ConfigurationReader.getProperty("smartbearURL");
        Driver.getDriver().get(url);

        loginPage.login("wrongName","wrongpassword");

        Assert.assertTrue(loginPage.loginErrorMessage.isDisplayed());
    }
}
