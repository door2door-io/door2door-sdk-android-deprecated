package io.door2door.analytics.data.model;

import org.joda.time.DateTime;

/**
 * Base class for all events that can be sent by the SDK.
 */
public class BaseEvent {

    private String type;
    private DateTime timestamp;

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
    public DateTime getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set.
     */
    public void setTimestamp(DateTime timestamp) {
        this.timestamp = timestamp;
    }
}
