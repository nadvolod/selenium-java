package testingClassData;

// This class provides the data for our tests
// It returns 3 different objects, with 2 String attributes (in our case, the 2 attributes are the username and the password)
public class UserDataProvider {
    public static Object[] provideUserData() {
        return new Object[] {
                new Object[] {"standard_user", "secret_sauce"},
                new Object[] {"performance_glitch_user", "secret_sauce"},
                new Object[] {"problem_user", "secret_sauce"}
        };
    }
}
