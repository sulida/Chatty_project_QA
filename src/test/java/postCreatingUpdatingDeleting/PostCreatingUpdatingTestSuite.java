package postCreatingUpdatingDeleting;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        TestCreatePost.class,
        TestMyDraftCreated.class,
        TestUpdatePost.class,
        TestDeletePost.class,

})

public class PostCreatingUpdatingTestSuite {
}

