package updateDeleteUser;

import basetest.BaseTest;
import chatty.pages.AdminPage;
import chatty.pages.LoginPage;
import chatty.pages.ProfilePage;
import org.junit.jupiter.api.BeforeEach;

public class TestUpdateProfile extends BaseTest {

    private String emailAdmin = "tbceee123@gmail.com";
    private String passwordAdmin = "abc123450001";
    private String userEmail = "abcd@gmail.com";
    private String name = "John";
    private String surname = "White";
    private String date = "01";
    private String month = "07";
    private String year = "2000";
    private String phone = "380672357898";
    private String oldPassword = "abc12345";
    private String newPassword = "abc000";


    @BeforeEach
    public void loginAdminwithValidData() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail(emailAdmin)
                .inputPassword(passwordAdmin)
                .clickLoginButton();
    }

    public void updateProfilTest() {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.inputUserEmailInSearchBox(userEmail)
                .clickSearchButton()
                .clickEditButton();
        ProfilePage profilePage = new ProfilePage(driver);
        defineTestResultTrue(profilePage.getTextUserEmailProfile().contains(userEmail));
        profilePage.inputName(name)
                .inputSurname(surname)
                .inputBirthday(date, month, year)
                .inputPhone(phone)
                .clickSelectDropDownMenu()
                .clickMaleInSelectDropDownMenu()
                .clickPasswordToChange()
                .inputOldPassword(oldPassword)
                .inputNewPassword(newPassword)
                .inputConfirmNewPassword(newPassword)
                .clickSavePasswordButton()
                .clickSaveButton();
        defineTestResultEquals(name, profilePage.getTextName());
        defineTestResultEquals(surname, profilePage.getTextSurname());
        defineTestResultEquals(String.format("%s-%s-%s", year, month, date), profilePage.getTextBirthday());
        defineTestResultEquals(phone, profilePage.getTextPhone());
        defineTestResultEquals("Male", profilePage.getTextGender());

    }
}
