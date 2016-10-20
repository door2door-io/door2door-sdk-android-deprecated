package io.door2door.analytics.network.dagger;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.door2door.analytics.api.model.InitializationParameters;
import io.door2door.analytics.base.DateFormattingHelper;
import io.door2door.analytics.mapper.ModelMapper;
import io.door2door.analytics.network.HttpStack;
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

    private static final String BASE_URL =
            "https://r4on31jbrh.execute-api.eu-central-1.amazonaws.com/dev/";

    private static final int TIMEOUT_SECONDS = 30;

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
                                                  RxJavaCallAdapterFactory
                                                          rxAdapterFactory,
                                                  GsonConverterFactory gsonConverterFactory) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
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
     * @return the provided {@link OkHttpClient}
     */
    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(InitializationParameters initializationParameters) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(initializationParameters.isLoggerEnabled() ? BODY : NONE);
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
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
     * @param dateFormattingHelper the date formatting helper.
     * @return the provided {@link GsonConverterFactory}
     */
    @Provides
    @Singleton
    GsonConverterFactory provideGsonConverterFactory(DateFormattingHelper
                                                                        dateFormattingHelper) {
        GsonProvider gsonProvider = new GsonProvider(dateFormattingHelper.getDefaultDateFormat());
        return GsonConverterFactory.create(gsonProvider.get());
    }
}
