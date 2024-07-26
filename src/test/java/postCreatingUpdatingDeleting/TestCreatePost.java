package postCreatingUpdatingDeleting;

import basetest.BaseTest;
import chatty.pages.BlogPage;
import chatty.pages.CreatePostPage;
import chatty.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCreatePost extends BaseTest {
    private String email = "abcd@gmail.com";
    private String password = "abc12345";
    private String title = "Absd efg hjklmn opqr stuvwxyz 1234567890";
    private String description = "Absd efg hjklmn opqr stuvwxyz 1234567890 Absd efg hjklmn opqr stuvwxyz 1234567890 Absd efg hjklmn op";
    private String content = "Abrakadabra with Barbara";

    private String filePath = "C:\\Users\\Mi\\IdeaProjects\\Chatty_project_QA\\src\\main\\resources\\photo\\Photo1.jpg";
    private String date = "02";
    private String month = "08";
    private String year = "2024";

    @BeforeEach
    public void loginUserwithValidData() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail(email)
                .inputPassword(password)
                .clickLoginButton();
    }

    @Test
    public void createPostWithValidDataTest() {
        System.out.println("Running createPostWithValidDataTest");
        BlogPage blogPage = new BlogPage(driver);
        blogPage.clickCreatePostPlusButton()
                .inputTitle(title)
                .inputDescription(description)
                .inputContent(content)
                .clickAttachPhotoBox(filePath)
                .fillDateForDelayPost(date, month, year)
                .clickSaveAsDraftToggle()
                .clickSubmitButton();
        blogPage.clickMyPostsToggle();
        assertTrue(blogPage.isPostCreated(title));
    }

    @Test
    public void createPostWithEmptyFields() {
        System.out.println("createPostWithEmptyFields");
        BlogPage blogPage = new BlogPage(driver);
        blogPage.clickCreatePostPlusButton()
                .clickSubmitButton();
        defineTestResultTrue(new CreatePostPage(driver).getTextfromErrorMessage().contains("Please fill the field"));

    }
}
