package com.rideSharingApp.RideSharingApp.sride.input;

import com.rideSharingApp.RideSharingApp.sride.model.RideStatus;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BookingInput {

    @NonNull
    UUID riderId;
    @NonNull
    int source;
    @NonNull
    int destination;
    @NonNull
    int seatsToBook;

    @Override
    public String toString() {
        return "BookingInput{" +
                "riderId=" + riderId +
                ", source=" + source +
                ", destination=" + destination +
                ", seatsToBook=" + seatsToBook +
                '}';
    }
}
