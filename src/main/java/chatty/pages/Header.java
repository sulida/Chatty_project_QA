package chatty.pages;

import chatty.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header extends BasePage {

    private WebDriverWait wait;

    @FindBy(xpath = "//*[@href='/homeblog']")
    private WebElement home;

    @FindBy(xpath = "//a[@href=\"/about\"]")
    private WebElement about;

    @FindBy(xpath = "//a[@href=\"/contact\"]")
    private WebElement contact;

    @FindBy(xpath = "//*[@class='header__user header__menu']")
    private WebElement helloDropDownMenu;

    @FindBy(xpath = "//a[@href=\"/userprofile\"]")
    private WebElement yourProfileLink;

    @FindBy(xpath = "//a[@href=\"/draft\"]")
    private WebElement myDraftsLink;

    @FindBy(xpath = "//a[@href=\"/users\"]")
    private WebElement adminPanelLink;

    @FindBy(xpath = "//a[@href=\"/login\"]")
    private WebElement logOutLink;

    public Header(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public BlogPage clickHomeLink() {
       wait.until(ExpectedConditions.elementToBeClickable(home));
        home.click();
        return new BlogPage(driver);
    }

    public ContactUsPage clickContactLink() {
        wait.until(ExpectedConditions.elementToBeClickable(contact));
        contact.click();
        return new ContactUsPage(driver);
    }

    public Header hoverDropDownMenuHello() {
        wait.until(ExpectedConditions.elementToBeClickable(helloDropDownMenu));
        new Actions(driver).moveToElement(helloDropDownMenu).perform();
        return this;
    }

    public ProfilePage clickYourProfileLink() {
        yourProfileLink.click();
        return new ProfilePage(driver);
    }

    public AdminPage clickAdminPanelLink() {
        Select select = new Select(helloDropDownMenu);
        select.selectByVisibleText("Admin Panel");
        return new AdminPage(driver);
    }

    public LoginPage clickLogoutLink() {
        logOutLink.click();
        return new LoginPage(driver);
    }

    public String getTextDropDownMenuAdminPanel() {
        return adminPanelLink.getText();
    }

    public boolean helloUserIsDisplayed() {
        return helloDropDownMenu.isDisplayed();

    }

}
