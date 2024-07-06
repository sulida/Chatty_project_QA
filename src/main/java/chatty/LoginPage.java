package chatty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(id = "email")
    private WebElement emailEditBox;


    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public LoginPage open(){
        driver.get("http://chatty.telran-edu.de:8089/login");
        return this;
    }
}
