package com.acceptance;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runners.Parameterized;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    private static String build;
    public WebDriver driver;

    @Rule
    public SauceTestWatcher resultReportingTestWatcher = new SauceTestWatcher();

    @Rule
    public TestName testName = new TestName() {
        public String getMethodName() {
            return String.format("%s", super.getMethodName());
        }
    };

    @BeforeClass
    public static void beforeClass() {
        build = setBuildName();
    }

    @Parameterized.Parameters(name = "{0},{1}")
    public static Collection<Object[]> crossBrowserData() {
        return Arrays.asList(new Object[][] {
                { "Chrome", "macOS 10.14", "latest" },
                { "Chrome", "macOS 10.15", "latest" },
                { "Chrome", "macOS 10.14", "latest-1" },
                { "Chrome", "macOS 10.15", "latest-1" },
                { "Safari", "macOS 10.14", "latest" },
                { "Safari", "macOS 10.15", "latest" },
                { "Chrome", "macOS 10.14", "latest" },
                { "Chrome", "macOS 10.15", "latest" },
                { "Chrome", "macOS 10.14", "latest-1" },
                { "Chrome", "macOS 10.15", "latest-1" },
                { "Safari", "macOS 10.14", "latest" },
                { "Safari", "macOS 10.15", "latest" },
                { "Chrome", "macOS 10.14", "latest" },
                { "Chrome", "macOS 10.15", "latest" },
                { "Chrome", "macOS 10.14", "latest-1" },
                { "Chrome", "macOS 10.15", "latest-1" },
                { "Safari", "macOS 10.14", "latest" },
                { "Safari", "macOS 10.15", "latest" },
                { "Chrome", "macOS 10.14", "latest" },
                { "Chrome", "macOS 10.15", "latest" },
                { "Chrome", "macOS 10.14", "latest-1" },
                { "Chrome", "macOS 10.15", "latest-1" },
                { "Safari", "macOS 10.14", "latest" },
                { "Safari", "macOS 10.15", "latest" },
                { "Chrome", "macOS 10.14", "latest" },
                { "Chrome", "macOS 10.15", "latest" },
                { "Chrome", "macOS 10.14", "latest-1" },
                { "Chrome", "macOS 10.15", "latest-1" },
                { "Safari", "macOS 10.14", "latest" },
                { "Safari", "macOS 10.15", "latest" },
                { "Chrome", "macOS 10.14", "latest" },
                { "Chrome", "macOS 10.15", "latest" },
                { "Chrome", "macOS 10.14", "latest-1" },
                { "Chrome", "macOS 10.15", "latest-1" },
                { "Safari", "macOS 10.14", "latest" },
                { "Safari", "macOS 10.15", "latest" },
                { "Chrome", "macOS 10.14", "latest" },
                { "Chrome", "macOS 10.15", "latest" },
                { "Chrome", "macOS 10.14", "latest-1" },
                { "Chrome", "macOS 10.15", "latest-1" },
                { "Safari", "macOS 10.14", "latest" },
                { "Safari", "macOS 10.15", "latest" },
                { "Chrome", "macOS 10.14", "latest" },
                { "Chrome", "macOS 10.15", "latest" },
                { "Chrome", "macOS 10.14", "latest-1" },
                { "Chrome", "macOS 10.15", "latest-1" },
                { "Safari", "macOS 10.14", "latest" },
                { "Safari", "macOS 10.15", "latest" },
                { "Safari", "macOS 10.15", "latest" },
                { "Safari", "macOS 10.15", "latest" },
        });
    }

    @Parameterized.Parameter // first data value (0) is default
    public String browser;

    @Parameterized.Parameter(1)
    public String platform;

    @Parameterized.Parameter(2)
    public String browserVersion;

    @Before
    public void setup() throws MalformedURLException {
        createDriver();
        resultReportingTestWatcher.setDriver(driver);
    }
    private void createDriver() throws MalformedURLException {
        String sauceUsername = System.getenv("SAUCE_USERNAME");
        String sauceAccessKey = System.getenv("SAUCE_ACCESS_KEY");

        MutableCapabilities sauceOpts = new MutableCapabilities();
        sauceOpts.setCapability("username", sauceUsername);
        sauceOpts.setCapability("accessKey", sauceAccessKey);
        sauceOpts.setCapability("name", testName.getMethodName());
        sauceOpts.setCapability("build", build);
        sauceOpts.setCapability("commandTimeout", "30");


        MutableCapabilities browserOptions = new MutableCapabilities();
        browserOptions.setCapability(CapabilityType.PLATFORM_NAME, platform);
        browserOptions.setCapability(CapabilityType.BROWSER_VERSION, browserVersion);
        browserOptions.setCapability(CapabilityType.BROWSER_NAME, browser);
        browserOptions.setCapability("sauce:options", sauceOpts);

        String sauceUrl = "https://ondemand.saucelabs.com/wd/hub";
        URL url = new URL(sauceUrl);
        driver = new RemoteWebDriver(url, browserOptions);
    }

    public static final Map<String, String> knownCITools;

    static {
        knownCITools = new HashMap<>();
        knownCITools.put("Jenkins", "BUILD_TAG");
        knownCITools.put("Bamboo", "bamboo_agentId");
        knownCITools.put("Travis", "TRAVIS_JOB_ID");
        knownCITools.put("Circle", "CIRCLE_JOB");
        knownCITools.put("GitLab", "CI");
        knownCITools.put("TeamCity", "TEAMCITY_PROJECT_NAME");
    }

    private static String setBuildName() {
        if (getEnvironmentVariable(knownCITools.get("Jenkins")) != null) {
            return getEnvironmentVariable("BUILD_NAME") + ": " + getEnvironmentVariable("BUILD_NUMBER");
        } else if (getEnvironmentVariable(knownCITools.get("Bamboo")) != null) {
            return getEnvironmentVariable("bamboo_shortJobName") + ": " + getEnvironmentVariable("bamboo_buildNumber");
        } else if (getEnvironmentVariable(knownCITools.get("Travis")) != null) {
            return getEnvironmentVariable("TRAVIS_JOB_NAME") + ": " + getEnvironmentVariable("TRAVIS_JOB_NUMBER");
        } else if (getEnvironmentVariable(knownCITools.get("Circle")) != null) {
            return getEnvironmentVariable("CIRCLE_JOB") + ": " + getEnvironmentVariable("CIRCLE_BUILD_NUM");
        } else if (getEnvironmentVariable(knownCITools.get("GitLab")) != null) {
            return getEnvironmentVariable("CI_JOB_NAME") + ": " + getEnvironmentVariable("CI_JOB_ID");
        } else if (getEnvironmentVariable(knownCITools.get("TeamCity")) != null) {
            return getEnvironmentVariable("TEAMCITY_PROJECT_NAME") + ": " + getEnvironmentVariable("BUILD_NUMBER");
        } else {
            return "Build Time: " + System.currentTimeMillis();
        }
    }

    protected static String getEnvironmentVariable(String key) {
        return System.getenv(key);
    }
}
