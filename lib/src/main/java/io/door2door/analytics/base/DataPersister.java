package io.door2door.analytics.base;

import android.content.SharedPreferences;

import com.google.gson.Gson;

/**
 * Class responsible for persisting data.
 */
public class DataPersister {

    private final Gson gson;
    private final SharedPreferences sharedPreferences;

    /**
     * Instantiates a new Data persister.
     *
     * @param gson              the gson
     * @param sharedPreferences the shared preferences
     */
    public DataPersister(Gson gson, SharedPreferences sharedPreferences) {
        this.gson = gson;
        this.sharedPreferences = sharedPreferences;
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
        return gson.fromJson(rawData, clazz);
    }

    /**
     * Contains boolean.
     *
     * @param key the key
     * @return the boolean
     */
    public boolean contains(String key) {
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
    }


}
