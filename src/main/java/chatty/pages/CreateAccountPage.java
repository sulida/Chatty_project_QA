package chatty.pages;

import chatty.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage {

    @FindBy(xpath = "//*[@data-test= \"email\"]")
    private WebElement emailEditBox;

    @FindBy(xpath = "//*[@data-test=\"password\"]")
    private WebElement passwordEditBox;

    @FindBy(xpath = "//*[@data-test=\"confirmPassword\"]")
    private WebElement confirmPasswordEditBox;

    @FindBy(className = "registration-btn")
    private WebElement registrationButton;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public CreateAccountPage inputEmail (String email){
        emailEditBox.sendKeys(email);
        return this;
    }

    public CreateAccountPage inputPassword (String password){
        passwordEditBox.sendKeys(password);
        return this;
    }

    public CreateAccountPage inputConfirmPassword (String password){
        confirmPasswordEditBox.sendKeys(password);
        return this;
    }

    public BlogPage clickLoginButton(){
        registrationButton.click();
        return new BlogPage(driver);
    }
}
