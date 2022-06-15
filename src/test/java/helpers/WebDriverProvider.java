package helpers;

import config.WebTestConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Objects;
import java.util.function.Supplier;

import static helpers.Browser.CHROME;
import static helpers.Browser.FIREFOX;

public class WebDriverProvider implements Supplier<WebDriver> {

    private final WebTestConfig config = ConfigFactory.create(WebTestConfig.class, System.getProperties());

    public WebDriverProvider() {
    }

    @Override
    public WebDriver get() {
        WebDriver driver = createWebDriver();
        driver.get(config.baseUrl());
        return driver;
    }

    private WebDriver createWebDriver() {
        if (Objects.isNull(config.remote())) {
            if (config.browser().equals(FIREFOX.toString())) {
                return new FirefoxDriver();
            } else if (config.browser().equals(CHROME.toString())) {
                return new ChromeDriver();
            }
        } else {
            if (config.browser().equals(FIREFOX.toString())) {
                return new RemoteWebDriver(config.remote(), new ChromeOptions());
            } else if (config.browser().equals(CHROME.toString())) {
                return new RemoteWebDriver(config.remote(), new FirefoxOptions());
            }
        }
        throw new NullPointerException("No such browser");
    }


}
