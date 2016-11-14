package io.door2door.analytics.network.model;

import java.util.List;

import io.door2door.analytics.base.model.ModeOfTransportation;

/**
 * The type Trip.
 */
public class Trip {

    private List<ModeOfTransportation> modeOfTransportation;
    private PlaceAtTime departure;
    private PlaceAtTime arrival;

    /**
     * Gets mode of transportation.
     *
     * @return the mode of transportation
     */
    public List<ModeOfTransportation> getModeOfTransportation() {
        return modeOfTransportation;
    }

    /**
     * Sets mode of transportation.
     *
     * @param modeOfTransportation the mode of transportation
     */
    public void setModeOfTransportation(List<ModeOfTransportation> modeOfTransportation) {
        this.modeOfTransportation = modeOfTransportation;
    }

    /**
     * Gets arrival.
     *
     * @return the arrival
     */
    public PlaceAtTime getArrival() {
        return arrival;
    }

    /**
     * Sets arrival.
     *
     * @param arrival the arrival
     */
    public void setArrival(PlaceAtTime arrival) {
        this.arrival = arrival;
    }

    /**
     * Gets departure.
     *
     * @return the departure
     */
    public PlaceAtTime getDeparture() {
        return departure;
    }

    /**
     * Sets departure.
     *
     * @param departure the departure
     */
    public void setDeparture(PlaceAtTime departure) {
        this.departure = departure;
    }
}
