package chatty.pages;

import chatty.pages.BasePage;
import chatty.pages.BlogPage;
import chatty.pages.EditPostPopupPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PostPage extends BasePage {

    private WebDriverWait wait;

    @FindBy(xpath = "//*[@alt=\"edit button\"]")
    private WebElement editButton;
    @FindBy(xpath = "//*[@alt=\"delete button\"]")
    private WebElement deleteButton;

    @FindBy(xpath = "//h3")
    private WebElement title;


    public PostPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public EditPostPopupPage clickEditButton() {
        wait.until(ExpectedConditions.elementToBeClickable(editButton));
        editButton.click();
        return new EditPostPopupPage(driver);
    }

    public BlogPage clickDeleteButton() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        deleteButton.click();
        return new BlogPage(driver);
    }

    public String getTextFromTitle() {
        return title.getText();
    }

}
