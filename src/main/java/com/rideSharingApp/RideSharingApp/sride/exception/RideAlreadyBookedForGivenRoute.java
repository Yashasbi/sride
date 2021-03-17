package com.rideSharingApp.RideSharingApp.sride.exception;

public class RideAlreadyBookedForGivenRoute extends Exception{
    public RideAlreadyBookedForGivenRoute(String message){
        super(message);
    }
}
