package basetests;

import chromeRegistry.ChromeRegistry;
import io.opentelemetry.sdk.common.CompletableResultCode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.ScreenshotUtil;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        this.driver = new ChromeRegistry().registerDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void defineTestResultEquals(Object expected, Object actual) {
        String name = this.getClass().getName();
        try {
            assertEquals(expected, actual);
        } catch (AssertionError e) {
            ScreenshotUtil.captureScreen(driver, name);
            fail("TEST FAILED");
        }
    }

    public void defineTestResultTrue(boolean condition) {
        String name = this.getClass().getName();
        try {
            assertTrue(condition);
        } catch (AssertionError e) {
            ScreenshotUtil.captureScreen(driver, name);
            fail("TEST FAILED");
        }
    }

    public void defineTestResultFalse(boolean condition) {
        String name = this.getClass().getName();
        try {
            assertFalse(condition);
        } catch (AssertionError e) {
            fail("TEST FAILED");
        }
    }

//    @AfterEach
//    public void tearDown() {
//        driver.quit();
//    }
}

