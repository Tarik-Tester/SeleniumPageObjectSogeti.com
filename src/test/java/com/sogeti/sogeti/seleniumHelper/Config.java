package com.sogeti.sogeti.seleniumHelper;

import com.relevantcodes.extentreports.ExtentReports;
import com.sogeti.sogeti.base.Base;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class Config extends Base {
    public Config() throws IOException {
    }

    @BeforeSuite
    public void start(){
        extentReporter = new ExtentReports("src/TestReport/index.html", true);
        extentReporter.addSystemInfo("Owner","Tarik Dkhireche");
        extentReporter.addSystemInfo("Test Name","Sogeti.com Req");
        extentReporter.addSystemInfo("Language","Java");
        extentReporter.addSystemInfo("Framework","Page object module & Maven & TestNG");

    }

    @AfterSuite
    public void end(){
        extentReporter.flush();

    }
}
