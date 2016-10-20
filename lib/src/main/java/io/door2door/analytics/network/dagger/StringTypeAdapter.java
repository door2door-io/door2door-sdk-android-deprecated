package io.door2door.analytics.network.dagger;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * String type adapter.
 */
class StringTypeAdapter extends TypeAdapter<String> {

    @Override
    public void write(JsonWriter jsonWriter, String value) throws IOException {
        jsonWriter.value(value);
    }

    @Override
    public String read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return "";
        }
        return jsonReader.nextString();
    }
}
