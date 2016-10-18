package io.door2door.analytics.data.model;

/**
 * Network model for a place.
 */
public class Place {

    private double latitude;
    private double longitude;
    private String name;

    /**
     * @return the latitude.
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set.
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longitude.
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set.
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
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
}
