package com.sogeti.sogeti.TestCases;

import com.relevantcodes.extentreports.LogStatus;
import com.sogeti.sogeti.base.Base;
import com.sogeti.sogeti.pages.AutomationPage;
import com.sogeti.sogeti.pages.HomePage;
import com.sogeti.sogeti.seleniumHelper.Helper;
import com.sogeti.sogeti.tools.ScreenshotUtil;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class AutomationSeiteTest extends Base {

    Helper helper = new Helper();
    HomePage home;
    AutomationPage automationPage;
    Method method;

    public AutomationSeiteTest() throws IOException {
        // super();
    }

    @Parameters({"browser"})
    @BeforeMethod
    public void StartBrowser(String browser, Method method) throws IOException {
        log = extentReporter.startTest(method.getName());

        SetUp(browser);
        home = new HomePage();
        automationPage = new AutomationPage();
        helper.click(home.acceptCookie);
    }

    @AfterMethod
    public void close(Method method, ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS){
            log.log(LogStatus.PASS, "Test pass");
        } else if (result.getStatus() == ITestResult.FAILURE){
            log.log(LogStatus.FAIL, "Test fehlgeschlagen");
        } else { log.log(LogStatus.SKIP, "Test Skip");
        }

        cleanUp();
    }


    @Test
    public void automationTest(Method method) throws IOException {
        //log = extentReporter.startTest("automationTest");
        home.automationOnKlick();
        System.out.println("Automation Wording ist displeyd: " + helper.isDisplayed(automationPage.AutomationWording));
        Assert.assertEquals(helper.getText(automationPage.AutomationWording), "Automation");
        String expectedResultUrl = "https://www.sogeti.com/services/automation/";
        String actualResultUrl = helper.getURL();
        System.out.println("ActuelURL:*********** " + actualResultUrl + "*********");
        Assert.assertEquals(actualResultUrl, expectedResultUrl);
        helper.mouseOver(home.Services);
        Assert.assertTrue(driver.findElements(By.xpath("//*[@class= 'selected has-children  expanded level2 hover']")).size() > 0, "is selected");
        Assert.assertTrue(helper.isDisplayed(automationPage.AutomationIsAktiv), "Services is selected");
        Assert.assertTrue(helper.isDisplayed(automationPage.ServicesIsAktiv), "Automation is selected");
        String expectedResultTitle = "Automation";
        String actualResultTitle = helper.getTitle();
        System.out.println("**************" +actualResultTitle+ "*************");
        Assert.assertEquals(actualResultTitle, expectedResultTitle);
        ScreenshotUtil.takePicture(method.getName());
    }


}
