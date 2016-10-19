package io.door2door.analytics.network.dagger;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Provider;

/**
 * Gson provider.
 */
class GsonProvider implements Provider<Gson> {

    private final String dateFormatPattern;

    /**
     * Constructor.
     * @param dateFormatPattern the date format pattern.
     */
    GsonProvider(String dateFormatPattern) {
        this.dateFormatPattern = dateFormatPattern;
    }

    @Override
    public Gson get() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        gsonBuilder.registerTypeAdapter(String.class, new StringTypeAdapter());
        gsonBuilder.setDateFormat(dateFormatPattern);
        return gsonBuilder.create();
    }

}
