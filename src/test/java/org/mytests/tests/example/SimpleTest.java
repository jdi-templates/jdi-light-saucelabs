package org.mytests.tests.example;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SimpleTest {

    @Test
    public void simpleTest() throws MalformedURLException {
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", System.getenv("USERNAME"));
        sauceOptions.setCapability("access_key", System.getenv("ACCESS_KEY"));
        sauceOptions.setCapability("name", "simple test");
        sauceOptions.setCapability("browserVersion", "latest");

        SafariOptions safariOptions = new SafariOptions();
        safariOptions.setCapability("sauce:options", sauceOptions);
        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");

        WebDriver driver = new RemoteWebDriver(url, safariOptions);

        driver.get("https://www.saucedemo.com");
        driver.quit();
    }
}
