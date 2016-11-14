package io.door2door.analytics.api.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.door2door.analytics.base.model.ModeOfTransportation;

/**
 * Model class for the search trip event.
 */
public class SearchTripEvent {

    private final Date departureTimestamp;
    private final Double departureLatitude;
    private final Double departureLongitude;
    private final String departureName;
    private final String departureCity;
    private final String departureStreet;
    private final String departurePostalCode;
    private final String departureCountry;
    private final Date arrivalTimestamp;
    private final Double arrivalLatitude;
    private final Double arrivalLongitude;
    private final String arrivalName;
    private final String arrivalCity;
    private final String arrivalStreet;
    private final String arrivalPostalCode;
    private final String arrivalCountry;
    private final List<ModeOfTransportation> modeOfTransportationList;

    /**
     * Instantiates a new search trip event.
     *
     * @param departureTimestamp   the departure timestamp
     * @param departureLatitude    the departure latitude
     * @param departureLongitude   the departure longitude
     * @param departureName        the departure name
     * @param departureCity        the departure city
     * @param departureStreet      the departure street
     * @param departurePostalCode  the departure postal code
     * @param departureCountry     the departure country
     * @param arrivalTimestamp     the arrival timestamp
     * @param arrivalLatitude      the arrival latitude
     * @param arrivalLongitude     the arrival longitude
     * @param arrivalName          the arrival name
     * @param arrivalCity          the arrival city
     * @param arrivalStreet        the arrival street
     * @param arrivalPostalCode    the arrival postal code
     * @param arrivalCountry       the arrival country
     * @param modeOfTransportationList the mode of transportation
     */
    public SearchTripEvent(Date departureTimestamp, Double departureLatitude,
                           Double departureLongitude, String departureName,
                           String departureCity, String departureStreet, String departurePostalCode,
                           String departureCountry, Date arrivalTimestamp, Double arrivalLatitude,
                           Double arrivalLongitude, String arrivalName,
                           String arrivalCity, String arrivalStreet,
                           String arrivalPostalCode, String arrivalCountry,
                           List<ModeOfTransportation> modeOfTransportationList) {
        this.departureTimestamp = new Date(departureTimestamp.getTime());
        this.departureLatitude = departureLatitude;
        this.departureLongitude = departureLongitude;
        this.departureName = departureName;
        this.departureCity = departureCity;
        this.departureStreet = departureStreet;
        this.departurePostalCode = departurePostalCode;
        this.departureCountry = departureCountry;
        this.arrivalTimestamp = new Date(arrivalTimestamp.getTime());
        this.arrivalCity = arrivalCity;
        this.arrivalLatitude = arrivalLatitude;
        this.arrivalLongitude = arrivalLongitude;
        this.arrivalName = arrivalName;
        this.arrivalStreet = arrivalStreet;
        this.arrivalPostalCode = arrivalPostalCode;
        this.arrivalCountry = arrivalCountry;
        this.modeOfTransportationList = modeOfTransportationList;
    }

    /**
     * Gets departure timestamp.
     *
     * @return the departure timestamp
     */
    public Date getDepartureTimestamp() {
        return new Date(departureTimestamp.getTime());
    }

    /**
     * Gets departure latitude.
     *
     * @return the departure latitude
     */
    public Double getDepartureLatitude() {
        return departureLatitude;
    }

    /**
     * Gets departure longitude.
     *
     * @return the departure longitude
     */
    public Double getDepartureLongitude() {
        return departureLongitude;
    }

    /**
     * Gets departure name.
     *
     * @return the departure name
     */
    public String getDepartureName() {
        return departureName;
    }

    /**
     * Gets departure city.
     *
     * @return the departure city
     */
    public String getDepartureCity() {
        return departureCity;
    }

    /**
     * Gets departure street.
     *
     * @return the departure street
     */
    public String getDepartureStreet() {
        return departureStreet;
    }

    /**
     * Gets departure postal code.
     *
     * @return the departure postal code
     */
    public String getDeparturePostalCode() {
        return departurePostalCode;
    }

    /**
     * Gets departure country.
     *
     * @return the departure country
     */
    public String getDepartureCountry() {
        return departureCountry;
    }

    /**
     * Gets arrival timestamp.
     *
     * @return the arrival timestamp
     */
    public Date getArrivalTimestamp() {
        return new Date(arrivalTimestamp.getTime());
    }

    /**
     * Gets arrival latitude.
     *
     * @return the arrival latitude
     */
    public Double getArrivalLatitude() {
        return arrivalLatitude;
    }

    /**
     * Gets arrival longitude.
     *
     * @return the arrival longitude
     */
    public Double getArrivalLongitude() {
        return arrivalLongitude;
    }

    /**
     * Gets arrival name.
     *
     * @return the arrival name
     */
    public String getArrivalName() {
        return arrivalName;
    }

    /**
     * Gets arrival city.
     *
     * @return the arrival city
     */
    public String getArrivalCity() {
        return arrivalCity;
    }

    /**
     * Gets arrival street.
     *
     * @return the arrival street
     */
    public String getArrivalStreet() {
        return arrivalStreet;
    }

    /**
     * Gets arrival postal code.
     *
     * @return the arrival postal code
     */
    public String getArrivalPostalCode() {
        return arrivalPostalCode;
    }

    /**
     * Gets arrival country.
     *
     * @return the arrival country
     */
    public String getArrivalCountry() {
        return arrivalCountry;
    }

    /**
     * Gets mode of transportation.
     *
     * @return the mode of transportation
     */
    public List<ModeOfTransportation> getModeOfTransportationList() {
        return modeOfTransportationList;
    }

    /**
     * The type search trip event builder.
     */
    public static class SearchTripEventBuilder {

        private Date departureTimestamp;
        private Double departureLatitude;
        private Double departureLongitude;
        private String departureName;
        private String departureCity;
        private String departureStreet;
        private String departurePostalCode;
        private String departureCountry;
        private Date arrivalTimestamp;
        private Double arrivalLatitude;
        private Double arrivalLongitude;
        private String arrivalName;
        private String arrivalCity;
        private String arrivalStreet;
        private String arrivalPostalCode;
        private String arrivalCountry;
        private final List<ModeOfTransportation> modeOfTransportationList = new ArrayList<>();

        /**
         * Sets departure timestamp.
         *
         * @param departureTimestamp the departure timestamp
         * @return the builder
         */
        public SearchTripEventBuilder setDepartureTimestamp(Date departureTimestamp) {
            this.departureTimestamp = new Date(departureTimestamp.getTime());
            return this;
        }

        /**
         * Sets departure latitude.
         *
         * @param departureLatitude the departure latitude
         * @return the builder
         */
        public SearchTripEventBuilder setDepartureLatitude(Double departureLatitude) {
            this.departureLatitude = departureLatitude;
            return this;
        }

        /**
         * Sets departure longitude.
         *
         * @param departureLongitude the departure longitude
         * @return the builder
         */
        public SearchTripEventBuilder setDepartureLongitude(Double departureLongitude) {
            this.departureLongitude = departureLongitude;
            return this;
        }

        /**
         * Sets departure name.
         *
         * @param departureName the departure name
         * @return the builder
         */
        public SearchTripEventBuilder setDepartureName(String departureName) {
            this.departureName = departureName;
            return this;
        }

        /**
         * Sets departure city.
         *
         * @param departureCity the departure city
         * @return the builder
         */
        public SearchTripEventBuilder setDepartureCity(String departureCity) {
            this.departureCity = departureCity;
            return this;
        }

        /**
         * Sets departure street.
         *
         * @param departureStreet the departure street
         * @return the builder
         */
        public SearchTripEventBuilder setDepartureStreet(String departureStreet) {
            this.departureStreet = departureStreet;
            return this;
        }

        /**
         * Sets departure postal code.
         *
         * @param departurePostalCode the departure postal code
         * @return the builder
         */
        public SearchTripEventBuilder setDeparturePostalCode(String departurePostalCode) {
            this.departurePostalCode = departurePostalCode;
            return this;
        }

        /**
         * Sets departure country.
         *
         * @param departureCountry the departure country
         * @return the builder
         */
        public SearchTripEventBuilder setDepartureCountry(String departureCountry) {
            this.departureCountry = departureCountry;
            return this;
        }

        /**
         * Sets arrival timestamp.
         *
         * @param arrivalTimestamp the arrival timestamp
         * @return the builder
         */
        public SearchTripEventBuilder setArrivalTimestamp(Date arrivalTimestamp) {
            this.arrivalTimestamp = new Date(arrivalTimestamp.getTime());
            return this;
        }

        /**
         * Sets arrival latitude.
         *
         * @param arrivalLatitude the arrival latitude
         * @return the builder
         */
        public SearchTripEventBuilder setArrivalLatitude(Double arrivalLatitude) {
            this.arrivalLatitude = arrivalLatitude;
            return this;
        }

        /**
         * Sets arrival longitude.
         *
         * @param arrivalLongitude the arrival longitude
         * @return the builder
         */
        public SearchTripEventBuilder setArrivalLongitude(Double arrivalLongitude) {
            this.arrivalLongitude = arrivalLongitude;
            return this;
        }

        /**
         * Sets arrival name.
         *
         * @param arrivalName the arrival name
         * @return the builder
         */
        public SearchTripEventBuilder setArrivalName(String arrivalName) {
            this.arrivalName = arrivalName;
            return this;
        }

        /**
         * Sets arrival city.
         *
         * @param arrivalCity the arrival city
         * @return the builder
         */
        public SearchTripEventBuilder setArrivalCity(String arrivalCity) {
            this.arrivalCity = arrivalCity;
            return this;
        }

        /**
         * Sets arrival street.
         *
         * @param arrivalStreet the arrival street
         * @return the builder
         */
        public SearchTripEventBuilder setArrivalStreet(String arrivalStreet) {
            this.arrivalStreet = arrivalStreet;
            return this;
        }

        /**
         * Sets arrival postal code.
         *
         * @param arrivalPostalCode the arrival postal code
         * @return the builder
         */
        public SearchTripEventBuilder setArrivalPostalCode(String arrivalPostalCode) {
            this.arrivalPostalCode = arrivalPostalCode;
            return this;
        }

        /**
         * Sets arrival country.
         *
         * @param arrivalCountry the arrival country
         * @return the builder
         */
        public SearchTripEventBuilder setArrivalCountry(String arrivalCountry) {
            this.arrivalCountry = arrivalCountry;
            return this;
        }

        /**
         * Add mode of transportation to the list.
         *
         * @param modeOfTransportation the mode of transportation
         * @return the builder
         */
        public SearchTripEventBuilder addModeOfTransportation(
                ModeOfTransportation modeOfTransportation) {
            this.modeOfTransportationList.add(modeOfTransportation);
            return this;
        }

        /**
         * Build search trip event.
         *
         * @return the search trip event
         */
        public SearchTripEvent build() {
            return new SearchTripEvent(departureTimestamp, departureLatitude, departureLongitude,
                    departureName, departureCity, departureStreet, departurePostalCode,
                    departureCountry, arrivalTimestamp, arrivalLatitude, arrivalLongitude,
                    arrivalName, arrivalCity, arrivalStreet, arrivalPostalCode, arrivalCountry,
                    modeOfTransportationList);
        }
    }

}
