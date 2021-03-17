package com.rideSharingApp.RideSharingApp.sride.dao;

import com.rideSharingApp.RideSharingApp.sride.model.Rider;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Repository
public class RiderDao implements RiderOperations{

    HashMap<UUID,Rider> riderInfoDb = new HashMap<>();

    @Override
    public boolean addRider(Rider rider) {
        riderInfoDb.put(rider.getRiderId(),rider);
        printRiderDetails();
        return true;
    }

    @Override
    public boolean updateRidesDone(UUID riderId) {
        Rider rider = riderInfoDb.get(riderId);
        rider.setTotalRidesDone(rider.getTotalRidesDone()+1);
        riderInfoDb.put(riderId,rider);
        return true;
    }

    @Override
    public void updateRideStatus(UUID riderId) {
        riderInfoDb.remove(riderId);
    }

    @Override
    public Rider getRiderInfo(UUID riderId) {
        return riderInfoDb.get(riderId);
    }

    @Override
    public List<Rider> getRiderDetails() {
        List<Rider> riderList = new ArrayList<>(riderInfoDb.values());
        return riderList;
    }


    public void printRiderDetails(){
        System.out.println(riderInfoDb.entrySet());
    }

}
