package io.door2door.analytics.base;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Test class for {@link DeviceIdRetriever}.
 */
public class DeviceIdRetrieverTest {

    private DeviceIdRetriever deviceIdRetriever;

    @Mock
    private DataPersister dataPersister;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        deviceIdRetriever = new DeviceIdRetriever(dataPersister);
    }

    @Test
    public void shouldGetNewDeviceIfThereIsNoOldOne() {
        // given
        when(dataPersister.contains("DEVICE_ID_PREF_KEY")).thenReturn(false);

        // when
        String deviceId = deviceIdRetriever.getDeviceId();

        // then
        assertThat(deviceId).isNotNull();
        verify(dataPersister).saveData("DEVICE_ID_PREF_KEY", deviceId);
    }

    @Test
    public void shouldGetTheOldDeviceIfThereIsNoOldOne() {
        // given
        String oldDeviceId = "f33f79f4-9d06-11e6-80f5-76304dec7eb7";
        when(dataPersister.contains("DEVICE_ID_PREF_KEY")).thenReturn(true);
        when(dataPersister.getData("DEVICE_ID_PREF_KEY", String.class)).thenReturn(oldDeviceId);

        // when
        String deviceId = deviceIdRetriever.getDeviceId();

        // then
        assertThat(deviceId).isEqualTo(oldDeviceId);
        verify(dataPersister, never()).saveData("DEVICE_ID_PREF_KEY", deviceId);
    }
}