package com.rideSharingApp.RideSharingApp.sride.service;

import com.rideSharingApp.RideSharingApp.sride.dao.RiderDao;
import com.rideSharingApp.RideSharingApp.sride.input.RiderInput;
import com.rideSharingApp.RideSharingApp.sride.model.Rider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class RiderService {

    @Autowired
    RiderDao riderDao;
    public void addRider(UUID riderId, String riderName){
        riderDao.addRider(new Rider(riderId,riderName,0,false));
    }
    public Rider getRiderDetails(UUID riderId){
        return riderDao.getRiderInfo(riderId);
    }
    public List<Rider> getAllRiderDetails(){
        return riderDao.getRiderDetails();
    }
}
