package org.example.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {

//    public static WebDriver createDriver(){
//        //브라우저 생성 담당
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        return driver;
//    }
    private static WebDriver driver;

    public static WebDriver createDriver(String browser){

        if(browser.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");

            driver = new ChromeDriver(options);
            return driver;
        }
        else if(browser.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            return driver;
        }
        return null;
    }
    public static WebDriver getDriver(){
        return driver;
    }
    public static void quitDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}