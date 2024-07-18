package chatty.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminPage extends BasePage {

    private WebDriverWait wait;

    @FindBy(xpath = "//*[@data-test=\"adminPanelTitle\"]")
    private WebElement adminPanelTitle;

    @FindBy(xpath = "//input[@type=\"text\"]")
    private WebElement emailSearchBox;

    @FindBy(className = "email-btn")
    private WebElement searchButton;

    @FindBy(xpath = "//span[@data-test=\"editUserButton\"]")
    private WebElement editButton;

    @FindBy(xpath = "//span[@data-test=\"deleteUserButton\"]")
    private WebElement deleteButton;

    @FindBy(xpath = "//td[@data-test=\"userEmail\"]")
    private WebElement userEmail;


    public AdminPage(WebDriver driver) {

        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public AdminPage inputUserEmailInSearchBox(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(emailSearchBox));
        emailSearchBox.sendKeys(email);
        return new AdminPage(driver);
    }

    public AdminPage clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
        return new AdminPage(driver);
    }

    public ProfilePage clickEditButton() {
        wait.until(ExpectedConditions.elementToBeClickable(editButton));
        editButton.click();
        return new ProfilePage(driver);
    }

    public AdminPage clickDeleteButton() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        deleteButton.click();
        return new AdminPage(driver);
    }

    public String getTextFromAdninPanelTitle() {
        return adminPanelTitle.getText();
    }

    public String getTextUserEmail() {
        wait.until(ExpectedConditions.visibilityOf(userEmail));
        return userEmail.getText();
    }

    public boolean userEmailIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(userEmail));
        return userEmail.isDisplayed();
    }

}
