package io.door2door.analytics.network.model;

/**
 * Network model for a person.
 */
public class Person {

    private String deviceId;
    private String uuid;
    private String name;
    private String platform;
    private String application;
    private String version;

    /**
     * @return the applicaiton.
     */
    public String getApplication() {
        return application;
    }

    /**
     * @param application the applicaiton to set.
     */
    public void setApplication(String application) {
        this.application = application;
    }


    /**
     * @return the device id.
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * @param deviceId the device id to set.
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * @return the name.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the platform.
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * @param platform the platform to set.
     */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /**
     * @return the uuid.
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @param uuid the uuid to set.
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * @return the version.
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version the version to set.
     */
    public void setVersion(String version) {
        this.version = version;
    }
}
