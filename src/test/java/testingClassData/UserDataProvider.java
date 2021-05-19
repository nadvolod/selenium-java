package testingClassData;

public class UserDataProvider {
    public static Object[] provideBasicData() {
        return new Object[] {
                new Object[] {"standard_user", "secret_sauce"},
                new Object[] {"performance_glitch_user", "secret_sauce"},
                new Object[] {"problem_user", "secret_sauce"}
        };
    }
}
