package io.door2door.analytics.base.model;

import com.google.gson.annotations.SerializedName;

/**
 * The enum Mode of transportation.
 */
public enum ModeOfTransportation {

    /**
     * Walk mode of transportation.
     */
    @SerializedName("walk")
    WALK,
    /**
     * Public transport mode of transportation.
     */
    @SerializedName("public_transport")
    PUBLIC_TRANSPORT,
    /**
     * Car sharing mode of transportation.
     */
    @SerializedName("car_sharing")
    CAR_SHARING,
    /**
     * Bike sharing mode of transportation.
     */
    @SerializedName("bike_sharing")
    BIKE_SHARING,
    /**
     * Taxi mode of transportation.
     */
    @SerializedName("taxi")
    TAXI,
    /**
     * Private bike mode of transportation.
     */
    @SerializedName("private_bike")
    PRIVATE_BIKE,
    /**
     * Ride sharing mode of transportation.
     */
    @SerializedName("ride_sharing")
    RIDE_SHARING,
    /**
     * Other mode of transportation.
     */
    @SerializedName("other")
    OTHER;
}
