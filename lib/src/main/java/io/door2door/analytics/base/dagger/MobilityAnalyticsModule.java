package io.door2door.analytics.base.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.door2door.analytics.logger.Logger;
import io.door2door.analytics.network.HttpStack;
import io.door2door.analytics.network.RetrofitService;
import io.door2door.analytics.interactor.MobilityAnalyticsInteractor;
import io.door2door.analytics.api.model.InitializationParameters;
import io.door2door.analytics.mapper.ModelMapper;
import retrofit2.Retrofit;

/**
 * Dagger module.
 */
@Module
// TODO 2016-10-17 zlatko: separate the module into multiple modules
public class MobilityAnalyticsModule {

    private InitializationParameters initializationParameters;

    /**
     * Setter for the initialization parameters.
     * @param initializationParameters the initialization parameters.
     */
    public void setInitializationParameters(InitializationParameters initializationParameters) {
        this.initializationParameters = initializationParameters;
    }

    /**
     * Dagger 2 provider method.
     *
     * @return the provided {@link MobilityAnalyticsInteractor}
     * @param httpStack the HTTP stack to be used by the interactor.
     */
    @Provides
    @Singleton
    public MobilityAnalyticsInteractor provideMobilityAnalyticsInteractor(HttpStack httpStack) {
        return new MobilityAnalyticsInteractor(httpStack);
    }

    /**
     * Dagger 2 provider method.
     *
     * @return the provided {@link HttpStack}
     * @param retrofitService the retrofit service to be used by the HTTP stack.
     * @param modelMapper the model mapper to be used by the HTTP stack.
     */
    @Provides
    @Singleton
    public HttpStack provideHttpStack(RetrofitService retrofitService, ModelMapper modelMapper) {
        return new HttpStack(retrofitService, modelMapper);
    }

    /**
     * Dagger 2 provider method.
     *
     * @return the provided {@link RetrofitService}
     */
    @Provides
    @Singleton
    public RetrofitService provideRetrofitService() {
        Retrofit retrofit = new Retrofit.Builder().build();
        return retrofit.create(RetrofitService.class);
    }

    /**
     * Dagger 2 provider method.
     *
     * @return the provided {@link ModelMapper}
     */
    @Provides
    @Singleton
    public ModelMapper provideModelMapper() {
        return new ModelMapper();
    }

    /**
     * Dagger 2 provider method.
     *
     * @return the provided {@link MobilityAnalyticsInteractor}
     */
    @Provides
    @Singleton
    public Logger provideLogger() {
        return new Logger(initializationParameters.isLoggerEnabled());
    }
}
