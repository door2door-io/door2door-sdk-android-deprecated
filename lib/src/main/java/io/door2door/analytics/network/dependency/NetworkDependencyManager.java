package io.door2door.analytics.network.dependency;

import com.google.gson.Gson;

import io.door2door.analytics.base.DeviceIdRetriever;
import java.util.concurrent.TimeUnit;

import io.door2door.analytics.api.model.InitializationParameters;
import io.door2door.analytics.network.mapper.NetworkModelMapper;
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
 * The type Network dependency manager.
 */
public class NetworkDependencyManager {

    // external dependencies
    private final Gson gson;
    private final InitializationParameters initializationParameters;
    private final DeviceIdRetriever deviceIdRetriever;

    // public dependencies
    private HttpStack httpStack;

    // private dependencies
    private NetworkModelMapper networkModelMapper;
    private RetrofitService retrofitService;
    private OkHttpClient okHttpClient;
    private RxJavaCallAdapterFactory rxJavaCallAdapterFactory;
    private GsonConverterFactory gsonConverterFactory;
    private NetworkConfigurator networkConfigurator;

    /**
     * Instantiates a new Network dependency manager.
     *
     *  @param initializationParameters the initialization parameters
     * @param gson                     the gson
     * @param deviceIdRetriever        the device id retriever
     */
    public NetworkDependencyManager(InitializationParameters initializationParameters,
        Gson gson, DeviceIdRetriever deviceIdRetriever) {
        this.gson = gson;
        this.initializationParameters = initializationParameters;
        this.deviceIdRetriever = deviceIdRetriever;
    }

    /**
     * Gets http stack.
     *
     * @return the http stack
     */
    public HttpStack getHttpStack() {
        if (httpStack == null) {
            httpStack = new HttpStack(getRetrofitService(), getNetworkModelMapper());
        }
        return httpStack;
    }

    private RetrofitService getRetrofitService() {
        if (retrofitService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(getNetworkConfigurator().getBaseUrlWithVersion())
                    .client(getOkHttpClient())
                    .addCallAdapterFactory(getRxJavaCallAdapterFactory())
                    .addConverterFactory(getGsonConverterFactory())
                    .build();
            retrofitService = retrofit.create(RetrofitService.class);
        }
        return retrofitService;
    }

    private OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(initializationParameters.isLoggerEnabled() ? BODY : NONE);
            OkHttpClient.Builder builder = new OkHttpClient.Builder()
                    .connectTimeout(getNetworkConfigurator().getDefaultTimeoutInSeconds(),
                            TimeUnit.SECONDS)
                    .readTimeout(getNetworkConfigurator().getDefaultTimeoutInSeconds(),
                            TimeUnit.SECONDS)
                    .writeTimeout(getNetworkConfigurator().getDefaultTimeoutInSeconds(),
                            TimeUnit.SECONDS)
                    .addInterceptor(interceptor);
            okHttpClient = builder.build();
        }
        return okHttpClient;
    }

    private RxJavaCallAdapterFactory getRxJavaCallAdapterFactory() {
        if (rxJavaCallAdapterFactory == null) {
            rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();
        }
        return rxJavaCallAdapterFactory;
    }

    private GsonConverterFactory getGsonConverterFactory() {
        if (gsonConverterFactory == null) {
            gsonConverterFactory = GsonConverterFactory.create(gson);
        }
        return gsonConverterFactory;
    }

    private NetworkConfigurator getNetworkConfigurator() {
        if (networkConfigurator == null) {
            networkConfigurator = new NetworkConfigurator(initializationParameters);
        }
        return networkConfigurator;
    }

    private NetworkModelMapper getNetworkModelMapper() {
        if (networkModelMapper == null) {
            networkModelMapper = new NetworkModelMapper(initializationParameters, deviceIdRetriever);
        }
        return networkModelMapper;
    }

}
