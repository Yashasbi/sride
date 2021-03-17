package com.rideSharingApp.RideSharingApp.sride.model;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Rider {
    @NonNull
    UUID riderId;
    @NonNull
    String name;
    int totalRidesDone;
    boolean preferredRider;

    @Override
    public String toString() {
        return "Rider{" +
                "riderId=" + riderId +
                ", name='" + name + '\'' +
                ", totalRidesDone=" + totalRidesDone +
                ", preferredRider=" + preferredRider +
                '}';
    }
}
