package contactForm;

import basetest.BaseTest;
import chatty.pages.ContactUsPage;
import chatty.pages.Header;
import chatty.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestContactForm extends BaseTest {
    private String email = "abcd@gmail.com";
    private String password = "abc12345";
    private  String name = "John";
    private String message = "Please contact me";

    @BeforeEach
    public void loginUserwithValidData() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail(email)
                .inputPassword(password)
                .clickLoginButton();
    }

    @Test
    public void contactFormFillTest(){
        Header header = new Header(driver);
        header.clickContactLink()
                .inputName(name)
                .inputEmail(email)
                .inputMessage(message)
                .clickSendMessageButton();
        defineTestResultTrue(new ContactUsPage(driver).getTextFromSuccessfulMessage().contains("Feedback submitted successfully!"));

    }
}
