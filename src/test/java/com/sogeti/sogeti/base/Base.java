package com.sogeti.sogeti.base;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.sogeti.sogeti.tools.WebListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public static WebDriver driver;
    public static Properties prop;
    public static EventFiringWebDriver e_driver;
    public static WebListener webList;
    public static ExtentReports extentReporter;
    public static ExtentTest log;

    public Base() throws IOException {
        prop = new Properties();
        FileInputStream fil = new FileInputStream("src/test/java/com/sogeti/sogeti/config/properties");
        prop.load(fil);
    }


    public void SetUp(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("ff")) {
            System.setProperty("webdriver.gecko.driver", "src/test/java/com/sogeti/sogeti/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }

        e_driver = new EventFiringWebDriver(driver);
        webList = new WebListener();
        e_driver.register(webList);
        driver = e_driver;

        driver.get(prop.getProperty("URL"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
    public void cleanUp(){
        if(null!=driver){
            //driver.close();
            driver.quit();
        }

    }
}
