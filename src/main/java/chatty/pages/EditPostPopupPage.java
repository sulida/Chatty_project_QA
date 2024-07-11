package chatty.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class EditPostPopupPage extends BasePage {

    @FindBy(xpath = "//input[@name=\"title\"]" )
    private WebElement titleEditBox;

    @FindBy(xpath = "//input[@name=\"description\"]" )
    private WebElement descriptionEditBox;

    @FindBy(xpath = "//*[@name=\"content\"]" )
    private WebElement contentEditBox;

    @FindBy(xpath = "//*[@alt=\"Uploaded\"]" )
    private WebElement attachPhotoBox;

    @FindBy(id = "publishDate" )
    private WebElement dateDelayPostBox;

    @FindBy(xpath = "//label[@for=\"draftCheckbox\"]" )
    private WebElement saveAsDraftToggle;

    @FindBy(xpath = "//button[@data-test=\"submit\"]")
    private WebElement submitButton;

    public EditPostPopupPage(WebDriver driver) {
        super(driver);
    }

    public EditPostPopupPage inputTitle(String title){
        titleEditBox.sendKeys(title);
        return this;
    }

    public EditPostPopupPage inputDescription(String description){
        descriptionEditBox.sendKeys(description);
        return this;
    }

    public EditPostPopupPage inputContent(String content){
        contentEditBox.sendKeys(content);
        return this;
    }

    public EditPostPopupPage clickAttachPhotoBox(String filePath){
        attachPhotoBox.sendKeys(filePath);
        return this;
    }

    public EditPostPopupPage dragNDropPhoto(String filePath){
        new Actions(driver).moveToElement(attachPhotoBox)
                .click()
                .build()
                .perform();
        attachPhotoBox.sendKeys(filePath);
        return this;
    }

    public EditPostPopupPage fillDateForDelayPost(String date, String month, String year){
        dateDelayPostBox.clear();
        dateDelayPostBox.sendKeys(date + month + year);
        return this;
    }

    public EditPostPopupPage clickSaveAsDraftToggle(){
        saveAsDraftToggle.click();
        return this;
    }

    public PostPage clickSubmitButton(){
        submitButton.click();
        return new PostPage(driver);

    }
}
