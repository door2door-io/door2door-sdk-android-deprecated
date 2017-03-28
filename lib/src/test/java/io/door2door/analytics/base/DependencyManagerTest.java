package io.door2door.analytics.base;

import android.app.Application;

import io.door2door.analytics.DummyModelsCreatorUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import io.door2door.analytics.api.model.InitializationParameters;
import io.door2door.analytics.interactor.MobilityAnalyticsInteractor;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Test class for the dependency manager.
 */
@RunWith(RobolectricTestRunner.class)
@Config(sdk = 23, manifest = Config.NONE)
public class DependencyManagerTest {

    private DependencyManager dependencyManager;

    @Before
    public void setUp() {
        Application application = RuntimeEnvironment.application;
        InitializationParameters initParams = DummyModelsCreatorUtil.getDummyInitializationParametersBuilder()
            .build();

        dependencyManager = new DependencyManager(application, initParams);
    }

    @Test
    public void shouldGetMobilityAnalyticsInteractorDependency() {
        // given

        // when
        MobilityAnalyticsInteractor interactor = dependencyManager.getMobilityAnalyticsInteractor();

        // then
        assertThat(interactor).isNotNull();
    }

    @Test
    public void shouldGetLoggerDependency() {
        // given

        // when
        Logger logger = dependencyManager.getLogger();

        // then
        assertThat(logger).isNotNull();
    }

    @Test
    public void shouldGetSingletonDependencyInstance() {
        // given
        Logger firstInstance = dependencyManager.getLogger();

        // when
        Logger secondInstance = dependencyManager.getLogger();

        // then
        assertThat(secondInstance).isEqualTo(firstInstance);
    }

}