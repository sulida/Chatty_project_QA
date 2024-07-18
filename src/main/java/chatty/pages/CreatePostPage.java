package chatty.pages;

import org.openqa.selenium.By;
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

public class CreatePostPage extends BasePage {

    private WebDriverWait wait;

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

    @FindBy(className = "error")
    private WebElement errorMessagePleaseFillTheField;

    public CreatePostPage(WebDriver driver) {
        super(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public CreatePostPage inputTitle(String title) {
        titleEditBox.sendKeys(title);
        return this;
    }

    public CreatePostPage inputDescription(String description) {
        descriptionEditBox.sendKeys(description);
        return this;
    }

    public CreatePostPage inputContent(String content) {
        contentEditBox.sendKeys(content);
        return this;
    }

    public CreatePostPage clickAttachPhotoBox(String filePath) {
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

    public CreatePostPage dragNDropPhoto(String filePath) {
        wait.until(ExpectedConditions.elementToBeClickable(attachPhotoBox));
        attachPhotoBox.click();
        try {
            Robot robot = new Robot();

            robot.delay(1000);
            StringSelection selection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        } catch (AWTException e) {
            e.printStackTrace();
        }

        return this;
    }

    public CreatePostPage fillDateForDelayPost(String date, String month, String year) {
        dateDelayPostEditBox.clear();
        dateDelayPostEditBox.sendKeys(date + month + year);
        return this;
    }

    public CreatePostPage clickSaveAsDraftToggle() {
        saveAsDraftToggle.click();
        return this;
    }

    public BlogPage clickSubmitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();
        return new BlogPage(driver);
    }

    public String getTextfromErrorMessage() {
        return errorMessagePleaseFillTheField.getText();
    }
}
