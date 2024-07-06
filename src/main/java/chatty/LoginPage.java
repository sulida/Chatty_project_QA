package chatty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(xpath = "//*[@data-test= \"email\"]")
    private WebElement emailEditBox;
    @FindBy(xpath = "//*[@data-test=\"password\"]")
    private WebElement passwordEditBox;

    @FindBy(xpath = "//*[@data-test=\"submit\"]")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@href=\"/registration\" and contains(text(), 'Sign in')]")
    private WebElement signInButton;


    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public LoginPage open(){
        driver.get("http://chatty.telran-edu.de:8089/login");
        return this;
    }

    public LoginPage inputEmail (String email){
        emailEditBox.sendKeys(email);
        return this;
    }

    public LoginPage inputPassword (String password){
        passwordEditBox.sendKeys(password);
        return this;
    }

    public BlogPage clickLoginButton(){
        loginButton.click();
        return new BlogPage(driver);
    }

}

