package chatty.pages;

import chatty.pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateAccountPage extends BasePage {

    @FindBy(xpath = "//*[@data-test= \"email\"]")
    private WebElement emailEditBox;

    @FindBy(xpath = "//*[@data-test=\"password\"]")
    private WebElement passwordEditBox;

    @FindBy(xpath = "//*[@data-test=\"confirmPassword\"]")
    private WebElement confirmPasswordEditBox;

    @FindBy(xpath = "//button[@class=\"registration-btn\"]")
    private WebElement registrationButton;

    @FindBy(xpath = "//h1[text()=\"Create Account\"]")
    private WebElement headlineCreateAccount;

    @FindBy(xpath = "//select")
    private WebElement selectDropDownMenu;

    @FindBy(xpath = "//select/option[1]")
    private WebElement selectUserDropDownMenu;

    @FindBy(xpath = "//select/option[2]")
    private WebElement selectAdminDropDownMenu;

    @FindBy(xpath = "//div[@class=\"text-error\"]")
    private WebElement errorMessage;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public CreateAccountPage inputEmail (String email){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(emailEditBox));
        emailEditBox.sendKeys(email);
        return this;
    }

    public CreateAccountPage inputPassword (String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(passwordEditBox));
        passwordEditBox.sendKeys(password);
        return this;
    }

    public CreateAccountPage inputConfirmPassword (String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(confirmPasswordEditBox));
        confirmPasswordEditBox.sendKeys(password);
        return this;
    }

    public BlogPage clickRegistrationButton(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(registrationButton));
        registrationButton.click();
        return new BlogPage(driver);
    }

    public  boolean headlineCreateAccountIsDisplayed() {
        return headlineCreateAccount.isDisplayed();
    }

    public CreateAccountPage selectDropDownMenu(){
        Select select = new Select(selectDropDownMenu);
        select.selectByVisibleText("admin");
        return this;
    }

    public CreateAccountPage selectUser(){
        Select select = new Select(selectDropDownMenu);
        select.selectByValue("user");
        return this;
    }

    public CreateAccountPage selectAdmin(){
        Select select = new Select(selectDropDownMenu);
        select.selectByValue("admin");
        return this;
    }

    public AdminPage clickRegistrationButtonForAdmin(){
        registrationButton.click();
        return new AdminPage(driver);
    }

    public String getTextFromErrorMessage(){
        return errorMessage.getText();
    }

    public String getTextFromHeadline(){
        return headlineCreateAccount.getText();
    }

}
