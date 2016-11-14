package io.door2door.analytics.network.model;

import java.util.Date;

/**
 * Model class for the trip request body when sending an event to the backend.
 */
public class TripRequest {

    private Action action;
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
     * Gets action.
     *
     * @return the action
     */
    public Action getAction() {
        return action;
    }

    /**
     * Sets action.
     *
     * @param action the action
     */
    public void setAction(Action action) {
        this.action = action;
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
