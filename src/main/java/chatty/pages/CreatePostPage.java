package chatty.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CreatePostPage extends BasePage {

    @FindBy(xpath = "//*[@name=\"title\"]")
    private WebElement titleEditBox;

    @FindBy(xpath = "//*[@placeholder=\"Description\"]")
    private WebElement descriptionEditBox;

    @FindBy(xpath = "//*[@name=\"content\"]")
    private WebElement contentEditBox;
    @FindBy(xpath = "//p[text()=\"Drag 'n' drop some files here, or click to select files\"]")
    private WebElement attachPhotoBox;

    @FindBy(xpath = "//label[@for=\"draftCheckbox\"]")
    private WebElement saveAsDraftToggle;

    @FindBy(id = "publishDate")
    private WebElement dateDelayPostEditBox;

    @FindBy(xpath = "//button[@data-test=\"submit\"]")
    private WebElement submitButton;

    public CreatePostPage(WebDriver driver) {
        super(driver);
    }

    public CreatePostPage inputTitle(String title){
        titleEditBox.sendKeys(title);
        return this;
    }

    public CreatePostPage inputDescription(String description){
        descriptionEditBox.sendKeys(description);
        return this;
    }

    public CreatePostPage inputContent(String content){
        contentEditBox.sendKeys(content);
        return this;
    }

    public CreatePostPage clickAttachPhotoBox(String filePath){
        attachPhotoBox.sendKeys(filePath);
        return this;
    }

    public CreatePostPage dragNDropPhoto(String filePath){
        new Actions(driver).moveToElement(attachPhotoBox)
                .click()
                .build()
                .perform();
        attachPhotoBox.sendKeys(filePath);
        return this;
    }

    public CreatePostPage fillDateForDelayPost(String date, String month, String year){
        dateDelayPostEditBox.clear();
        dateDelayPostEditBox.sendKeys(date + month + year);
        return this;
    }

    public CreatePostPage clickSaveAsDraftToggle(){
        saveAsDraftToggle.click();
        return this;
    }

    public BlogPage clickSubmitButton(){
        submitButton.click();
        return new BlogPage(driver);
    }
}
