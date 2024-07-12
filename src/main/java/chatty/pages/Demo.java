package chatty.pages;

import chromeRegistry.ChromeRegistry;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Demo {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeRegistry().registerDriver();
        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .clickSignInLink().selectAdmin().selectUser();
//                .inputEmail("123abc@gmail.com")
//                .inputPassword("d12345678")
//                .inputConfirmPassword("d12345678")
//                .clickRegistrationButton();
//        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
//        createAccountPage.selectDropDownMenu();
//                createAccountPage.selectUser();



//                .inputEmail("enk@gmail.com")
//                .inputPassword("a12345678")
//                .clickLoginButton();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        BlogPage blogPage = new BlogPage(driver);
//        blogPage.clickMyDrafts();
//        blogPage.clickNewsFeed();
//        blogPage.clickPost();
//
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        Header header = new Header(driver);
////        header.clickHomeLink();
////        driver.switchTo().alert().dismiss();
//
//        header.hoverDropDownMenuHello();
////        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
////
//////        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@href=\"/userprofile\"]")));
////
//        header.clickYourProfileLink();
    }
}
