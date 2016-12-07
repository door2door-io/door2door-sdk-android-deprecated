package io.door2door.analytics.network;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.door2door.analytics.api.model.InitializationParameters;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.when;


/**
 * Test class for {@link NetworkConfigurator}.
 */
public class NetworkConfiguratorTest {

    private NetworkConfigurator networkConfigurator;

    @Mock
    private InitializationParameters initializationParameters;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        networkConfigurator = new NetworkConfigurator(initializationParameters);
    }

    @Test
    public void shouldGetBaseUrlWithVersion() {
        // given
        when(initializationParameters.getBaseUrl()).thenReturn("https://events.d2di.net");

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

        // then
        assertThat(defaultTimeoutInSeconds).isEqualTo(30);
    }

}