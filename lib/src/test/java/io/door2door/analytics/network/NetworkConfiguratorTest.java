package io.door2door.analytics.network;

import org.junit.Before;
import org.junit.Test;

import io.door2door.analytics.api.model.InitializationParameters;

import static org.assertj.core.api.Java6Assertions.assertThat;


/**
 * Test class for {@link NetworkConfigurator}.
 */
public class NetworkConfiguratorTest {

    private NetworkConfigurator networkConfigurator;

    @Before
    public void setUp() {
        InitializationParameters initializationParameters = new InitializationParameters();
        networkConfigurator = new NetworkConfigurator(initializationParameters);
    }

    @Test
    public void shouldGetBaseUrlWithVersion() {
        // given

        // when
        String baseUrlWithVersion = networkConfigurator.getBaseUrlWithVersion();

        // then
        assertThat(baseUrlWithVersion).isEqualTo("https://events.d2di.net/v1/");
    }

}