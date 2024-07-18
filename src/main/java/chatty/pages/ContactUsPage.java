package chatty.pages;

import chatty.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsPage extends BasePage {

    private WebDriverWait wait;

    @FindBy(id = "name")
    private WebElement inputNameEditBox;

    @FindBy(id = "email")
    private WebElement inputEmailEditBox;

    @FindBy(id = "content")
    private WebElement inputMessageEditBox;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement sendMessageButton;

    @FindBy(className = "success-message")
    private WebElement successMessage;

    public ContactUsPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public ContactUsPage inputName(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(inputNameEditBox));
        inputNameEditBox.sendKeys(name);
        return this;
    }

    public ContactUsPage inputEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(inputEmailEditBox));
        ;
        inputEmailEditBox.sendKeys(email);
        return this;
    }

    public ContactUsPage inputMessage(String message) {
        wait.until(ExpectedConditions.elementToBeClickable(inputMessageEditBox));
        inputMessageEditBox.sendKeys(message);
        return this;
    }

    public ContactUsPage clickSendMessageButton() {
        wait.until(ExpectedConditions.elementToBeClickable(sendMessageButton));
        sendMessageButton.click();
        return new ContactUsPage(driver);
    }

    public String getTextFromSuccessfulMessage() {

        return successMessage.getText();
    }
}
