package io.door2door.analytics.network.dagger;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.door2door.analytics.api.model.InitializationParameters;
import io.door2door.analytics.mapper.ModelMapper;
import io.door2door.analytics.network.HttpStack;
import io.door2door.analytics.network.NetworkConfigurator;
import io.door2door.analytics.network.RetrofitService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;
import static okhttp3.logging.HttpLoggingInterceptor.Level.NONE;

/**
 * Dagger module for providing the network dependencies.
 */
@Module
public class NetworkModule {

    /**
     * Dagger 2 provider method.
     *
     * @param retrofitService the retrofit service to be used by the HTTP stack.
     * @param modelMapper     the model mapper to be used by the HTTP stack.
     * @return the provided {@link HttpStack}
     */
    @Provides
    @Singleton
    HttpStack provideHttpStack(RetrofitService retrofitService, ModelMapper modelMapper) {
        return new HttpStack(retrofitService, modelMapper);
    }

    /**
     * Dagger 2 provider method.
     *
     * @param okHttpClient         the client to be used.
     * @param rxAdapterFactory     the factory for RX adapter.
     * @param gsonConverterFactory the gson converter factory.
     * @return the provided {@link RetrofitService}
     */
    @Provides
    @Singleton
    RetrofitService provideRetrofitService(OkHttpClient okHttpClient,
                                           RxJavaCallAdapterFactory rxAdapterFactory,
                                           GsonConverterFactory gsonConverterFactory,
                                           NetworkConfigurator networkConfigurator) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(networkConfigurator.getBaseUrlWithVersion())
                .client(okHttpClient)
                .addCallAdapterFactory(rxAdapterFactory)
                .addConverterFactory(gsonConverterFactory)
                .build();
        return retrofit.create(RetrofitService.class);
    }

    /**
     * Dagger 2 provider method.
     *
     * @param initializationParameters the initialization parameters.
     * @param networkConfigurator      the network configurator
     * @return the provided {@link OkHttpClient}
     */
    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(InitializationParameters initializationParameters,
                                     NetworkConfigurator networkConfigurator) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(initializationParameters.isLoggerEnabled() ? BODY : NONE);
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(networkConfigurator.getDefaultTimeoutInSeconds(), TimeUnit.SECONDS)
                .readTimeout(networkConfigurator.getDefaultTimeoutInSeconds(), TimeUnit.SECONDS)
                .writeTimeout(networkConfigurator.getDefaultTimeoutInSeconds(), TimeUnit.SECONDS)
                .addInterceptor(interceptor);
        return builder.build();
    }

    /**
     * Dagger 2 provider method.
     *
     * @return the provided {@link RxJavaCallAdapterFactory}
     */
    @Provides
    @Singleton
    RxJavaCallAdapterFactory provideRxJavaCallAdapterFactory() {
        return RxJavaCallAdapterFactory.create();
    }

    /**
     * Dagger 2 provider method.
     *
     * @param gson the gson.
     * @return the provided {@link GsonConverterFactory}
     */
    @Provides
    @Singleton
    GsonConverterFactory provideGsonConverterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    /**
     * Dagger 2 provider method.
     *
     * @param initializationParameters the initialization parameters
     * @return the provided {@link NetworkConfigurator}
     */
    @Provides
    @Singleton
    NetworkConfigurator provideNetworkConfigurator(
            InitializationParameters initializationParameters) {
        return new NetworkConfigurator(initializationParameters);
    }
}
