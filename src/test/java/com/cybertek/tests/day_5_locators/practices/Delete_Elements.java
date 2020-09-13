package com.cybertek.tests.day_5_locators.practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Delete_Elements {
    public static void main(String[] args) {

        System.setProperty("web.driver.chrome", System.getProperty("user.dir") + "/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/add_remove_elements/");

        WebElement addElementButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));

        for (int i = 0;i < 50;i++){
            addElementButton.click();
        }

        sleep(1);

        List<WebElement> listOfDeleteButtons = driver.findElements(By.xpath("//div[@id='elements']//button"));
        WebElement deleteButton = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));

        if(listOfDeleteButtons.contains(deleteButton)){
            System.out.println(deleteButton.getText());
            System.out.println("Number of Delete Buttons: " + listOfDeleteButtons.size());
        }else{
            System.out.println("Failed!!!");
        }

        sleep(1);

        for (WebElement each: listOfDeleteButtons){
            each.click();
        }

        sleep(1);

    }

    public static void sleep(int seconds){
        try{
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){

        }
    }
}
