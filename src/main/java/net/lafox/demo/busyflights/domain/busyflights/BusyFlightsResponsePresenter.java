package net.lafox.demo.busyflights.domain.busyflights;

import java.text.DecimalFormat;

public class BusyFlightsResponsePresenter {

    private final String airline;
    private final String supplier;
    private final String fare;
    private final String departureAirportCode;
    private final String destinationAirportCode;
    private final String departureDate;
    private final String arrivalDate;

    private BusyFlightsResponsePresenter(Builder builder) {
        airline = builder.airline;
        supplier = builder.supplier;
        fare = builder.fare;
        departureAirportCode = builder.departureAirportCode;
        destinationAirportCode = builder.destinationAirportCode;
        departureDate = builder.departureDate;
        arrivalDate = builder.arrivalDate;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(BusyFlightsResponse copy) {
        DecimalFormat formatter = new DecimalFormat("#0.00");
        Builder builder = new Builder();
        builder.airline = copy.getAirline();
        builder.supplier = copy.getSupplier();
        builder.fare = formatter.format(copy.getFare());
        builder.departureAirportCode = copy.getDepartureAirportCode();
        builder.destinationAirportCode = copy.getDestinationAirportCode();
        builder.departureDate = copy.getDepartureDate();
        builder.arrivalDate = copy.getArrivalDate();
        return builder;
    }


    public static final class Builder {
        private String airline;
        private String supplier;
        private String fare;
        private String departureAirportCode;
        private String destinationAirportCode;
        private String departureDate;
        private String arrivalDate;

        private Builder() {
        }

        public Builder airline(String airline) {
            this.airline = airline;
            return this;
        }

        public Builder supplier(String supplier) {
            this.supplier = supplier;
            return this;
        }

        public Builder fare(String fare) {
            this.fare = fare;
            return this;
        }

        public Builder departureAirportCode(String departureAirportCode) {
            this.departureAirportCode = departureAirportCode;
            return this;
        }

        public Builder destinationAirportCode(String destinationAirportCode) {
            this.destinationAirportCode = destinationAirportCode;
            return this;
        }

        public Builder departureDate(String departureDate) {
            this.departureDate = departureDate;
            return this;
        }

        public Builder arrivalDate(String arrivalDate) {
            this.arrivalDate = arrivalDate;
            return this;
        }

        public BusyFlightsResponsePresenter build() {
            return new BusyFlightsResponsePresenter(this);
        }
    }

    public String getAirline() {
        return airline;
    }

    public String getSupplier() {
        return supplier;
    }

    public String getFare() {
        return fare;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }
}
