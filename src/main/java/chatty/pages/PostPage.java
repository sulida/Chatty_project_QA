package chatty.pages;

import chatty.pages.BasePage;
import chatty.pages.BlogPage;
import chatty.pages.EditPostPopupPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostPage extends BasePage {

    @FindBy(xpath = "//*[@alt=\"edit button\"]")
    private WebElement editButton;
    @FindBy(xpath = "//*[@alt=\"delete button\"]")
    private WebElement deleteButton;

    public PostPage(WebDriver driver) {
        super(driver);
    }

    public EditPostPopupPage clickEditButton(){
        editButton.click();
        return new EditPostPopupPage(driver);
    }

    public BlogPage clickDeleteButton(){
        deleteButton.click();
        return new BlogPage(driver);
    }

}
