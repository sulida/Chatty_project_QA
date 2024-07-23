package chatty.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class EditPostPopupPage extends BasePage {

    private WebDriverWait wait;

    @FindBy(xpath = "//input[@name=\"title\"]")
    private WebElement titleEditBox;

    @FindBy(xpath = "//input[@name=\"description\"]")
    private WebElement descriptionEditBox;

    @FindBy(xpath = "//*[@name=\"content\"]")
    private WebElement contentEditBox;

    @FindBy(xpath = "//p[text()=\"Drag 'n' drop some files here, or click to select files\"]")
    private WebElement attachPhotoBoxDefault;

    @FindBy(xpath = "//img[@alt=\"Uploaded\"]")
    private WebElement attachPhotoBoxUploaded;

    @FindBy(id = "publishDate")
    private WebElement dateDelayPostBox;

    @FindBy(xpath = "//label[@for=\"draftCheckbox\"]")
    private WebElement saveAsDraftToggle;

    @FindBy(xpath = "//button[@data-test=\"submit\"]")
    private WebElement submitButton;

    public EditPostPopupPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public EditPostPopupPage inputTitle(String title) {
        titleEditBox.clear();
        titleEditBox.sendKeys(title);
        return this;
    }

    public EditPostPopupPage inputDescription(String description) {
        descriptionEditBox.clear();
        descriptionEditBox.sendKeys(description);
        return this;
    }

    public EditPostPopupPage inputContent(String content) {
        contentEditBox.clear();
        contentEditBox.sendKeys(content);
        return this;
    }

    public EditPostPopupPage clickAttachPhotoBox(String filePath) {
        WebElement attachPhotoBox = null;

        try {
            wait.until(ExpectedConditions.visibilityOf(attachPhotoBoxDefault));
            attachPhotoBox = attachPhotoBoxDefault;
        } catch (TimeoutException e) {
            wait.until(ExpectedConditions.visibilityOf(attachPhotoBoxUploaded));
            attachPhotoBox = attachPhotoBoxUploaded;
        }

        wait.until(ExpectedConditions.elementToBeClickable(attachPhotoBox));
        attachPhotoBox.click();

        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        try {
            Robot robot = new Robot();
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(1500);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-test=\"uploaded-image\"]")));
        } catch (AWTException e) {
            e.printStackTrace();
        }

        return this;
    }

    public EditPostPopupPage dragNDropPhoto(String filePath) {
        new Actions(driver).moveToElement(attachPhotoBoxDefault)
                .click()
                .build()
                .perform();
        attachPhotoBoxDefault.sendKeys(filePath);
        return this;
    }

    public EditPostPopupPage fillDateForDelayPost(String date, String month, String year) {
        dateDelayPostBox.clear();
        dateDelayPostBox.sendKeys(date + month + year);
        return this;
    }

    public EditPostPopupPage clickSaveAsDraftToggle() {
        saveAsDraftToggle.click();
        return this;
    }

    public PostPage clickSubmitButton() {
        submitButton.click();
        return new PostPage(driver);

    }
}
