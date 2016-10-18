package io.door2door.analytics.data.model;

/**
 * Network model for a trip.
 */
public class Trip {

    private Place origin;
    private Place destination;

    /**
     * @return the destination.
     */
    public Place getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set.
     */
    public void setDestination(Place destination) {
        this.destination = destination;
    }

    /**
     * @return the origin.
     */
    public Place getOrigin() {
        return origin;
    }

    /**
     * @param origin the origin to set.
     */
    public void setOrigin(Place origin) {
        this.origin = origin;
    }
}
