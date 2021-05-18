package com.cybertek.tests.day_8_WebTables;

import com.cybertek.utilities.SmartBearUtilities;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P1_Locating_WebTable {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearUtilities.loginToSmartBear(driver);
    }

    @Test
    public void locatingAllTable(){
        WebElement webTable = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']"));
    }

    @Test
    public void locatingAllRows(){
        List<WebElement> listOfRows = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr"));
    }

    @Test
    public void locatingAllCells(){
        List<WebElement> listOfCells = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td"));
    }

    @Test
    public void locatingSpecificCell(){
        //It provides second row second column value!!!(Paul Brown)
        WebElement nameFromTable1 = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr[2]/td[2]"));

        //It provides cell which have Paul Brown attribute value!!!
        WebElement nameFromTable2 = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Paul Brown']"));

        WebElement cityFromTable = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr[2]/td[7]"));

        //It can be used because there is a specific text for it!!!
        WebElement nameFromTable3 = driver.findElement(By.xpath("//td[.='Steve Johns']"));
        //Or we use directly index numbers if we have just one web table!!!
        WebElement nameFromTable4 = driver.findElement(By.xpath("//tr[4]/td[2]"));
    }

    @Test
    public void locatingSpecificCellByOtherCell(){
        //It provides order date cell value by using other cell as a base in the same row!!!(Order Date)
        WebElement nameFromTable1 = driver.findElement(By.xpath("//td[.='Steve Johns']/../td[5]"));
        System.out.println(nameFromTable1.getText());
        //It is the same thing but we use sibling relationship between name and order date cells!!!
        // It does not count base sibling cell!!!
        WebElement nameFromTable2 = driver.findElement(By.xpath("//td[.='Steve Johns']/following-sibling::td[3]"));
        System.out.println(nameFromTable2.getText());
        WebElement cityFromTable = driver.findElement(By.xpath("//td[.='Clare Jefferson']/following-sibling::td[5]"));

        //preceding-sibling::td[number])It provides to go back from base sibling cell in the same row!!!
        WebElement checkBoxFromTable = driver.findElement(By.xpath("//td[.='Clare Jefferson']/preceding-sibling::td[1]"));

        //(//td[.='Value'])[indexNumber] we put "()" (parenthesis) because there are many same values
        // and they are not sibling web elements!!!
        WebElement nameFromTable3 = driver.findElement(By.xpath("(//td[.='Canada'])[2]/preceding-sibling::td[6]"));
        System.out.println(nameFromTable3.getText());

    }
}
