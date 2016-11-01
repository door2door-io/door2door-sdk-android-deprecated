package io.door2door.analytics.base;

import android.content.SharedPreferences;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Test class for {@link DataPersister}.
 */
public class DataPersisterTest {

    private DataPersister dataPersister;
    private Gson gson;
    @Mock
    private SharedPreferences sharedPreferences;
    @Mock
    private SharedPreferences.Editor editor;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ")
                .registerTypeAdapter(String.class, new StringTypeAdapter())
                .serializeNulls()
                .create();
        when(sharedPreferences.edit()).thenReturn(editor);
        when(editor.putString(anyString(), anyString())).thenReturn(editor);
        when(editor.remove(anyString())).thenReturn(editor);
        dataPersister = new DataPersister(gson, sharedPreferences);
    }

    @Test
    public void shouldSaveData() {
        // given
        String key = "someKey";
        Object data = new Object();
        String expectedRawData = "{}";

        // when
        dataPersister.saveData(key, data);

        // then
        verify(editor).putString(key, expectedRawData);
        verify(editor).apply();
    }

    @Test
    public void shouldGetData() {
        // given
        String key = "someKey";
        String rawData = "{}";
        when(sharedPreferences.getString(key, "")).thenReturn(rawData);

        // when
        Object data = dataPersister.getData(key, Object.class);

        // then
        assertThat(data).isNotNull();
    }

    @Test
    public void shouldCheckIfDataIsPersisted() {
        // given
        String key = "someKey";
        when(sharedPreferences.contains(key)).thenReturn(true);

        // when
        boolean contains = dataPersister.contains(key);

        // then
        assertThat(contains).isTrue();
    }

    @Test
    public void shouldDeleteData() {
        // given
        String key = "someKey";

        // when
        dataPersister.deleteData(key);

        // then
        verify(editor).remove(key);
        verify(editor).apply();
    }

}