package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "file://tmp/secret.properties",
        "classpath:forAPI/api.properties"})
public interface ApiTestConfig extends Config {

    @Key("baseUrl")
    String baseUrl();

    @Key("token")
    String token();
}
