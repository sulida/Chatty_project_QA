package userCreatingAuthorisation;

import basetest.BaseTest;
import chatty.pages.Header;
import chatty.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestLogOut extends BaseTest {
    private String email = "abcd@gmail.com";
    private String password = "abc12345";

    @BeforeEach
    public void loginUserwithValidData() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail(email)
                .inputPassword(password)
                .clickLoginButton();
    }

    @Test
    public  void logOutUserTest(){
        new Header(driver).hoverDropDownMenuHello()
                .clickLogoutLink();
        defineTestResultTrue(new LoginPage(driver).getTextFromHeadLineLoginForm().contains("Login Form"));

    }
}
