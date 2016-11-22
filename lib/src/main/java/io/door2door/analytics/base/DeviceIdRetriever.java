package io.door2door.analytics.base;

import java.util.UUID;

import io.door2door.analytics.base.logger.Logger;

/**
 * Class responsible for retrieving device id.
 */
public class DeviceIdRetriever {

    private static final String DEVICE_ID_PREF_KEY = "DEVICE_ID_PREF_KEY";
    private static final String TAG = DeviceIdRetriever.class.getSimpleName();

    private final DataPersister dataPersister;
    private final Logger logger;


    /**
     * Instantiates a new Device id retriever.
     *
     * @param dataPersister the data persister
     * @param logger        the logger
     */
    public DeviceIdRetriever(DataPersister dataPersister, Logger logger) {
        this.dataPersister = dataPersister;
        this.logger = logger;
    }

    /**
     * Gets device id.
     *
     * @return the device id
     */
    public String getDeviceId() {
        if (dataPersister.contains(DEVICE_ID_PREF_KEY)) {
            String deviceId = dataPersister.getData(DEVICE_ID_PREF_KEY, String.class);
            logger.d(TAG, String.format("device id [%s] retrieved from persister", deviceId));
            return deviceId;
        }
        String deviceId = UUID.randomUUID().toString();
        dataPersister.saveData(DEVICE_ID_PREF_KEY, deviceId);
        logger.d(TAG, String.format("device id not existent, new id with value [%s] created",
                deviceId));
        return deviceId;
    }

}
