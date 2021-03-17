package com.rideSharingApp.RideSharingApp.sride.dao;

import com.rideSharingApp.RideSharingApp.sride.model.Driver;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class DriverDao implements DriverOperations{

    HashMap<UUID,Driver> driverInfo = new HashMap<>();

    @Override
    public boolean addDriver(Driver driver) {
        driverInfo.put(driver.getVehicleId(),driver);
        //printDriverDetails();
        return true;
    }

    @Override
    public List<Driver> getRidersForGivenRoute(int source, int destination) {
       List<Driver> driverList = new ArrayList<>();
        for(Map.Entry<UUID,Driver> driver : driverInfo.entrySet()){
            if((driver.getValue().getSource() == source) && driver.getValue().getDestination() == destination){
                driverList.add(driver.getValue());
            }
        }
        return driverList;
    }

    @Override
    public boolean updateSeatsAvailable(UUID driverId, int seatsBooked,String operator) {
        Driver driver = driverInfo.get(driverId);
        if(operator.equals("+")){
            driver.setTotalSeatsBooked(driver.getTotalSeatsBooked()+ seatsBooked);
            driver.setNoOfSeatsAvailable(driver.getNoOfSeatsAvailable()-seatsBooked);
        }
        else{
            driver.setTotalSeatsBooked(driver.getTotalSeatsBooked() - seatsBooked);
            driver.setNoOfSeatsAvailable(driver.getNoOfSeatsAvailable() + seatsBooked);
        }

        driverInfo.put(driverId,driver);
        System.out.println("After offering ride driver is left with " +driver);
        return false;
    }

    public List<Driver> getDriverDetails(){
        return (List<Driver>)new ArrayList<>(driverInfo.values());
    }
}
