package user_management;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import user_management.security.AuthenticatorTest;
import user_management.security.PasswordTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AuthenticatorTest.class, PasswordTest.class, UserTest.class, UserCollectionTest.class, UserCollectionInitializerTest.class
})

public class UserManagementTestSuite {
}
