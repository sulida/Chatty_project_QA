package chatty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlogPage extends BasePage {
    @FindBy(xpath = "//span[@ data-test=\"post-header__plus\"]")
    private WebElement createPostPlusButton;

    @FindBy(xpath = "//label[@for=\"myPostsId\"]")
    private WebElement myPostsToggle;

    @FindBy(xpath = "//div[@class=\"post\"]")
    private WebElement myPost;

    @FindBy(xpath = "//div[@class=\"post\"][1]")
    private WebElement myPost1;

    @FindBy(xpath = "//div[@class=\"post\"][2]")
    private WebElement myPost2;

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

    public PostPage clickMyPost(){
        myPost.click();
        return new PostPage(driver);
    }
    public PostPage clickMyPost1(){
        myPost1.click();
        return new PostPage(driver);
    }
    public PostPage clickMyPost2(){
        myPost2.click();
        return new PostPage(driver);
    }
}
