package chatty.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChangePasswordPopUpPage extends BasePage {
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@placeholder=\"Old password\"]")
    private WebElement oldPasswordEditBox;

    @FindBy(xpath = "//input[@placeholder=\"New password\"]")
    private WebElement newPasswordEditBox;

    @FindBy(xpath = "//input[@placeholder=\"Confirm new password\"]")
    private WebElement confirmNewPasswordEditBox;

    @FindBy(xpath = "//button[@class=\"PasswordModal_pass_btn__eGL9h\"]")
    private WebElement savePasswordButton;

    public ChangePasswordPopUpPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public ChangePasswordPopUpPage inputOldPassword(String oldpassword) {
        oldPasswordEditBox.sendKeys(oldpassword);
        return this;
    }

    public ChangePasswordPopUpPage inputNewPassword(String newPassword) {
        newPasswordEditBox.sendKeys(newPassword);
        return this;
    }

    public ChangePasswordPopUpPage inputConfirmNewPassword(String newPassword) {
        confirmNewPasswordEditBox.sendKeys(newPassword);
        return this;
    }

    public ProfilePage clickSavePasswordButton() {
        wait.until(ExpectedConditions.elementToBeClickable(savePasswordButton));
        savePasswordButton.click();
        return new ProfilePage(driver);

    }
}
