package chatty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostPage extends BasePage {

    @FindBy(xpath = "//*[@alt=\"edit button\"]")
    private WebElement editButton;
    @FindBy(xpath = "//*[@alt=\"delete button\"]")
    private WebElement deleteButton;

    public EditPostPopupPage clickEditButton(){
        editButton.click();
        return new EditPostPopupPage(driver);
    }

    public BlogPage clickDeleteButton(){
        deleteButton.click();
        return new BlogPage(driver);
    }





    public PostPage(WebDriver driver) {
        super(driver);
    }
}
