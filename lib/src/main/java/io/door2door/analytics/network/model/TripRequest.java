package io.door2door.analytics.network.model;

import java.util.Date;

/**
 * Model class for the trip request body when sending an event to the backend.
 */
public class TripRequest {

    private TripStage stage;
    private Date timestamp;
    private Person actor;
    private Trip trip;

    /**
     * Gets actor.
     *
     * @return the actor
     */
    public Person getActor() {
        return actor;
    }

    /**
     * Sets actor.
     *
     * @param actor the actor
     */
    public void setActor(Person actor) {
        this.actor = actor;
    }

    /**
     * Gets stage.
     *
     * @return the stage
     */
    public TripStage getStage() {
        return stage;
    }

    /**
     * Sets stage.
     *
     * @param stage the stage
     */
    public void setStage(TripStage stage) {
        this.stage = stage;
    }

    /**
     * Gets timestamp.
     *
     * @return the timestamp
     */
    public Date getTimestamp() {
        return new Date(timestamp.getTime());
    }

    /**
     * Sets timestamp.
     *
     * @param timestamp the timestamp
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = new Date(timestamp.getTime());
    }

    /**
     * Gets trip.
     *
     * @return the trip
     */
    public Trip getTrip() {
        return trip;
    }

    /**
     * Sets trip.
     *
     * @param trip the trip
     */
    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}
