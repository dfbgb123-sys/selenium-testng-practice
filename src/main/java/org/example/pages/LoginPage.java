package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver; //클래스 변수

    //UI 요소
    private By username = By.id("username");
    private By password = By.id("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By flashMessage = By.id("flash");
    //생성자
    public LoginPage(WebDriver driver){ //파라미터 변수
        this.driver = driver;
        //생성자로 전달된 driver를 클래스 변수(this로 객체 자신 지정)에 저장
    }
    //동작메서드 (1)
//    public void login(String user, String pass){
//        driver.findElement(username).sendKeys(user);
//        driver.findElement(password).sendKeys(pass);
//        driver.findElement(loginButton).click();
//    }
    //동작메서드 (2)
    public void enterUsername(String username) {
        driver.findElement(this.username).sendKeys(username);
    }
    public void enterPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
    }

    //기능
    public void loginAs(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
    public void clickLogin() {
        driver.findElement(loginButton).click();
        //System.out.println("로그인 클릭 완료"); 디버깅용
    }
    public String getFlashMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        WebElement flash = wait.until(
                ExpectedConditions.visibilityOfElementLocated(flashMessage)
        );
        return flash.getText();
    }
}
