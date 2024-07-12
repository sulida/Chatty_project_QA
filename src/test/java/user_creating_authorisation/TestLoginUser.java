package user_creating_authorisation;

import basetests.BaseTest;
import chatty.pages.BlogPage;
import chatty.pages.LoginPage;
import chromeRegistry.ChromeRegistry;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestLoginUser extends BaseTest{

    @Test
    public void loginUserwithValidData(){
        LoginPage loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        loginPage.open()
                .inputEmail("abcd@gmail.com")
                .inputPassword("abc12345")
                .clickLoginButton();
        BlogPage blogPage =new BlogPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertTrue(blogPage.feedheadLineIsDisplayed());

    }

    @Test
    public void loginUserwithInvalidData() {
        ChromeDriver driver = new ChromeRegistry().registerDriver();
        LoginPage loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        loginPage.open()
                .inputEmail("123abcd@gmail.com")
                .inputPassword("abc1234")
                .clickLoginButton();

    }





//    @AfterEach
//    public void tearDown() {
//        driver.quit();
//    }



}
