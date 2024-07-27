package updateDeleteUser;

import basetest.BaseTest;
import chatty.pages.AdminPage;
import chatty.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDeleteProfile extends BaseTest {

    private String emailAdmin = "tbceee123@gmail.com";
    private String passwordAdmin = "abc123450001";
    private String userEmail = "abcd@gmail.com";

    @BeforeEach
    public void loginAdminwithValidData() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail(emailAdmin)
                .inputPassword(passwordAdmin)
                .clickLoginButton();
    }

    @Test
    public void deleteProfileTest() {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.inputUserEmailInSearchBox(userEmail)
                .clickSearchButton()
                .clickDeleteButton()
                .inputUserEmailInSearchBox(userEmail)
                .clickSearchButton();
        defineTestResultTrue(adminPage.userEmailIsDisplayed());
    }
}
