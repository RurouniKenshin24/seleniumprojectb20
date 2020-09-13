package com.cybertek.tests.day_5_locators.practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Apple_Task {
    public static void main(String[] args) {
        System.setProperty("web.driver.chrome", System.getProperty("user.dir") + "/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.apple.com");

        WebElement iphoneLink = driver.findElement(By.cssSelector("a[href='/iphone/']"));
        iphoneLink.click();

        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));

        for (WebElement eachLink: listOfLinks){
            System.out.println(eachLink.getText());
        }

        System.out.println(listOfLinks.size());

        int linkWithText = 0;
        int linkWithoutText = 0;

        for (WebElement eachLink: listOfLinks){
            if (eachLink.getText().isEmpty()){
                linkWithoutText++;
            }else{
                linkWithText++;
            }
        }

        System.out.println("Number of Links With Text= " + linkWithText);
        System.out.println("Number of Links Without Text= " + linkWithoutText);

        driver.navigate().back();
    }
}
