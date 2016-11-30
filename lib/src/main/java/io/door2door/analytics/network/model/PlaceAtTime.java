package io.door2door.analytics.network.model;

import java.util.Date;

/**
 * The type Place at time.
 */
public class PlaceAtTime {

    private Date timestamp;
    private Place place;

    /**
     * Gets timestamp.
     *
     * @return the timestamp
     */
    public Date getTimestamp() {
        return timestamp == null ? null : new Date(timestamp.getTime());
    }

    /**
     * Sets timestamp.
     *
     * @param timestamp the timestamp
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp == null ? null : new Date(timestamp.getTime());
    }

    /**
     * Gets place.
     *
     * @return the place
     */
    public Place getPlace() {
        return place;
    }

    /**
     * Sets place.
     *
     * @param place the place
     */
    public void setPlace(Place place) {
        this.place = place;
    }
}
