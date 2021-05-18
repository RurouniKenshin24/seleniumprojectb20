package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loading7Page {

    public Loading7Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "alert")
    public WebElement doneMessage;

    @FindBy(xpath = "//img[@src='/img/a-few-moments.jpg']")
    public WebElement image;
}
