package chatty.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public BlogPage(WebDriver driver) {
        super(driver);
    }

    public CreatePostPage clickCreatePostPlusButton(){
        createPostPlusButton.click();
        return new CreatePostPage(driver);
    }

    public BlogPage clickMyPostsToggle(){
        myPostsToggle.click();
        return new BlogPage(driver);
    }

    public PostPage clickPost(){
        post.click();
        return new PostPage(driver);
    }

    public PostPage clickNewsFeed(){
        newsFeedButton.click();
        return new PostPage(driver);
    }

    public MyDraftsPage clickMyDrafts(){
        myDraftsButton.click();
        return new MyDraftsPage(driver);
    }

}
