package com.rideSharingApp.RideSharingApp.sride.service;

import com.rideSharingApp.RideSharingApp.sride.dao.DriverDao;
import com.rideSharingApp.RideSharingApp.sride.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DriverService {
    @Autowired
    DriverDao driverDao;

    public boolean addDriver(Driver driver){
        return driverDao.addDriver(driver);
    }
    public List<Driver> getAllDriverInfo(){
        return driverDao.getDriverDetails();
    }
}
