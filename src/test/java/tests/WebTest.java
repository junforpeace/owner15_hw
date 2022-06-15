package tests;

import config.WebTestConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static helpers.Browser.CHROME;
import static org.assertj.core.api.Assertions.assertThat;

public class WebTest {

    @Test
    void localWebTest() {
        System.setProperty("device", "localdriver");
        WebTestConfig config = ConfigFactory.create(WebTestConfig.class, System.getProperties());

        assertThat(config.baseUrl()).isEqualTo("https://qase.io/");
        assertThat(config.browserVersion()).isEqualTo("96.0");
        assertThat(config.browser()).isEqualTo(CHROME);

    }
    @Test
    void remoteWebTest() {
        System.setProperty("device", "remotedriver");
        WebTestConfig config = ConfigFactory.create(WebTestConfig.class, System.getProperties());

        assertThat(config.baseUrl()).isEqualTo("https://qase.io/");
        assertThat(config.remote()).isEqualTo("https://user1:1234@selenoid.autotests.cloud/wd/hub/");
        assertThat(config.browserVersion()).isEqualTo("99.0");

    }
}
