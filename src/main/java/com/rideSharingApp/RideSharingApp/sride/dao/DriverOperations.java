package com.rideSharingApp.RideSharingApp.sride.dao;

import com.rideSharingApp.RideSharingApp.sride.model.Driver;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DriverOperations {
    public boolean addDriver(Driver driver);
    public List<Driver> getRidersForGivenRoute(int source, int destination);
    public boolean updateSeatsAvailable(UUID driverId, int seatsBooked,String operator);
}
