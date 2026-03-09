package base;

import org.example.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    //테스트 시작 → driver 생성
    //테스트 종료 → driver 종료
    protected WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver();
    }
    @AfterMethod
    public void teardown(){
        if(driver != null){
            driver.quit();
        }
    }
}