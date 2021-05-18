package com.cybertek.tests.day_8_WebTables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Guru99_WebTable {

    @Test
    public  void test1() throws ParseException {
        WebDriver wd;
        wd = WebDriverFactory.getDriver("chrome");
        wd.get("http://demo.guru99.com/test/web-table-element.php");
        //No.of Columns
        List col = wd.findElements(By.xpath(".//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
        System.out.println("No of cols are : " +col.size());
        //No.of rows
        List  rows = wd.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr"));
        System.out.println("No of rows are : " + rows.size());
        wd.close();
    }

    @Test
    public void test2(){
        WebDriver wd;
        wd = WebDriverFactory.getDriver("chrome");
        wd.get("http://demo.guru99.com/test/web-table-element.php");

        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement baseTable = wd.findElement(By.tagName("table"));

        //To find third row of table
        WebElement tableRow = baseTable.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[3]"));
        String rowtext = tableRow.getText();
        System.out.println("Third row of table : "+rowtext);

        //to get 3rd row's 2nd column data
        WebElement cellIneed = tableRow.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[3]/td[2]"));
        String valueIneed = cellIneed.getText();
        System.out.println("Cell value is : " + valueIneed);
        wd.close();
    }

    @Test
    public void test3(){
        WebDriver wd;
        wd = WebDriverFactory.getDriver("chrome");
        wd.get("http://demo.guru99.com/test/web-table-element.php");

        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String max;
        double r=0;

        //No. of Columns
        List  col = wd.findElements(By.xpath(".//*[@id='leftcontainer']/table/thead/tr/th"));
        System.out.println("Total No of columns are : " +col.size());
        //No.of rows
        List  rows = wd.findElements(By.xpath (".//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
        System.out.println("Total No of rows are : " + rows.size());
        for (int i =1;i<rows.size();i++)
        {
            max= wd.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[" + i + "]/td[4]")).getText();
            double num = Double.parseDouble(max);
            if(num>r)
            {
                r=num;
            }
        }
        System.out.println("Maximum current price is : "+ r);
    }
}
