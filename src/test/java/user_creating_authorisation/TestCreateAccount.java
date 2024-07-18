package user_creating_authorisation;

import basetests.BaseTest;
import chatty.pages.CreateAccountPage;
import chatty.pages.Header;
import chatty.pages.LoginPage;
import chromeRegistry.ChromeRegistry;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.support.ui.Select;

public class TestCreateAccount extends BaseTest {
    private String email = "tbce123@gmail.com";
    private String password = "abc12345000";
    private String emailAdmin = "tbceee123@gmail.com";
    private String passwordAdmin = "abc123450001";
    private String emailForShortPassword ="123000aaa@gmail.com";
    private String shortPassword = "abc1234";


    @Test
    public void successCreateUserWithValidData() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .clickSignInLink()
                .selectUser()
                .inputEmail(email)
                .inputPassword(password)
                .inputConfirmPassword(password)
                .clickRegistrationButton();
        defineTestResultTrue(new Header(driver).helloUserIsDisplayed());

    }

    @Test
    public void successCreateAdminWithValidData() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .clickSignInLink()
                .selectAdmin()
                .inputEmail(emailAdmin)
                .inputPassword(passwordAdmin)
                .inputConfirmPassword(passwordAdmin)
                .clickRegistrationButton();
        Header header = new Header(driver);
        header.hoverDropDownMenuHello();
        defineTestResultTrue(header.getTextDropDownMenuAdminPanel().contains("Admin Panel"));

    }

    @Test
    public void unsuccessCreateUserAlreadyExists() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .clickSignInLink()
                .selectUser()
                .inputEmail(email)
                .inputPassword(password)
                .inputConfirmPassword(password)
                .clickRegistrationButton();
        defineTestResultTrue(new CreateAccountPage(driver).getTextFromErrorMessage().contains("Email already exists!"));

    }

    @Test
    public void unsuccessCreateUserWithShortThen8SymbolsPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .clickSignInLink()
                .selectUser()
                .inputEmail(emailForShortPassword)
                .inputPassword(shortPassword)
                .inputConfirmPassword(shortPassword);
        defineTestResultTrue(new CreateAccountPage(driver).registrationButtonIsNotClickable());


    }

}
