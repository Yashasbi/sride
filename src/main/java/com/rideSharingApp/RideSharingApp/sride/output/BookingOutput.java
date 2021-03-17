package com.rideSharingApp.RideSharingApp.sride.output;

import com.rideSharingApp.RideSharingApp.sride.model.RideStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class BookingOutput {

    UUID riderId;
    int source;
    int destination;
    int seatsBooked;
    RideStatus rideStatus;
    int totalFare;
    UUID bookingId;
}
