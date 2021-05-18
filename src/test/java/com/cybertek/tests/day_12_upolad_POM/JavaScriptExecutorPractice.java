package com.cybertek.tests.day_12_upolad_POM;

import com.cybertek.utilities.BrowserUtilities;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class JavaScriptExecutorPractice {

    @Test
    public void p1_scroll_using_actions_test(){
        Driver.getDriver().get("http://practice.cybertekschool.com/large");

        //First way of scroll down/up is using actions.moveToElement method!!!
        Actions actions = new Actions(Driver.getDriver());

        WebElement target = Driver.getDriver().findElement(By.linkText("Cybertek School"));

        BrowserUtilities.wait(2);
        actions.moveToElement(target).perform();
    }

    @Test
    public void p2_scroll_using_jsexecutor_test1(){
        //Second way of scroll down/up is using java script executor!!!
        Driver.getDriver().get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        for (int i = 0;i < 5;i++){
            BrowserUtilities.wait(1);
            js.executeScript("window.scrollBy(0,500)");
        }

        js.executeScript("window.scrollBy(0,-2000)");
    }

    @Test
    public void p2_scroll_using_jsexecutor_test2(){
        Driver.getDriver().get("http://practice.cybertekschool.com/large");

        WebElement link = Driver.getDriver().findElement(By.linkText("Cybertek School"));

        BrowserUtilities.wait(1);
        //Third way of scroll down/up is using java script executor with "arguments[0].scrollIntoView" method!!!
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true)", link);

        WebElement homePageLink = Driver.getDriver().findElement(By.linkText("Home"));

        BrowserUtilities.wait(1);
        js.executeScript("arguments[0].scrollIntoView(true)", homePageLink);


    }
}
