package chatty;

import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public LoginPage open(){
        driver.get("http://chatty.telran-edu.de:8089/login");
        return this;
    }
}
