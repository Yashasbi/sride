package com.rideSharingApp.RideSharingApp.sride.dao;

import com.rideSharingApp.RideSharingApp.sride.model.Rider;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public interface RiderOperations {
    public boolean addRider(Rider rider);
    public boolean updateRidesDone(UUID riderId);
    public void updateRideStatus(UUID riderId);
    public Rider getRiderInfo(UUID riderId);
    public List<Rider> getRiderDetails();
}
