package com.rideSharingApp.RideSharingApp.sride.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DriverInput {

    UUID vehicleId;
    int source;
    int destination;
    int noOfSeatsAvailable;

    @Override
    public String toString() {
        return "Driver{" +
                "vehicleId=" + vehicleId +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", noOfSeatsAvailable=" + noOfSeatsAvailable +
                '}';
    }
}
