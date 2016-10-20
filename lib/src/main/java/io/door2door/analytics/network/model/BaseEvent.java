package io.door2door.analytics.network.model;


import java.util.Date;

/**
 * Base class for all events that can be sent by the SDK.
 */
public class BaseEvent {

    private String type;
    private Date timestamp;

    /**
     * @return the type.
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the timestamp.
     */
    public Date getTimestamp() {
        return new Date(timestamp.getTime());
    }

    /**
     * @param timestamp the timestamp to set.
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = new Date(timestamp.getTime());
    }
}
