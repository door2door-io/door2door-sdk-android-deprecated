package io.door2door.analytics.api.model;

import org.junit.Test;

import io.door2door.analytics.DummyModelsCreatorUtil;
import io.door2door.analytics.base.model.Environment;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Test class for {@code InitializationParameters}.
 */
public class InitializationParametersTest {

    private InitializationParameters.InitializationParametersBuilder builder;

    @Test
    public void shouldBuildInitializationParameters() {
        // given
        builder = DummyModelsCreatorUtil.getDummyInitializationParametersBuilder();

        // when
        InitializationParameters initializationParameters = builder.build();

        // then
        assertThat(initializationParameters.getApplicationName()).isEqualTo("Cool Application");
        assertThat(initializationParameters.getEnvironment()).isEqualTo(Environment.TEST);
        assertThat(initializationParameters.getVersionName()).isEqualTo("1.0.1");
        assertThat(initializationParameters.isLoggerEnabled()).isEqualTo(true);
    }

    @Test
    public void shouldBuildInitializationParametersWithDefaultValues() {
        // given
        builder = new InitializationParameters.InitializationParametersBuilder();

        // when
        InitializationParameters initializationParameters = builder.build();

        // then
        assertThat(initializationParameters.getApplicationName()).isNull();
        assertThat(initializationParameters.getEnvironment()).isEqualTo(Environment.PRODUCTION);
        assertThat(initializationParameters.getVersionName()).isNull();
        assertThat(initializationParameters.isLoggerEnabled()).isEqualTo(false);
    }

    @Test
    public void shouldGetProductionBaseUrl() {
        // given
        builder = new InitializationParameters.InitializationParametersBuilder()
                .setEnvironment(Environment.PRODUCTION);
        InitializationParameters initializationParameters = builder.build();

        // when
        String baseUrl = initializationParameters.getBaseUrl();

        // then
        assertThat(baseUrl).isEqualTo("https://events.d2di.net");
    }

    @Test
    public void shouldGetTestBaseUrl() {
        // given
        builder = new InitializationParameters.InitializationParametersBuilder()
                .setEnvironment(Environment.TEST);
        InitializationParameters initializationParameters = builder.build();

        // when
        String baseUrl = initializationParameters.getBaseUrl();

        // then
        assertThat(baseUrl).isEqualTo("https://events-dev.d2di.net");
    }

}