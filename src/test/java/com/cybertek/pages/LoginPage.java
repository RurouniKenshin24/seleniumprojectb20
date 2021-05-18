package com.cybertek.pages;

import com.cybertek.utilities.BrowserUtilities;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "ctl00_MainContent_username")
    public WebElement userNameInput;

    @FindBy(id = "ctl00_MainContent_password")
    public WebElement userPassword;

    @FindBy(id = "ctl00_MainContent_login_button")
    public WebElement loginButton;

    @FindBy(id = "ctl00_MainContent_status")
    public WebElement loginErrorMessage;

    public void login(String userName, String password){
        userNameInput.sendKeys(userName);
        BrowserUtilities.wait(1);
        userPassword.sendKeys(password);
        BrowserUtilities.wait(1);
        loginButton.click();
    }
}
