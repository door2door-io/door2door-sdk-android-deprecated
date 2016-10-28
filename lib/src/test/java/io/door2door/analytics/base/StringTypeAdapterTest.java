package io.door2door.analytics.base;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Test class for {@link StringTypeAdapter}.
 */
public class StringTypeAdapterTest {

    private StringTypeAdapter stringTypeAdapter;

    @Before
    public void setUp() {
        stringTypeAdapter = new StringTypeAdapter();
    }

    @Test
    public void shouldWriteUsingTheWriter() throws IOException {
        // given
        JsonWriter jsonWriter = mock(JsonWriter.class);
        String value = "some value";

        // when
        stringTypeAdapter.write(jsonWriter, value);

        // then
        verify(jsonWriter).value(value);
    }

    @Test
    public void shouldHandleNullPeekWhenReading() throws IOException {
        // given
        JsonReader jsonReader = mock(JsonReader.class);
        when(jsonReader.peek()).thenReturn(JsonToken.NULL);

        // when
        String value = stringTypeAdapter.read(jsonReader);

        // then
        assertThat(value).isEqualTo("");
        verify(jsonReader).nextNull();
        verify(jsonReader, never()).nextString();
    }

    @Test
    public void shouldReadNextString() throws IOException {
        // given
        String expectedValue = "some value";
        JsonReader jsonReader = mock(JsonReader.class);
        when(jsonReader.peek()).thenReturn(JsonToken.STRING);
        when(jsonReader.nextString()).thenReturn(expectedValue);

        // when
        String value = stringTypeAdapter.read(jsonReader);

        // then
        assertThat(value).isEqualTo(expectedValue);
        verify(jsonReader, never()).nextNull();
    }

}