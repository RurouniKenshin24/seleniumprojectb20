package com.cybertek.tests.day_7_testNG;

import com.cybertek.utilities.SmartBearUtilities;
import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearTest {

    WebDriver driver;
    Faker faker = new Faker();

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        SmartBearUtilities.loginToSmartBear(driver);
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
//        driver.close();
    }

    @Test
    public void landing_page_test(){
        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));

        System.out.println("Number of Links: " + listOfLinks.size());

        for (WebElement eachLink: listOfLinks){
            System.out.println(eachLink.getText());
        }
    }

    @Test
    public void order_page_test(){
        driver.findElement(By.xpath("//a[@href='Process.aspx']")).click();

        WebElement dropdownMenu = driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));
        Select productSelection = new Select(dropdownMenu);

        productSelection.selectByVisibleText("FamilyAlbum");

        WebElement quantityInputBox = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        quantityInputBox.sendKeys(Keys.BACK_SPACE + "2");

        WebElement calculateButton = driver.findElement(By.xpath("//input[@value='Calculate']"));
        calculateButton.click();

        WebElement nameInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        WebElement streetInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        WebElement cityInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        WebElement stateInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
        WebElement zipCodeInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));

        nameInput.sendKeys(faker.name().fullName());
        streetInput.sendKeys(faker.address().streetAddress());
        cityInput.sendKeys(faker.address().cityName());
        stateInput.sendKeys(faker.address().stateAbbr());
        zipCodeInput.sendKeys(faker.address().zipCode().replaceAll("-",""));

        WebElement cardRadioButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
        cardRadioButton.click();

        WebElement cardNumber = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
        cardNumber.sendKeys(faker.finance().creditCard().replaceAll("-",""));

        WebElement expireDateInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));
        expireDateInput.sendKeys("12/25");

        WebElement processButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton"));
        processButton.click();

        WebElement successMessage = driver.findElement(By.xpath("//strong"));
        String actualMessage = successMessage.getText();
        String expectedMessage = "New order has been successfully added.";

        Assert.assertEquals(actualMessage,expectedMessage,"Messages are not matching!!!");
    }
}
