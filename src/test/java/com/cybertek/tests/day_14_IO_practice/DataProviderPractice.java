package com.cybertek.tests.day_14_IO_practice;

import com.cybertek.utilities.Driver;
import com.cybertek.utilities.ExcelUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DataProviderPractice {

    @FindBy(id = "prependedInput")
    private WebElement userNameElement;

    @FindBy(id = "prependedInput2")
    private WebElement passwordElement;

    @Test(dataProvider = "userDataTest")
    public void ddtLoginTest1(String userName, String password){
/*
        userNameElement.sendKeys("storemanager85");
        passwordElement.sendKeys("UserUser123", Keys.ENTER);
*/

        userNameElement.sendKeys(userName);
        passwordElement.sendKeys(password, Keys.ENTER);

        System.out.println(Driver.getDriver().getTitle());
    }

    @Test(dataProvider = "userDataTestFromExcel")
    public void ddtLoginTest2(String execute, String userName, String password, String firstName, String lastName){
        if (execute.equals("y")){
            userNameElement.sendKeys(userName);
            passwordElement.sendKeys(password, Keys.ENTER);
        }else{
            throw new SkipException("Test was skipped!!!");
        }

        System.out.println(Driver.getDriver().getTitle());
    }

    @DataProvider
    public Object[][] userDataTest(){

        return new Object[][]{
                {"storemanager85,UserUSer123"},
                {"salesmanager110,UserUSer123"},
                {"user153,UserUSer123"}
        };
    }

    @DataProvider
    public Object[][] userDataTestFromExcel(){
        ExcelUtil excelUtil = new ExcelUtil("QA3-short");
        return excelUtil.getDataArray();
    }

    @BeforeMethod
    public void setupMethod(){
        Driver.getDriver().get("https://qa1.vytrack.com/user/login");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @AfterMethod
    public void tearDownMethod(){
        Driver.closeDriver();
    }
}
