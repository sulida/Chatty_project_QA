package userCreatingAuthorisation;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        TestCreateAccount.class,
        TestLoginUser.class,
        TestLogOut.class
})

public class UserCreatingAuthorisationTestSuite {
}
