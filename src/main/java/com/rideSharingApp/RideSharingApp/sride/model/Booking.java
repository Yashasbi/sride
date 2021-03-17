package com.rideSharingApp.RideSharingApp.sride.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Booking {

    UUID bookingId;
    UUID riderId;
    UUID vehicleId;
    int source;
    int destination;
    int seatsBooked;
    RideStatus rideStatus;
    int totalFare;

}
