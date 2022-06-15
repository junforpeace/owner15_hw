package config;

import org.aeonbits.owner.Config;

import java.net.URL;


@Config.Sources({
        "classpath:config/remoteWebConfig.properties",
        "classpath:${device}.properties"})
public interface WebTestConfig extends Config {

    @Key("browser.name")
    String browser();

    @Key("browser.version")
    String browserVersion();

    @Key("baseURL")
    String baseUrl();

    @Key("remote")
    URL remote();


}
