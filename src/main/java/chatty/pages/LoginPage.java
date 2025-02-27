package chatty.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//*[@data-test= \"email\"]")
    private WebElement emailEditBox;

    @FindBy(xpath = "//*[@data-test=\"password\"]")
    private WebElement passwordEditBox;

    @FindBy(xpath = "//*[@data-test=\"submit\"]")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@href=\"/registration\" and contains(text(), 'Sign in')]")
    private WebElement signInLink;

    @FindBy(xpath = "//h1[text()=\"Login Form\"]")
    private WebElement headLineLoginForm;

    @FindBy(xpath = "//div[@class=\"text-error\"]")
    private WebElement errorMessageUserNotFound;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        driver.get("http://chatty.telran-edu.de:8089/login");
        return this;
    }

    public LoginPage inputEmail(String email) {
        emailEditBox.sendKeys(email);
        return this;
    }

    public LoginPage inputPassword(String password) {
        passwordEditBox.sendKeys(password);
        return this;
    }

    public BlogPage clickLoginButton() {
        loginButton.click();
        return new BlogPage(driver);
    }

    public AdminPage clickLoginButtonForAdmin() {
        loginButton.click();
        return new AdminPage(driver);
    }

    public CreateAccountPage clickSignInLink() {
        signInLink.click();
        return new CreateAccountPage(driver);
    }

    public boolean loginButtonIsDisplayed() {
        return loginButton.isDisplayed();
    }

    public String getTextFromHeadLineLoginForm() {
        return headLineLoginForm.getText();
    }

    public String getTextFromErrorMessage() {
        return errorMessageUserNotFound.getText();
    }
}

