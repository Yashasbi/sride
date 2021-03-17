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

public class Driver {

    UUID vehicleId;
    int source;
    int destination;
    int noOfSeatsAvailable;
    int totalSeatsBooked;

    @Override
    public String toString() {
        return "Driver{" +
                "vehicleId=" + vehicleId +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", noOfSeatsAvailable=" + noOfSeatsAvailable +
                ", totalSeatsBooked=" +totalSeatsBooked +
                '}';
    }
}
