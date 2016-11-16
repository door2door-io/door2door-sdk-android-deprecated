package io.door2door.analytics.network;

import org.junit.Before;
import org.junit.Test;

import io.door2door.analytics.DummyModelsCreatorUtil;
import io.door2door.analytics.api.model.InitializationParameters;
import io.door2door.analytics.base.model.Environment;

import static org.assertj.core.api.Java6Assertions.assertThat;


/**
 * Test class for {@link NetworkConfigurator}.
 */
public class NetworkConfiguratorTest {

    private NetworkConfigurator networkConfigurator;

    @Before
    public void setUp() {
        InitializationParameters initializationParameters =
                DummyModelsCreatorUtil.getDummyInitializationParametersBuilder()
                        .setEnvironment(Environment.PRODUCTION)
                        .build();
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

    @Test
    public void shouldReturnDefaultTimeoutInSeconds() {
        // given

        // when
        int defaultTimeoutInSeconds = networkConfigurator.getDefaultTimeoutInSeconds();

        assertThat(defaultTimeoutInSeconds).isEqualTo(30);
        // then
    }

}