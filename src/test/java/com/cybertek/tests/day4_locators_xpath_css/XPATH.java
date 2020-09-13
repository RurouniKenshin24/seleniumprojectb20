package com.cybertek.tests.day4_locators_xpath_css;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XPATH {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //There are 2 types of XPATH;
        //1-) Absolute XPATH: Starts with forward slash --> "/"
        // It starts looking from the root element in HTML page. This is not reliable locator!!!
        // Syntax --> /html/body/div/h1

        /*
        <html>
            <head>
            </head>
            <body>
                <div>
                    <h1> "item" </h1>
                </div>
            </body>
        </html>

         */

        //2-) Relative XPATH: It starts with double slash "//"
        //This is a lot more specific absolute xpath!!!
        //Syntax -->
        //  1) "//tagName[@attribute='value']"
        //  2) "//tagName[contains(@attribute, 'value')]"
        //  3) "//tagName[.='text']"

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //Button 2
        driver.findElement(By.xpath("//button[@name='button2']")).click();

    }
}
