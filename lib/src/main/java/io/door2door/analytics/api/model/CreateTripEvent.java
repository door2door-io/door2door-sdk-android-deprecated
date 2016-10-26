package io.door2door.analytics.api.model;

/**
 * Model class for the creation trip event.
 */
public class CreateTripEvent {

    private final float originLatitude;
    private final float originLongitude;
    private final String originName;
    private final String originCity;
    private final String originStreet;
    private final String originPostalCode;
    private final String originCountry;
    private final float destinationLatitude;
    private final float destinationLongitude;
    private final String destinationName;
    private final String destinationCity;
    private final String destinationStreet;
    private final String destinationPostalCode;
    private final String destinationCountry;

    private CreateTripEvent(CreateTripEventBuilder createTripEventBuilder) {
        this.destinationCity = createTripEventBuilder.destinationCity;
        this.originLatitude = createTripEventBuilder.originLatitude;
        this.originLongitude = createTripEventBuilder.originLongitude;
        this.originName = createTripEventBuilder.originName;
        this.originCity = createTripEventBuilder.originCity;
        this.originStreet = createTripEventBuilder.originStreet;
        this.originPostalCode = createTripEventBuilder.originPostalCode;
        this.originCountry = createTripEventBuilder.originCountry;
        this.destinationLatitude = createTripEventBuilder.destinationLatitude;
        this.destinationLongitude = createTripEventBuilder.destinationLongitude;
        this.destinationName = createTripEventBuilder.destinationName;
        this.destinationStreet = createTripEventBuilder.destinationStreet;
        this.destinationPostalCode = createTripEventBuilder.destinationPostalCode;
        this.destinationCountry = createTripEventBuilder.destinationCountry;
    }

    /**
     * Gets destination city.
     *
     * @return the destination city
     */
    public String getDestinationCity() {
        return destinationCity;
    }

    /**
     * Gets destination country.
     *
     * @return the destination country
     */
    public String getDestinationCountry() {
        return destinationCountry;
    }

    /**
     * Gets destination latitude.
     *
     * @return the destination latitude
     */
    public float getDestinationLatitude() {
        return destinationLatitude;
    }

    /**
     * Gets destination longitude.
     *
     * @return the destination longitude
     */
    public float getDestinationLongitude() {
        return destinationLongitude;
    }

    /**
     * Gets destination name.
     *
     * @return the destination name
     */
    public String getDestinationName() {
        return destinationName;
    }

    /**
     * Gets destination postal code.
     *
     * @return the destination postal code
     */
    public String getDestinationPostalCode() {
        return destinationPostalCode;
    }

    /**
     * Gets destination street.
     *
     * @return the destination street
     */
    public String getDestinationStreet() {
        return destinationStreet;
    }

    /**
     * Gets origin city.
     *
     * @return the origin city
     */
    public String getOriginCity() {
        return originCity;
    }

    /**
     * Gets origin country.
     *
     * @return the origin country
     */
    public String getOriginCountry() {
        return originCountry;
    }

    /**
     * Gets origin latitude.
     *
     * @return the origin latitude
     */
    public float getOriginLatitude() {
        return originLatitude;
    }

    /**
     * Gets origin longitude.
     *
     * @return the origin longitude
     */
    public float getOriginLongitude() {
        return originLongitude;
    }

    /**
     * Gets origin name.
     *
     * @return the origin name
     */
    public String getOriginName() {
        return originName;
    }

    /**
     * Gets origin postal code.
     *
     * @return the origin postal code
     */
    public String getOriginPostalCode() {
        return originPostalCode;
    }

    /**
     * Gets origin street.
     *
     * @return the origin street
     */
    public String getOriginStreet() {
        return originStreet;
    }

    /**
     * The type Create trip event builder.
     */
    public static class CreateTripEventBuilder {
        private float originLatitude;
        private float originLongitude;
        private String originName;
        private String originCity;
        private String originStreet;
        private String originPostalCode;
        private String originCountry;
        private float destinationLatitude;
        private float destinationLongitude;
        private String destinationName;
        private String destinationCity;
        private String destinationStreet;
        private String destinationPostalCode;
        private String destinationCountry;

        /**
         * Sets destination city.
         *
         * @param destinationCity the destination city
         * @return the builder
         */
        public CreateTripEventBuilder setDestinationCity(String destinationCity) {
            this.destinationCity = destinationCity;
            return this;
        }

        /**
         * Sets destination country.
         *
         * @param destinationCountry the destination country
         * @return the builder
         */
        public CreateTripEventBuilder setDestinationCountry(String destinationCountry) {
            this.destinationCountry = destinationCountry;
            return this;
        }

        /**
         * Sets destination latitude.
         *
         * @param destinationLatitude the destination latitude
         * @return the builder
         */
        public CreateTripEventBuilder setDestinationLatitude(float destinationLatitude) {
            this.destinationLatitude = destinationLatitude;
            return this;
        }

        /**
         * Sets destination longitude.
         *
         * @param destinationLongitude the destination longitude
         * @return the builder
         */
        public CreateTripEventBuilder setDestinationLongitude(float destinationLongitude) {
            this.destinationLongitude = destinationLongitude;
            return this;
        }

        /**
         * Sets destination name.
         *
         * @param destinationName the destination name
         * @return the builder
         */
        public CreateTripEventBuilder setDestinationName(String destinationName) {
            this.destinationName = destinationName;
            return this;
        }

        /**
         * Sets destination postal code.
         *
         * @param destinationPostalCode the destination postal code
         * @return the builder
         */
        public CreateTripEventBuilder setDestinationPostalCode(String destinationPostalCode) {
            this.destinationPostalCode = destinationPostalCode;
            return this;
        }

        /**
         * Sets destination street.
         *
         * @param destinationStreet the destination street
         * @return the builder
         */
        public CreateTripEventBuilder setDestinationStreet(String destinationStreet) {
            this.destinationStreet = destinationStreet;
            return this;
        }

        /**
         * Sets origin city.
         *
         * @param originCity the origin city
         * @return the builder
         */
        public CreateTripEventBuilder setOriginCity(String originCity) {
            this.originCity = originCity;
            return this;
        }

        /**
         * Sets origin country.
         *
         * @param originCountry the origin country
         * @return the builder
         */
        public CreateTripEventBuilder setOriginCountry(String originCountry) {
            this.originCountry = originCountry;
            return this;
        }

        /**
         * Sets origin latitude.
         *
         * @param originLatitude the origin latitude
         * @return the builder
         */
        public CreateTripEventBuilder setOriginLatitude(float originLatitude) {
            this.originLatitude = originLatitude;
            return this;
        }

        /**
         * Sets origin longitude.
         *
         * @param originLongitude the origin longitude
         * @return the builder
         */
        public CreateTripEventBuilder setOriginLongitude(float originLongitude) {
            this.originLongitude = originLongitude;
            return this;
        }

        /**
         * Sets origin name.
         *
         * @param originName the origin name
         * @return the builder
         */
        public CreateTripEventBuilder setOriginName(String originName) {
            this.originName = originName;
            return this;
        }

        /**
         * Sets origin postal code.
         *
         * @param originPostalCode the origin postal code
         * @return the builder
         */
        public CreateTripEventBuilder setOriginPostalCode(String originPostalCode) {
            this.originPostalCode = originPostalCode;
            return this;
        }

        /**
         * Sets origin street.
         *
         * @param originStreet the origin street
         * @return the builder
         */
        public CreateTripEventBuilder setOriginStreet(String originStreet) {
            this.originStreet = originStreet;
            return this;
        }

        /**
         * Build create trip event.
         *
         * @return the create trip event
         */
        public CreateTripEvent build() {
            return new CreateTripEvent(this);
        }
    }

}
