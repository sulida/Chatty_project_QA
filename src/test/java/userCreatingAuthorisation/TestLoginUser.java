package userCreatingAuthorisation;

import basetest.BaseTest;
import chatty.pages.AdminPage;
import chatty.pages.BlogPage;
import chatty.pages.LoginPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestLoginUser extends BaseTest {
    private String email = "abcd@gmail.com";
    private String password = "abc12345";
    private String wrongPassword = "abc123456789";
    private String unregisteredEmail = "abcd0000@gmail.com";
    private String emailAdmin = "tbceee123@gmail.com";
    private String passwordAdmin = "abc123450001";


    @Test
    public void loginUserwithValidData() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail(email)
                .inputPassword(password)
                .clickLoginButton();
        BlogPage blogPage = new BlogPage(driver);
        assertTrue(blogPage.feedHeadLineIsDisplayed());

    }

    @Test
    public void loginUserWithWrongPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail(email)
                .inputPassword(wrongPassword)
                .clickLoginButton();
        defineTestResultTrue(loginPage.getTextFromHeadLineLoginForm().contains("Login Form"));

    }

    @Test
    public void loginUnregisteredUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail(unregisteredEmail)
                .inputPassword(password)
                .clickLoginButton();
        defineTestResultTrue(loginPage.getTextFromErrorMessage().contains("User not found. Please register."));

    }

    @Test
    public void loginAdminwithValidData() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail(emailAdmin)
                .inputPassword(passwordAdmin)
                .clickLoginButton();
        defineTestResultTrue(new AdminPage(driver).getTextFromAdninPanelTitle().contains("Admin panel"));

    }

}
