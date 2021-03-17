package com.rideSharingApp.RideSharingApp.sride.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rideSharingApp.RideSharingApp.sride.input.RiderInput;
import com.rideSharingApp.RideSharingApp.sride.model.Rider;
import com.rideSharingApp.RideSharingApp.sride.output.RiderOutput;
import com.rideSharingApp.RideSharingApp.sride.service.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/rider")
public class RiderController {

    @Autowired
    RiderService riderService;

    @Autowired
    ObjectMapper objectMapper;

    @PostMapping("addRider")
    public boolean addRider(@RequestBody RiderInput riderInput){
        riderService.addRider(riderInput.getRiderId(),riderInput.getName());
        return true;
    }
    @GetMapping("getRiderDetails/{riderId}")
    public RiderOutput getRiderDetails(@PathVariable UUID riderId){
        return  objectMapper.convertValue(riderService.getRiderDetails(riderId),RiderOutput.class);
    }
    @GetMapping("getAllRiderDetails")
    public List<RiderOutput> getAllRiderDetails( ){
        List<RiderOutput> riderOutputList = new ArrayList<>();
        List<Rider> riderList = riderService.getAllRiderDetails();
        for(Rider rider : riderList){
            riderOutputList.add(objectMapper.convertValue(rider,RiderOutput.class));
        }
        return riderOutputList;
    }

}
