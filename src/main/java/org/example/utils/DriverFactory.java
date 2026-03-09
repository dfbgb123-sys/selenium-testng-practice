package org.example.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    public static WebDriver createDriver(){
        //브라우저 생성 담당
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}