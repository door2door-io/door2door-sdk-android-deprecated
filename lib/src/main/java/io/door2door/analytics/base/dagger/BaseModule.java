package io.door2door.analytics.base.dagger;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.door2door.analytics.api.model.InitializationParameters;
import io.door2door.analytics.base.DataPersister;
import io.door2door.analytics.base.DateFormattingHelper;
import io.door2door.analytics.base.DeviceIdRetriever;
import io.door2door.analytics.base.StringTypeAdapter;

/**
 * Dagger module for providing the base dependencies.
 */
@Module
public class BaseModule {

    private final InitializationParameters initializationParameters;
    private final Context context;

    /**
     * Constructor.
     *
     * @param context                  the context
     * @param initializationParameters the initialization parameters.
     */
    public BaseModule(Context context, InitializationParameters initializationParameters) {
        this.context = context;
        this.initializationParameters = initializationParameters;
    }

    /**
     * Dagger 2 provider method.
     *
     * @return the provided {@link Context}
     */
    @Provides
    @Singleton
    Context provideContext() {
        return context;
    }

    /**
     * Dagger 2 provider method.
     *
     * @return the provided {@link InitializationParameters}
     */
    @Provides
    @Singleton
    InitializationParameters provideInitializationParameters() {
        return initializationParameters;
    }

    /**
     * Dagger 2 provider method.
     *
     * @return the provided {@link DateFormattingHelper}
     */
    @Provides
    @Singleton
    DateFormattingHelper provideDateFormattingHelper() {
        return new DateFormattingHelper();
    }

    /**
     * Dagger 2 provider method.
     *
     * @param gson              the gson
     * @param sharedPreferences the shared preferences
     * @return the provided {@link DataPersister}
     */
    @Provides
    @Singleton
    DataPersister provideDataPersister(Gson gson, SharedPreferences sharedPreferences) {
        return new DataPersister(gson, sharedPreferences);
    }

    /**
     * Dagger 2 provider method.
     *
     * @param dataPersister the data persister
     * @return the provided {@link DeviceIdRetriever}
     */
    @Provides
    @Singleton
    DeviceIdRetriever provideDeviceIdRetriever(DataPersister dataPersister) {
        return new DeviceIdRetriever(dataPersister);
    }

    /**
     * Dagger 2 provider method.
     *
     * @param context the context
     * @return the provided {@link SharedPreferences}
     */
    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    /**
     * Dagger 2 provider method.
     *
     * @param dateFormattingHelper the date formatting helper
     * @return the provided {@link SharedPreferences}
     */
    @Singleton
    @Provides
    Gson providesGson(DateFormattingHelper dateFormattingHelper) {
        return new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setDateFormat(dateFormattingHelper.getDefaultDateFormat())
            .registerTypeAdapter(String.class, new StringTypeAdapter())
            .serializeNulls()
            .create();
    }
}
