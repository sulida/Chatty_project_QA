package chatty.pages;

import chatty.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage extends BasePage {

    private WebDriverWait wait;

    @FindBy(xpath = "//p[@data-test=\"profileEmail\"]")
    private WebElement userEmailInHeadLine;

    @FindBy(xpath = "//span[@data-test=\"post-header__plus\"]")
    private WebElement editPlusButton;

    @FindBy(xpath = "//input[@data-test=\"profileName\"]")
    private WebElement profileNameEditBox;

    @FindBy(id = "birthDate")
    private WebElement birthdayEditBox;
    @FindBy(xpath = "//input[@data-test=\"profileSurname\"]")
    private WebElement profileSurnameEditBox;


    @FindBy(xpath = "//input[@name=\"phone\"]")
    private WebElement phoneEditBox;

    @FindBy(id = "gender")
    private WebElement selectGenderDropDownMenu;

    @FindBy(xpath = "//option[@value=\"FEMALE\"]")
    private WebElement femaleInSelectDropDownMenu;

    @FindBy(xpath = "//option[@value=\"MALE\"]")
    private WebElement maleInSelectDropDownMenu;

    @FindBy(xpath = "//button[@name=\"password\"]")
    private WebElement changePasswordLink;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement saveButton;

    public ProfilePage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public ProfilePage inputName(String name) {
        profileNameEditBox.clear();
        profileNameEditBox.sendKeys(name);
        return this;
    }

    public ProfilePage inputSurname(String surname) {
        profileSurnameEditBox.clear();
        profileSurnameEditBox.sendKeys(surname);
        return this;
    }

    public ProfilePage inputBirthday(String date, String month, String year) {
        birthdayEditBox.clear();
        birthdayEditBox.sendKeys(date, month, year);
        return this;
    }

    public ProfilePage inputPhone(String phone) {
        profileSurnameEditBox.clear();
        profileSurnameEditBox.sendKeys(phone);
        return this;
    }

    public ProfilePage clickSelectDropDownMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(selectGenderDropDownMenu));
        selectGenderDropDownMenu.click();
        return this;
    }

    public ProfilePage clickMaleInSelectDropDownMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(maleInSelectDropDownMenu));
        maleInSelectDropDownMenu.click();
        return this;
    }

    public ProfilePage clickFemaleInSelectDropDownMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(femaleInSelectDropDownMenu));
        femaleInSelectDropDownMenu.click();
        return this;
    }

    public ChangePasswordPopUpPage clickPasswordToChange() {
        wait.until(ExpectedConditions.elementToBeClickable(changePasswordLink));
        changePasswordLink.click();
        return new ChangePasswordPopUpPage(driver);
    }

    public ProfilePage clickSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButton.click();
        return new ProfilePage(driver);

    }

    public String getTextUserEmailProfile() {
        wait.until(ExpectedConditions.visibilityOf(userEmailInHeadLine));
        return userEmailInHeadLine.getText();
    }

    public String getTextName() {
        wait.until(ExpectedConditions.visibilityOf(profileNameEditBox));
        return profileNameEditBox.getAttribute("value");
    }

    public String getTextSurname() {
        wait.until(ExpectedConditions.visibilityOf(profileSurnameEditBox));
        return birthdayEditBox.getAttribute("value");
    }

    public String getTextBirthday() {
        wait.until(ExpectedConditions.visibilityOf(birthdayEditBox));
        return birthdayEditBox.getAttribute("value");
    }

    public String getTextPhone() {
        wait.until(ExpectedConditions.visibilityOf(phoneEditBox));
        return phoneEditBox.getAttribute("value");
    }

    public String getTextGender() {
        wait.until(ExpectedConditions.visibilityOf(selectGenderDropDownMenu));
        return selectGenderDropDownMenu.getAttribute("value");
    }

}
