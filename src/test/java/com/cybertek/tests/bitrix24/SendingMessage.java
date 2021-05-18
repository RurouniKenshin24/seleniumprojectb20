package com.cybertek.tests.bitrix24;

import com.cybertek.utilities.Bitrix24Utilities;
import com.cybertek.utilities.BrowserUtilities;
import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SendingMessage {

    WebDriver driver;
    Faker faker;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://login2.nextbasecrm.com/stream/");

        Bitrix24Utilities.loginToBitrix24(driver);

        Bitrix24Utilities.clickOnMessageTab(driver);
        BrowserUtilities.wait(1);

    }

    @AfterMethod
    public void tearDownMethod(){
        BrowserUtilities.wait(1);
        driver.close();
    }

    @Test
    public void t1_verify_Upload_Icon(){
        WebElement uploadFilesIcon = driver.findElement(By.xpath("//span[@id='bx-b-uploadfile-blogPostForm']"));
        uploadFilesIcon.click();

        BrowserUtilities.wait(1);

        WebElement upload_Box = driver.findElement(By.xpath("//span[@class='wd-fa-add-file-light-title-text']"));
        String actualText1 = upload_Box.getText();
        String expectedText1 = "Upload files and images";

        Assert.assertEquals(actualText1,expectedText1);

/*        List<WebElement> documentList = driver.findElements(By.xpath("//span[@class='wd-fa-add-file-light-title" +
                "-text diskuf-selector-link']"));
        String actualText2 = documentList.get(1).getText();
        String expectedText2 = "Select document from Bitrix24";

        Assert.assertEquals(actualText2,expectedText2);*/

    }

    @Test
    public void t2_verify_AddingMore_Icon(){
        WebElement addMoreIcon = driver.findElement(By.id("bx-destination-tag"));
        addMoreIcon.click();

        BrowserUtilities.wait(1);

        WebElement recent = driver.findElement(By.xpath("//a[contains(@id,'destLastTab_destination')]"));
        String actualRecentText = recent.getText();
        String expectedRecentText = "Recent";

        Assert.assertEquals(actualRecentText,expectedRecentText);

        BrowserUtilities.wait(1);

        WebElement recentContact = driver.findElement(By.xpath("//div[.='hr1@cybertekschool.com']/div"));
        recentContact.click();

        BrowserUtilities.wait(1);

        String selectedContact1 = driver.findElement(By.xpath("//span[@data-id='U693']/span")).getText();
        String expectedContact1 = "hr1@cybertekschool.com";

        BrowserUtilities.wait(1);

        Assert.assertEquals(selectedContact1,expectedContact1);

        WebElement departmentAndEmployees = driver.findElement(By.xpath("//a[contains(@id,'destDepartmentTab_destination')]"));
        String actualDepartmentText = departmentAndEmployees.getText();
        String expectedDepartmentText = "Employees and departments";

        Assert.assertEquals(actualDepartmentText,expectedDepartmentText);

        departmentAndEmployees.click();

        WebElement cristinaEmail = driver.findElement(By.xpath("//a[@href='#U519']"));
        cristinaEmail.click();

        BrowserUtilities.wait(1);

        String selectedContact2 = driver.findElement(By.xpath("//span[@data-id='U519']/span")).getText();
        String expectedContact2 = "Cristina";

        Assert.assertEquals(selectedContact2,expectedContact2);

        WebElement emailTab = driver.findElement(By.xpath("//a[contains(@id,'destEmailTab_destination')]"));
        String actualEmailTab = emailTab.getText();
        String expectedEmailTab = "E-mail users";

        Assert.assertEquals(actualEmailTab,expectedEmailTab);

        emailTab.click();

        List<WebElement> listOfEmail = driver.findElements(By.xpath("//a[@rel='U817']"));
        listOfEmail.get(1).click();

        BrowserUtilities.wait(1);

        String selectedContact3 = driver.findElement(By.xpath("//span[@data-id='U817']/span")).getText();
        String expectedContact3 = "ogzhn_9225@hotmail.com";

        Assert.assertEquals(selectedContact3,expectedContact3);
    }

    @Test
    public void t3_verify_LinkIcon(){
        WebElement linkIcon = driver.findElement(By.xpath("//span[@class='bxhtmled-top-bar-btn bxhtmled-button-link']"));
        linkIcon.click();

        BrowserUtilities.wait(1);

        WebElement linkText = driver.findElement(By.id("linkidPostFormLHE_blogPostForm-text"));
        linkText.sendKeys("Test Link");

        BrowserUtilities.wait(1);

        WebElement linkURL = driver.findElement(By.id("linkidPostFormLHE_blogPostForm-href"));
        linkURL.sendKeys("https://www.google.com/");

        BrowserUtilities.wait(1);

        WebElement saveButton = driver.findElement(By.xpath("//input[@value='Save']"));
        saveButton.click();

        //WebElement iFrame = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(0);

        WebElement iFrameLinkText = driver.findElement(By.partialLinkText("Test Link"));
        String actualLinkText = iFrameLinkText.getText();
        String expectedLinkText = "Test Link";

        Assert.assertEquals(actualLinkText,expectedLinkText);

        String actualLink = iFrameLinkText.getAttribute("href");
        String expectedLink = "https://www.google.com/";

        Assert.assertEquals(actualLink,expectedLink);

        driver.switchTo().defaultContent();
    }

    @Test
    public void t4_verify_VideoIcon(){
        WebElement videoIcon = driver.findElement(By.xpath("//span[@title='Insert video']"));
        videoIcon.click();

        WebElement videoURL = driver.findElement(By.xpath("//input[@id='video_idPostFormLHE_blogPostForm-source']"));
        videoURL.sendKeys("https://vimeo.com/124318224");

        BrowserUtilities.wait(2);

        WebElement saveButton = driver.findElement(By.xpath("//input[@value='Save']"));
        saveButton.click();

        Assert.fail("Due to adding video link!!!");
    }

    @Test
    public void t5_verify_QuoteIcon(){
        WebElement quoteIcon = driver.findElement(By.xpath("//span[@title='Quote text']"));
        quoteIcon.click();
    }
}
