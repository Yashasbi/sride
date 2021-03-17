package com.rideSharingApp.RideSharingApp.sride.dao;

import com.rideSharingApp.RideSharingApp.sride.input.BookingInput;
import com.rideSharingApp.RideSharingApp.sride.model.Booking;
import com.rideSharingApp.RideSharingApp.sride.model.Driver;

import java.util.List;
import java.util.UUID;

public interface BookingOperations {
    public Booking bookRide(BookingInput bookingInput, Driver driver);
    public int calculateFare(Booking booking);
    public Booking getBookingInfo(UUID bookingID);
    public boolean updateBooking(UUID bookingID, Booking booking);
    public List<UUID> isBookingPresentForRider(UUID riderId);
    public List<Booking> getAllRidesBooked();

}
