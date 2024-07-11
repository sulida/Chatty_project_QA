package chatty.pages;

import chatty.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BasePage {

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
    }

    public ContactUsPage inputName(String name){
        inputNameEditBox.click();
        return this;
    }

    public ContactUsPage inputEmail(String email){
        inputEmailEditBox.click();
        return this;
    }

    public ContactUsPage inputMessage(String message){
        inputMessageEditBox.click();
        return this;
    }

    public ContactUsPage clickSendMessageButton(){
        sendMessageButton.click();
        return new ContactUsPage(driver);
    }
}
