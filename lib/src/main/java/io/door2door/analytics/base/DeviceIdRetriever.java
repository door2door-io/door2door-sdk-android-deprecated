package io.door2door.analytics.base;

import java.util.UUID;

/**
 * Class responsible for retrieving device id.
 */
public class DeviceIdRetriever {

    private static final String DEVICE_ID_PREF_KEY = "DEVICE_ID_PREF_KEY";
    private final DataPersister dataPersister;

    /**
     * Instantiates a new Device id retriever.
     *
     * @param dataPersister the data persister
     */
    public DeviceIdRetriever(DataPersister dataPersister) {
        this.dataPersister = dataPersister;
    }

    /**
     * Gets device id.
     *
     * @return the device id
     */
    public String getDeviceId() {
        if (dataPersister.contains(DEVICE_ID_PREF_KEY)) {
            return dataPersister.getData(DEVICE_ID_PREF_KEY, String.class);
        }

        String deviceId = UUID.randomUUID().toString();
        dataPersister.saveData(DEVICE_ID_PREF_KEY, deviceId);
        return deviceId;
    }

}
