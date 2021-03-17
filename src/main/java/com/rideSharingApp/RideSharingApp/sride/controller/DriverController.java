package com.rideSharingApp.RideSharingApp.sride.controller;

import com.rideSharingApp.RideSharingApp.sride.input.DriverInput;
import com.rideSharingApp.RideSharingApp.sride.model.Driver;
import com.rideSharingApp.RideSharingApp.sride.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    @PostMapping("addDriver")
     public boolean addDriver(@RequestBody DriverInput driverInput){
        Driver driver = new Driver(driverInput.getVehicleId(),driverInput.getSource(),driverInput.getDestination(),driverInput.getNoOfSeatsAvailable(),0);
        return driverService.addDriver(driver);
    }
    @GetMapping("getAllDriverInfo")
    public List<Driver> getAllDriverInfo(){
        return driverService.getAllDriverInfo();
    }


}
