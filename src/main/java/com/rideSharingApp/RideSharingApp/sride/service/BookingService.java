package com.rideSharingApp.RideSharingApp.sride.service;

import com.rideSharingApp.RideSharingApp.sride.dao.BookingOperations;
import com.rideSharingApp.RideSharingApp.sride.dao.DriverDao;
import com.rideSharingApp.RideSharingApp.sride.dao.RiderDao;
import com.rideSharingApp.RideSharingApp.sride.exception.NoRiderFoundForSelectedRoute;
import com.rideSharingApp.RideSharingApp.sride.exception.NoSeatAvailableForSelectedRoute;
import com.rideSharingApp.RideSharingApp.sride.exception.RideAlreadyBookedForGivenRoute;
import com.rideSharingApp.RideSharingApp.sride.input.BookingInput;
import com.rideSharingApp.RideSharingApp.sride.model.Booking;
import com.rideSharingApp.RideSharingApp.sride.model.Driver;
import com.rideSharingApp.RideSharingApp.sride.model.RideStatus;
import com.rideSharingApp.RideSharingApp.sride.output.BookingOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class BookingService {

    @Autowired
    DriverDao driverDao;

    @Autowired
    BookingOperations bookingDao;

    @Autowired
    RiderDao riderDao;

    public Booking bookRide(BookingInput bookingInput) throws NoRiderFoundForSelectedRoute, NoSeatAvailableForSelectedRoute, RideAlreadyBookedForGivenRoute {
        List<Driver> driverList = driverDao.getRidersForGivenRoute(bookingInput.getSource(),bookingInput.getDestination());
        if(driverList.isEmpty()){
            throw new NoRiderFoundForSelectedRoute("No rider found for selected route");
        }
        Optional<Driver> driverToOfferRide = driverList.stream().filter(driver -> driver.getNoOfSeatsAvailable() >= bookingInput.getSeatsToBook()).findFirst();
        if(driverToOfferRide.isPresent()){
            driverDao.updateSeatsAvailable(driverToOfferRide.get().getVehicleId(),bookingInput.getSeatsToBook(),"+");
            //riderDao.updateRidesDone(bookingInput.getRiderId());
            Booking booking = bookingDao.bookRide(bookingInput,driverToOfferRide.get());
            int fareCalculated = bookingDao.calculateFare(booking);
            booking.setTotalFare(fareCalculated);
            return booking;
            //BookingOutput bookingOutput = new BookingOutput(booking.getRiderId(),booking.getVehicleId(),booking.getSeatsBooked(),booking.getSource(),booking.getDestination(),booking.getSeatsBooked(),booking.getRideStatus(),booking.getTotalFare(),booking.)
        }
        else{
            throw new NoSeatAvailableForSelectedRoute("All riders are occupied for this route.");
        }
    }
    public Booking cancelRide(UUID bookingID){
        Booking booking = bookingDao.getBookingInfo(bookingID);
        driverDao.updateSeatsAvailable(booking.getVehicleId(),booking.getSeatsBooked(),"-");
        booking.setRideStatus(RideStatus.CANCELLED);
        bookingDao.updateBooking(bookingID,booking);
        return bookingDao.getBookingInfo(bookingID);

    }
    public int closeRide(UUID bookingId){
        Booking booking = bookingDao.getBookingInfo(bookingId);
        driverDao.updateSeatsAvailable(booking.getVehicleId(),booking.getSeatsBooked(),"-");
        booking.setRideStatus(RideStatus.COMPLETED);
        riderDao.updateRidesDone(booking.getRiderId());
        return bookingDao.calculateFare(booking);
    }
    public List<Booking> getAllRidesBooked(){
        return bookingDao.getAllRidesBooked();
    }

}
