package io.door2door.analytics.network.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.door2door.analytics.mapper.ModelMapper;
import io.door2door.analytics.network.HttpStack;
import io.door2door.analytics.network.RetrofitService;
import retrofit2.Retrofit;

/**
 * Dagger module for providing the network dependencies.
 */
@Module
public class NetworkModule {

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
}
