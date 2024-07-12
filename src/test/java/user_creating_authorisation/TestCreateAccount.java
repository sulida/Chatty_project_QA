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
public class TestCreateAccount extends BaseTest{
    @Test
    public void successCreateUserWithValidData(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .clickSignInLink()
                .selectUser()
                .inputEmail("tbce123@gmail.com")
                .inputPassword("abc12345000")
                .inputConfirmPassword("abc12345000")
                .clickRegistrationButton();
        Header header = new Header(driver);
        assertTrue(header.helloUserIsDisplayed());

    }
   @Test
    public void successCreateAdminWithValidData(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .clickSignInLink()
                .selectAdmin()
                .inputEmail("tbceee123@gmail.com")
                .inputPassword("abc12345000")
                .inputConfirmPassword("abc12345000")
                .clickRegistrationButton();
       Header header = new Header(driver);
       header.hoverDropDownMenuHello();
       assertTrue(header.getTextDropDownMenuAdminPanel().contains("Admin Panel"));


    }

    @Test
    public void unsuccessCreateUserAlreadyExists() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .clickSignInLink()
                .selectUser()
                .inputEmail("abcd123@gmail.com")
                .inputPassword("abc12345")
                .inputConfirmPassword("abc12345")
                .clickRegistrationButton();
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        assertTrue(createAccountPage.getTextFromErrorMessage().contains("Email already exists!"));

    }

    @Test
    public void unsuccessCraeteUserWithShortThen8SYmbolsPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .clickSignInLink()
                .selectUser()
                .inputEmail("123000aaa@gmail.com")
                .inputPassword("abc1234")
                .inputConfirmPassword("abc1234")
                .clickRegistrationButton();
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        assertTrue(createAccountPage.getTextFromHeadline().contains("Create Account"));


    }

}
