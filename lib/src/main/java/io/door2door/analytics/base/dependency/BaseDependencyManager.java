package io.door2door.analytics.base.dependency;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.door2door.analytics.api.model.InitializationParameters;
import io.door2door.analytics.base.DataPersister;
import io.door2door.analytics.base.DateFormattingHelper;
import io.door2door.analytics.base.DeviceIdRetriever;
import io.door2door.analytics.base.StringTypeAdapter;
import io.door2door.analytics.base.Logger;
import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * The type Base dependency manager.
 */
public class BaseDependencyManager {

    // external dependencies
    private final InitializationParameters initializationParameters;
    private final Context context;

    // public dependencies
    private Gson gson;
    private Logger logger;
    private Scheduler backgroundScheduler;
    private DateFormattingHelper dateFormattingHelper;
    private DeviceIdRetriever deviceIdRetriever;

    // private dependencies
    private DataPersister dataPersister;
    private SharedPreferences sharedPreferences;

    /**
     * Instantiates a new Base dependency manager.
     *
     * @param initializationParameters the initialization parameters
     * @param context                  the context
     */
    public BaseDependencyManager(InitializationParameters initializationParameters,
                                 Context context) {
        this.initializationParameters = initializationParameters;
        this.context = context;
    }

    /**
     * Gets gson.
     *
     * @return the gson
     */
    public Gson getGson() {
        if (gson == null) {
            gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .setDateFormat(getDateFormattingHelper().getDefaultDateFormat())
                    .registerTypeAdapter(String.class, new StringTypeAdapter())
                    .create();
        }
        return gson;
    }

    /**
     * Gets logger.
     *
     * @return the logger
     */
    public Logger getLogger() {
        if (logger == null) {
            logger = new Logger(initializationParameters.isLoggerEnabled());
        }
        return logger;
    }

    /**
     * Gets device id retriever.
     *
     * @return the device id retriever
     */
    public DeviceIdRetriever getDeviceIdRetriever() {
        if (deviceIdRetriever == null) {
            deviceIdRetriever = new DeviceIdRetriever(getDataPersister(), getLogger());
        }
        return deviceIdRetriever;
    }

    /**
     * Gets background scheduler.
     *
     * @return the background scheduler
     */
    public Scheduler getBackgroundScheduler() {
        if (backgroundScheduler == null) {
            backgroundScheduler = Schedulers.io();
        }
        return backgroundScheduler;
    }

    /**
     * Gets date formatting helper.
     *
     * @return the date formatting helper
     */
    public DateFormattingHelper getDateFormattingHelper() {
        if (dateFormattingHelper == null) {
            dateFormattingHelper = new DateFormattingHelper();
        }
        return dateFormattingHelper;
    }

    private DataPersister getDataPersister() {
        if (dataPersister == null) {
            dataPersister = new DataPersister(getGson(), getSharedPreferences(), getLogger());
        }
        return dataPersister;
    }

    private SharedPreferences getSharedPreferences() {
        if (sharedPreferences == null) {
            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        }
        return sharedPreferences;
    }
}
