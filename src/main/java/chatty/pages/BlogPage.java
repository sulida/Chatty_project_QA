package chatty.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BlogPage extends BasePage {
    @FindBy(xpath = "//span[@ data-test=\"post-header__plus\"]")
    private WebElement createPostPlusButton;

    @FindBy(xpath = "//label[@for=\"myPostsId\"]")
    private WebElement myPostsToggle;

    @FindBy(xpath = "//div[@class=\"post\"]")
    private WebElement post;

    @FindBy(xpath = "//span[text()=\"News Feed\"]")
    private WebElement newsFeedButton;

    @FindBy(xpath = "//span[text()=\"My drafts\"]")
    private WebElement myDraftsButton;

    @FindBy(className = "post-header__feed")
    private WebElement feedHeadLine;

    public BlogPage(WebDriver driver) {
        super(driver);
    }

    public CreatePostPage clickCreatePostPlusButton(){
        createPostPlusButton.click();
        return new CreatePostPage(driver);
    }

    public BlogPage clickMyPostsToggle(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(myPostsToggle));
        myPostsToggle.click();
        return new BlogPage(driver);
    }

    public PostPage clickPost(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(post));
        post.click();
        return new PostPage(driver);
    }

    public PostPage clickNewsFeed(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(newsFeedButton));
        newsFeedButton.click();
        return new PostPage(driver);
    }

    public MyDraftsPage clickMyDrafts(){
        myDraftsButton.click();
        return new MyDraftsPage(driver);
    }

    public boolean feedheadLineIsDisplayed(){
        return feedHeadLine.isDisplayed();
    }

}
