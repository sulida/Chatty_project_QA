package post_creating_updating_deleting;

import basetests.BaseTest;
import chatty.pages.BlogPage;
import chatty.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestUpdatePost extends BaseTest {
    private String email = "abcd@gmail.com";
    private String password = "abc12345";
    private  String title = "Change post";
    private String description = "1";
    private String content = "2";

    private String filePath = "C:\\Users\\Mi\\IdeaProjects\\Chatty_project_QA\\src\\main\\resources\\photo\\Photo2.jpg";
    private  String date = "03";
    private  String month = "09";
    private String year = "2024";

    @BeforeEach
    public void loginUserwithValidData(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail(email)
                .inputPassword(password)
                .clickLoginButton();
    }

    @Test
    public void updatePostTest(){
        BlogPage blogPage = new BlogPage(driver);
        blogPage.clickMyPostsToggle()
                .clickPost()
                .clickEditButton()
                .inputTitle(title)
                .inputDescription(description)
                .inputContent(content)
                .clickAttachPhotoBox(filePath)
                .fillDateForDelayPost(date,month,year)
                .clickSaveAsDraftToggle()
                .clickSubmitButton();
        blogPage.clickMyPostsToggle();
        assertTrue(blogPage.isPostCreated(title));
    }
}
