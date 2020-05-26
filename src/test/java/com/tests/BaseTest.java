package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void setupDriver(ITestContext context) throws MalformedURLException {
        String host = "localhost";
        String name = context.getName();
        System.out.println("name" + name);
        DesiredCapabilities dc;

        if(System.getProperty("BROWSER") !=null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            dc = DesiredCapabilities.firefox();
        }else{
            dc = DesiredCapabilities.chrome();
        }
        if(System.getProperty("HUB_HOST") !=null){
            host = System.getProperty("HUB_HOST");
        }
        String URI = "http://" + host + ":4444/wd/hub";
        this.driver = new RemoteWebDriver(new URL(URI), dc);

        // when file to be uploaded below code need to added
        //assuming driver is the name of the variable for WebDriver instance.
//        if(driver instanceof RemoteWebDriver){
//            ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
//        }
    }

    @AfterTest
    public void tearDown(){
        this.driver.quit();
    }
}
