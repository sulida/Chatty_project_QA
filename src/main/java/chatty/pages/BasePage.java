package chatty.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.logging.Logger;

public class BasePage{
    protected WebDriver driver;
    protected final Logger logger;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.logger = Logger.getLogger(this.getClass().getName());
        PageFactory.initElements(driver, this);
    }

}
