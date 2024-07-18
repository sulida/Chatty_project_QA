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

public class MyDraftsPage extends BasePage {

    private WebDriverWait wait;

    @FindBy(xpath = "//div[@class='post']")
    private WebElement post;

    @FindBy(xpath = "//div[@class='post']")
    private List<WebElement> posts;

    public MyDraftsPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isDraftPostCreated(String expectedTitle) {
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

    public void clickDraftPostCreated(String expectedTitle) {

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

}
