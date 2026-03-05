package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        // ⭐ 드라이버 자동 관리, 다만 반복 시, PC 느려지고 문제 생김 > driver.quit()추가 필요
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void loginSuccessTest() {
        System.out.println("Selenium test started"); //나중에 지우기
        driver.findElement(By.id("username"))
                .sendKeys("tomsmith");

        driver.findElement(By.id("password"))
                .sendKeys("SuperSecretPassword!");

        driver.findElement(By.cssSelector("button[type='submit']"))
                .click();

        String successMessage =
                driver.findElement(By.id("flash")).getText();

        Assert.assertTrue(
                successMessage.contains("You logged into a secure area!"),
                "로그인 성공 메시지가 나타나지 않았습니다."
        );
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}