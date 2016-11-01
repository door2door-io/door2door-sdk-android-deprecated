package io.door2door.analytics.network.model;

/**
 * The type Trip.
 */
public class Trip {

    private Place origin;
    private Place destination;

    /**
     * Gets destination.
     *
     * @return the destination
     */
    public Place getDestination() {
        return destination;
    }

    /**
     * Sets destination.
     *
     * @param destination the destination
     */
    public void setDestination(Place destination) {
        this.destination = destination;
    }

    /**
     * Gets origin.
     *
     * @return the origin
     */
    public Place getOrigin() {
        return origin;
    }

    /**
     * Sets origin.
     *
     * @param origin the origin
     */
    public void setOrigin(Place origin) {
        this.origin = origin;
    }
}
