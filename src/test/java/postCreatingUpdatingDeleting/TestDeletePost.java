package postCreatingUpdatingDeleting;

import basetest.BaseTest;
import chatty.pages.BlogPage;
import chatty.pages.LoginPage;
import chatty.pages.PostPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDeletePost extends BaseTest {

    private String email = "abcd@gmail.com";
    private String password = "abc12345";
    private String title = "NEW to delete";
    private String description = "Absd efg hjklmn opqr stuvwxyz 1234567890 Absd efg hjklmn opqr stuvwxyz 1234567890 Absd efg hjklmn op";
    private String content = "Abrakadabra with Barbara";

    @BeforeEach
    public void loginUserwithValidData() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                .inputEmail(email)
                .inputPassword(password)
                .clickLoginButton();
    }

    @Test
    public void deletePostTest() {
        BlogPage blogPage = new BlogPage(driver);
        blogPage.clickCreatePostPlusButton()
                .inputTitle(title)
                .inputDescription(description)
                .inputContent(content)
                .clickSubmitButton()
                .clickMyPostsToggle()
                .clickPostCreated(title);
        new PostPage(driver).clickDeleteButton()
                .clickMyPostsToggle();
        defineTestResultFalse(blogPage.isPostCreated(title));

    }
}
