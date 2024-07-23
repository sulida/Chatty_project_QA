package chatty.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class BlogPage extends BasePage {

    private WebDriverWait wait;

    @FindBy(xpath = "//span[@ data-test=\"post-header__plus\"]")
    private WebElement createPostPlusButton;

    @FindBy(xpath = "//label[@for=\"myPostsId\"]")
    private WebElement myPostsToggle;

    @FindBy(xpath = "//div[@class='post']")
    private WebElement post;

    @FindBy(xpath = "//div[@class='post']")
    private List<WebElement> posts;

    @FindBy(xpath = "//span[text()=\"News Feed\"]")
    private WebElement newsFeedButton;

    @FindBy(xpath = "//span[text()=\"My drafts\"]")
    private WebElement myDraftsButton;

    @FindBy(className = "post-header__feed")
    private WebElement feedHeadLine;

    @FindBy(xpath = "//h3")
    private List<WebElement> postTitles;

    public BlogPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public CreatePostPage clickCreatePostPlusButton() {
        wait.until(ExpectedConditions.elementToBeClickable(createPostPlusButton));
        createPostPlusButton.click();
        return new CreatePostPage(driver);
    }

    public BlogPage clickMyPostsToggle() {
        wait.until(ExpectedConditions.elementToBeClickable(myPostsToggle));
        myPostsToggle.click();
        return new BlogPage(driver);
    }

    public PostPage clickPost() {
        wait.until(ExpectedConditions.elementToBeClickable(post));
        post.click();
        return new PostPage(driver);
    }

    public PostPage clickNewsFeed() {
        wait.until(ExpectedConditions.elementToBeClickable(newsFeedButton));
        newsFeedButton.click();
        return new PostPage(driver);
    }

    public MyDraftsPage clickMyDrafts() {
        wait.until(ExpectedConditions.elementToBeClickable(myDraftsButton));
        myDraftsButton.click();
        return new MyDraftsPage(driver);
    }

    public boolean feedHeadLineIsDisplayed() {
        return feedHeadLine.isDisplayed();
    }

    public String getTextFromFeedHeadLine() {
        return feedHeadLine.getText();
    }

//    private WebElement findPostByTitle (String expectedTitle) throws Exception {
//        wait.until(ExpectedConditions.visibilityOfAllElements(posts));
//        for (WebElement post : posts) {
//            WebElement postTitle = post.findElement(By.xpath(".//h3"));
//            if (postTitle.getText().equals(expectedTitle)) {
//                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", post);
//                return post;
//            }
//        }
//        throw new Exception("Post with the title " + expectedTitle + " is not found");
//    }


    public void clickPostCreated(String expectedTitle) {

//        try {
////            WebElement post =
//            findPostByTitle(expectedTitle);
//            if (post != null) {
//                post.click();
//            }
//        } catch (Exception e) {
//            System.err.println("Error: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }

        wait.until(ExpectedConditions.visibilityOfAllElements(posts));
        try {
            boolean postFound = false;
            for (WebElement post : posts) {
                WebElement postTitle = post.findElement(By.xpath(".//h3"));
                if (postTitle.getText().equals(expectedTitle)) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", post);
                    post.click();
                    postFound = true;
                    break;
                }
            }
            if (!postFound) {
                throw new Exception("Post with the title " + expectedTitle + " is not found");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean isPostCreated(String expectedTitle) {
//        boolean postFound = false;
//        try {
//            WebElement post = findPostByTitle(expectedTitle);
//            postFound = post != null;
//        } catch (Exception e) {
//            System.err.println("Error: " + e.getMessage());
//            e.printStackTrace();
//        }
//        return postFound;
//    }

        wait.until(ExpectedConditions.visibilityOfAllElements(posts));
        boolean postFound = false;
        try {
            for (WebElement post : posts) {
                WebElement postTitle = post.findElement(By.xpath(".//h3"));
                if (postTitle.getText().equals(expectedTitle)) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", post);
                    postFound = true;
                    break;
                }
            }
            if (!postFound) {
                throw new Exception("Post with the title " + expectedTitle + " is not found");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        return postFound;
    }



//    public boolean deletePostsByTitle(String expectedTitle) {
////       wait.until(ExpectedConditions.visibilityOfAllElements(posts));
////        boolean postDeleted = false;
////
////        try {
////            for (WebElement post : posts) {
////                WebElement postTitle = post.findElement(By.xpath(".//h3"));
////                if (postTitle.getText().equals(expectedTitle)) {
////                    WebElement deleteButton = post.findElement(By.xpath("//*[@alt=\"delete button\"]"));
////                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", post);
////                    post.click();
////                    deleteButton.click();
////
////                    wait.until(ExpectedConditions.stalenessOf(post));
////                    postDeleted = true;
////                }
////            }
////        } catch (Exception e) {
////            System.err.println("Error: " + e.getMessage());
////            e.printStackTrace();
////        }
////        return postDeleted;
////    }
//
//    }
}
