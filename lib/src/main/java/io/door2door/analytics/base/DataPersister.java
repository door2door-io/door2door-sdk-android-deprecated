package io.door2door.analytics.base;

import android.content.SharedPreferences;

import com.google.gson.Gson;

import io.door2door.analytics.base.logger.Logger;


/**
 * Class responsible for persisting data.
 */
public class DataPersister {

    private static final String TAG = DataPersister.class.getSimpleName();

    private final Gson gson;
    private final SharedPreferences sharedPreferences;
    private final Logger logger;

    /**
     * Instantiates a new Data persister.
     *
     * @param gson              the gson
     * @param sharedPreferences the shared preferences
     * @param logger            the logger
     */
    public DataPersister(Gson gson, SharedPreferences sharedPreferences, Logger logger) {
        this.gson = gson;
        this.sharedPreferences = sharedPreferences;
        this.logger = logger;
    }

    /**
     * Save data.
     *
     * @param key  the key
     * @param data the data
     */
    public void saveData(String key, Object data) {
        String rawData = gson.toJson(data);
        sharedPreferences.edit()
                .putString(key, rawData)
                .apply();
        logger.d(TAG, String.format("Value for key [%s] saved", key));
    }

    /**
     * Gets data.
     *
     * @param <T>   the type parameter
     * @param key   the key
     * @param clazz the clazz
     * @return the data
     */
    public <T> T getData(String key, Class<T> clazz) {
        String rawData = sharedPreferences.getString(key, "");
        logger.d(TAG, String.format("Value for key [%s] read", key));
        return gson.fromJson(rawData, clazz);
    }

    /**
     * Contains boolean.
     *
     * @param key the key
     * @return the boolean
     */
    public boolean contains(String key) {
        logger.d(TAG, String.format("Value for key [%s] about to be checked for existence", key));
        return sharedPreferences.contains(key);
    }

    /**
     * Delete data.
     *
     * @param key the key
     */
    public void deleteData(String key) {
        sharedPreferences.edit()
                .remove(key)
                .apply();
        logger.d(TAG, String.format("Value for key [%s] deleted", key));
    }


}
