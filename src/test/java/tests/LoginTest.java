package tests;

import base.BaseTest;
import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginSuccessTest() {
        driver.get("https://the-internet.herokuapp.com/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("tomsmith", "SuperSecretPassword!");

        String successMessage = loginPage.getFlashMessage();
        Assert.assertTrue(successMessage.contains("You logged into a secure area!"),
                "로그인 성공 메시지가 나타나지 않았습니다.");
    }
}