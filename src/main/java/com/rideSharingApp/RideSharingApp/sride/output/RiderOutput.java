package com.rideSharingApp.RideSharingApp.sride.output;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class RiderOutput {

    @NonNull
    UUID riderId;
    @NonNull
    String name;
    int totalRidesDone;
    boolean preferredRider;

}
