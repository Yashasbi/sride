package com.rideSharingApp.RideSharingApp.sride.dao;

import com.rideSharingApp.RideSharingApp.sride.input.BookingInput;
import com.rideSharingApp.RideSharingApp.sride.model.Booking;
import com.rideSharingApp.RideSharingApp.sride.model.Driver;
import com.rideSharingApp.RideSharingApp.sride.model.RideStatus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Repository
public class BookingDao implements BookingOperations {

    final int amountChargedPerKms = 20;
    HashMap<UUID,Booking> storeBookingInfo = new HashMap<>();


    @Override
    public Booking bookRide(BookingInput bookingInput, Driver driver){
        UUID bookingId = generateBookingId();
        Booking booking = new Booking(bookingId,bookingInput.getRiderId(),driver.getVehicleId(),bookingInput.getSource(),bookingInput.getDestination(),bookingInput.getSeatsToBook(),RideStatus.SCHEDULED,0);
        storeBookingInfo.put(bookingId,booking);
        return booking;
    }

    @Override
    public int calculateFare(Booking booking) {
        if(booking.getSeatsBooked() == 1){
            return Math.abs(booking.getDestination() - booking.getSource()) * amountChargedPerKms;
        }
        else{
            return (int) (Math.abs(booking.getDestination() - booking.getSource()) * 0.75 * amountChargedPerKms * booking.getSeatsBooked());
        }
    }

    @Override
    public Booking getBookingInfo(UUID bookingID) {
        return storeBookingInfo.get(bookingID);
    }

    @Override
    public boolean updateBooking(UUID bookingID, Booking booking) {
        storeBookingInfo.put(bookingID,booking);
        return true;
    }

    @Override
    public List<UUID> isBookingPresentForRider(UUID riderId) {
        List<UUID> vehicleList = new ArrayList<>();
        for(UUID bookingId : storeBookingInfo.keySet()){
            Booking booking = storeBookingInfo.get(bookingId);
            if(booking.getRiderId().equals(riderId)){
                vehicleList.add(booking.getBookingId());
            }
        }
        return vehicleList;
    }

    @Override
    public List<Booking> getAllRidesBooked() {
        List<Booking> bookings = new ArrayList<>(storeBookingInfo.values());
        return bookings;
    }

    private UUID generateBookingId(){
        return UUID.randomUUID();
    }
}
