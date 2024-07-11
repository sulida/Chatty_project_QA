package chatty.pages;

import chatty.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Header extends BasePage {

    @FindBy(xpath = "//*[@alt=\"Uploaded\"]")
    private WebElement home;

    @FindBy(xpath = "//a[@href=\"/about\"]")
    private WebElement about;

    @FindBy(xpath = "//a[@href=\"/contact\"]")
    private WebElement contact;

    @FindBy(xpath = "//div[@class=\"header__user open\"]")
    private WebElement helloDropDownMenu;

    @FindBy(xpath = "//a[@href=\"/userprofile\"]")
    private WebElement yourProfile;

    @FindBy(xpath = "//a[@href=\"/draft\"]")
    private WebElement myDrafts;

    @FindBy(xpath = "//a[@href=\"/login\"]")
    private WebElement logOut;

    public Header(WebDriver driver) {
        super(driver);
    }

    public BlogPage clickHomeLink(){
        home.click();
        return new BlogPage(driver);
    }

    public ContactUsPage clickContactLink(){
        contact.click();
        return new ContactUsPage(driver);
    }

        public ProfilePage clickYourProfileLink(){
        helloDropDownMenu.click();
        new Actions(driver).moveToElement(yourProfile).click();
        return new ProfilePage(driver);
    }

}
