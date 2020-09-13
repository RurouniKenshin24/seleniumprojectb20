package com.cybertek.tests.day_5_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class MerriamWebsterPractise {
    public static void main(String[] args) {
        System.setProperty("web.driver.chrome", System.getProperty("user.dir") + "/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.merriam-webster.com/");

        //It will provides all links(list of links) in the page above!!!
        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));

        System.out.println("Number of Links: " + listOfLinks.size());

        int linksWithText = 0;
        int linksWithoutText = 0;

        for (WebElement each: listOfLinks){
            String textOfLink = each.getText();
            if(textOfLink.isEmpty()){
                linksWithoutText++;
            }else{
                linksWithText++;
            }
        }

        System.out.println("Number of Links Without Text: " + linksWithoutText);
        System.out.println("Number of Links With Text: " + linksWithText);


    }
}
