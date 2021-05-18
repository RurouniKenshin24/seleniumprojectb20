package com.cybertek.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtilities {

    public static List<String> getElementText(List<WebElement> list){
        List<String> webElementsAsString = new ArrayList<>();

        for (WebElement each : list) {
            webElementsAsString.add(each.getText());
        }

        return webElementsAsString;
    }

    public static void wait(int sec){
        try{
            Thread.sleep(1000*sec);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
