package chatty.pages;

import chromeRegistry.ChromeRegistry;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeRegistry().registerDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail("enk@gmail.com")
                .inputPassword("a12345678")
                .clickLoginButton();
        Header header = new Header(driver);
        header.clickYourProfileLink();
    }
}
