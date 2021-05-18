package com.cybertek.tests.day_12_upolad_POM;

import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Properties;

public class PageObjectModelPractice {

    @Test
    public void login_to_smartbear() throws Exception {
        LoginPage loginPage = new LoginPage();

        FileInputStream file = new FileInputStream("configuration.properties");
        Properties properties = new Properties();
        properties.load(file);

        String url = ConfigurationReader.getProperty("smartbearURL");

        Driver.getDriver().get(url);

        loginPage.userNameInput.sendKeys("Tester");
        loginPage.userPassword.sendKeys("test");
        loginPage.loginButton.click();

    }
}
