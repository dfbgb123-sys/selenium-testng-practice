import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://example.com/login"); // 테스트용 로그인 페이지
    }

    @Test
    public void loginSuccessTest() {
        driver.findElement(By.id("username"))
                .sendKeys("testuser");

        driver.findElement(By.id("password"))
                .sendKeys("password123");

        driver.findElement(By.id("loginButton"))
                .click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
