package tests;

import config.ApiTestConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ApiTest {

    @Test

    void setApiTest() {

        ApiTestConfig config = ConfigFactory.create(ApiTestConfig.class, System.getProperties());
        assertThat(config.baseUrl()).isEqualTo("https://qase.io/");
        assertThat(config.token()).isEqualTo("wertyuidkfghjsalsdl");
    }
}
