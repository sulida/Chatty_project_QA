package updateDeleteUser;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        TestUpdateProfile.class,
        TestDeleteProfile.class
})

public class UpdateDeleteUserTestSuite {

}
