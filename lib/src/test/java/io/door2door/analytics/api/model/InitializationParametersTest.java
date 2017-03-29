package io.door2door.analytics.api.model;

import io.door2door.analytics.api.exception.ValidationException;
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
        assertThat(initializationParameters.getAuthorizationKey()).isEqualTo(
            "de99a0adeefac13bbd23949b0ade7eea1cfcbc3a57e6d589bcbcc5be51da0a8f");
    }

    @Test(expected = ValidationException.class)
    public void shouldThrowAValidationExceptionWhenBuildingWithNullAuthorizationKey() {
        // given
        builder = new InitializationParameters.InitializationParametersBuilder();

        // when
        builder.build();

        // then (exception expected)
    }

    @Test
    public void shouldBuildInitializationParametersWithDefaultValues() {
        // given
        builder = getBuilderWithAuthorizationKey();

        // when
        InitializationParameters initializationParameters = builder.build();

        // then
        assertThat(initializationParameters.getApplicationName()).isNull();
        assertThat(initializationParameters.getEnvironment()).isEqualTo(Environment.PRODUCTION);
        assertThat(initializationParameters.getVersionName()).isNull();
        assertThat(initializationParameters.isLoggerEnabled()).isEqualTo(false);
        assertThat(initializationParameters.getAuthorizationKey()).isEqualTo(
            "de99a0adeefac13bbd23949b0ade7eea1cfcbc3a57e6d589bcbcc5be51da0a8f");
    }

    @Test
    public void shouldGetProductionBaseUrl() {
        // given
        builder = getBuilderWithAuthorizationKey()
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
        builder = getBuilderWithAuthorizationKey()
                .setEnvironment(Environment.TEST);
        InitializationParameters initializationParameters = builder.build();

        // when
        String baseUrl = initializationParameters.getBaseUrl();

        // then
        assertThat(baseUrl).isEqualTo("https://events-dev.d2di.net");
    }

    private InitializationParameters.InitializationParametersBuilder getBuilderWithAuthorizationKey() {
        return new InitializationParameters.InitializationParametersBuilder()
            .setAuthorizationKey("de99a0adeefac13bbd23949b0ade7eea1cfcbc3a57e6d589bcbcc5be51da0a8f");
    }

}