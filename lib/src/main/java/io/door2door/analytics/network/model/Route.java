package io.door2door.analytics.network.model;

/**
 * Network model for a route.
 */
public class Route {

    private Trip trip;
    private String mode;
    private String provider;

    /**
     * @return the mode.
     */
    public String getMode() {
        return mode;
    }

    /**
     * @param mode the mode to set.
     */
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * @return the provider.
     */
    public String getProvider() {
        return provider;
    }

    /**
     * @param provider the provider to set.
     */
    public void setProvider(String provider) {
        this.provider = provider;
    }

    /**
     * @return the trip.
     */
    public Trip getTrip() {
        return trip;
    }

    /**
     * @param trip the trip to set.
     */
    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}
