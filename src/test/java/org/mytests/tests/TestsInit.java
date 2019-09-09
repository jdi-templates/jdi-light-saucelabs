package org.mytests.tests;

import com.epam.jdi.light.driver.WebDriverFactory;
import org.mytests.uiobjects.example.site.SiteJdi;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import java.util.HashMap;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.driver.get.DriverData.CAPABILITIES_FOR_CHROME;
import static com.epam.jdi.light.driver.get.RemoteDriver.DRIVER_REMOTE_URL;
import static com.epam.jdi.light.logger.LogLevels.STEP;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.light.ui.html.PageFactory.initElements;
import static org.mytests.uiobjects.example.site.SiteJdi.homePage;

public class TestsInit {

    private static HashMap<String, String> initSauceCapabilities() {
        String username = System.getenv("SAUCE_USERNAME");
        String accessKey = System.getenv("SAUCE_ACCESS_KEY");

        return new HashMap<String, String>() {{
            put("username", username);
            put("accessKey", accessKey);
            put("seleniumVersion", "3.141.59");
            put("name", "Jdi test");
            put("maxDuration", "3600");
            put("commandTimeout", "600");
            put("idleTimeout", "1000");
            put("build", "Build of test run for JDI");
        }};
    }

    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        logger.setLogLevel(STEP);
        CAPABILITIES_FOR_CHROME = initSauceCapabilities();
        initElements(SiteJdi.class);
        homePage.open();
        logger.info("Run Tests");
    }

    @AfterMethod
    public void cleanUpAfterTestMethod(ITestResult result) {
        ((JavascriptExecutor) WebDriverFactory.getDriver()).executeScript("sauce:job-result=" + (result.isSuccess() ? "passed" : "failed"));
    }

    @AfterSuite(alwaysRun = true)
    public void teardown() {
        killAllSeleniumDrivers();
    }
}
