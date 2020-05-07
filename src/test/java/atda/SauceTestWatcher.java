package atda;

import org.junit.runner.Description;

public class SauceTestWatcher extends TestWatcher {

    protected void succeeded(Description description) {
        sauceSession.stop("passed");
    }

    protected void failed(Description description) {
        sauceSession.stop("failed");
    }
}
