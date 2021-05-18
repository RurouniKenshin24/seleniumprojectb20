package com.cybertek.tests.day_5_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_CheckBox_Practice {
    public static void main(String[] args) {
        System.setProperty("web.driver.chrome", System.getProperty("user.dir") + "/chromedriver.exe");

        //Practice: Cybertek Checkboxes
        //1. Go to http://practice.cybertekschool.com/checkboxes
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");

        //2. Confirm checkbox #1 is NOT selected by default
        boolean checkedBox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]")).isSelected();
        String result = !checkedBox1 ? "Checkbox 1 is not selected.Verification passed!"
                : "Checkbox 1 is selected.Verification failed!";
        System.out.println(result);

        sleep(2);

        //3. Confirm checkbox #2 is SELECTED by default.
        boolean checkedBox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]")).isSelected();
        result = checkedBox2 ? "Checkbox 2 is selected.Verification passed!"
                : "Checkbox 2 is not selected.Verification failed!";
        System.out.println(result);

        sleep(2);

        //4. Click checkbox #1 to select it.
        driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]")).click();

        sleep(2);

        //5. Click checkbox #2 to deselect it.
        driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]")).click();

        sleep(1);

        checkedBox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]")).isSelected();
        checkedBox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]")).isSelected();

        //6. Confirm checkbox #1 is SELECTED.
        result = checkedBox1 ? "Checkbox 1 is selected.Verification passed!"
                : "Checkbox 1 is not selected.Verification failed!";
        System.out.println(result);

        //7. Confirm checkbox #2 is NOT selected.
        result = !checkedBox2 ? "Checkbox 2 is not selected.Verification passed!"
                : "Checkbox 2 is selected.Verification failed!";
        System.out.println(result);
    }
    public static void sleep(int seconds){
        try{
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}
