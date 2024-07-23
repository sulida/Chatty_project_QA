package postCreatingUpdatingDeleting;

import basetest.BaseTest;
import chatty.pages.BlogPage;
import chatty.pages.LoginPage;
import chatty.pages.MyDraftsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMyDraftCreated extends BaseTest {

    @BeforeEach
    public void loginUserwithValidData() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail("abcd@gmail.com")
                .inputPassword("abc12345")
                .clickLoginButton();
    }

    @Test
    public void myDraftPostIsCreatedTest() {
        BlogPage blogPage = new BlogPage(driver);
        blogPage.clickCreatePostPlusButton()
                .inputTitle("Barbara8")
                .inputDescription("Sunny today")
                .inputContent("Abrakadabra with Barbara")
                .clickSaveAsDraftToggle()
                .clickSubmitButton();
        blogPage.clickMyDrafts();
        MyDraftsPage myDraftsPage = new MyDraftsPage(driver);
        assertTrue(myDraftsPage.isDraftPostCreated("Barbara8"));
        myDraftsPage.clickDraftPostCreated("Barbara8");

    }
}
