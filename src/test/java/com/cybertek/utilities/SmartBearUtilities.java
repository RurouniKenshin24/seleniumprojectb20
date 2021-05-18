package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SmartBearUtilities {

    public static void loginToSmartBear(WebDriver driver){

        WebElement userNameInputBox = driver.findElement(By.id("ctl00_MainContent_username"));
        WebElement passwordInputBox = driver.findElement(By.id("ctl00_MainContent_password"));

        userNameInputBox.sendKeys("Tester");
        passwordInputBox.sendKeys("test" + Keys.ENTER);

    }

    public static void verifyOrder(WebDriver driver, String customerName){
        List<WebElement> listOfName = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr//td[2]"));

        for (WebElement name: listOfName){
            if (name.getText().equals(customerName)){
                Assert.assertTrue(true);
                return;
            }
        }

        Assert.fail("Name is not in the order table!!!");
    }

    public static void printNamesAndCities(WebDriver driver){
        List<WebElement> listOfName = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr//td[2]"));
        List<WebElement> listOfCity = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr//td[7]"));

        for (int i = 0;i < listOfName.size();i++) {
            System.out.print("Name " + (i+1) + ": " + listOfName.get(i).getText() + ", ");
            System.out.println("City " + (i+1) + ": " + listOfCity.get(i).getText());
        }
    }

    public static void removeName(WebDriver driver, String customerName){
        List<WebElement> listOfName = driver.findElements(By.xpath("//table//tr//td[2]"));

        for (WebElement each : listOfName) {
            if (each.getText().equalsIgnoreCase(customerName)){
                WebElement checkBox = driver.findElement(By.xpath("//td[.='" + customerName + "']/../td[1]"));
                checkBox.click();

                WebElement deleteButton = driver.findElement(By.id("ctl00_MainContent_btnDelete"));
                deleteButton.click();
            }
        }
    }

}
