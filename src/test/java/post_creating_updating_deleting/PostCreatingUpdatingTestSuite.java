package post_creating_updating_deleting;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import user_creating_authorisation.TestCreateAccount;
import user_creating_authorisation.TestLogOut;
import user_creating_authorisation.TestLoginUser;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

    @RunWith(Suite.class)
    @Suite.SuiteClasses({
            TestCreatePost.class,
            TestDeletePost.class,
            TestMyDraftCreated.class,
            TestUpdatePost.class
    })

    public class PostCreatingUpdatingTestSuite {
    }

