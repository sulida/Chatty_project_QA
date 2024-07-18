package update_delete_user;

import basetests.BaseTest;
import chatty.pages.AdminPage;
import chatty.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;

public class TestDeleteProfile extends BaseTest {

    private String emailAdmin = "tbceee123@gmail.com";
    private String passwordAdmin = "abc123450001";
    private String userEmail =

    @BeforeEach
    public void loginAdminwithValidData() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail(emailAdmin)
                .inputPassword(passwordAdmin)
                .clickLoginButton();
    }

    public void deleteProfileTest(){
        AdminPage adminPage = new AdminPage(driver);
        adminPage.inputUserEmailInSearchBox(userEmail)
                .clickSearchButton()
                .clickDeleteButton()
                .inputUserEmailInSearchBox(userEmail)
                .clickSearchButton();
        defineTestResultTrue(adminPage.userEmailIsDisplayed());
    }
}
