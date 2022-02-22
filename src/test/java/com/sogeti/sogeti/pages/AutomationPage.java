package com.sogeti.sogeti.pages;

import com.sogeti.sogeti.base.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.io.IOException;

public class AutomationPage extends Base {

    @FindBy(className = "page-heading")
    public WebElement AutomationWording;


    @FindBy(xpath = "//*[@class= 'selected has-children  expanded level2 hover']")
    public WebElement AutomationIsAktiv;

    @FindBy(xpath = "//*[@class= 'selected has-children  expanded level2 hover']")
    public WebElement test;

    @FindBy(xpath = "//*[@class= 'selected  current expanded']")
    public WebElement ServicesIsAktiv;


    public AutomationPage() throws IOException {
        PageFactory.initElements(driver, this);
    }
}
