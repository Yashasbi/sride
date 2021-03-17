package com.rideSharingApp.RideSharingApp.sride.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rideSharingApp.RideSharingApp.sride.dao.DriverDao;
import com.rideSharingApp.RideSharingApp.sride.dao.RiderDao;
import com.rideSharingApp.RideSharingApp.sride.exception.NoRiderFoundForSelectedRoute;
import com.rideSharingApp.RideSharingApp.sride.exception.NoSeatAvailableForSelectedRoute;
import com.rideSharingApp.RideSharingApp.sride.exception.RideAlreadyBookedForGivenRoute;
import com.rideSharingApp.RideSharingApp.sride.input.BookingInput;
import com.rideSharingApp.RideSharingApp.sride.model.Booking;
import com.rideSharingApp.RideSharingApp.sride.output.BookingOutput;
import com.rideSharingApp.RideSharingApp.sride.service.BookingService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/v1/book")

public class BookingController {

    @Autowired
    BookingService bookingService;

    @Autowired
    ObjectMapper objectMapper;

    @PostMapping("bookRide")
    public BookingOutput bookRide(@RequestBody BookingInput bookingInput) throws NoRiderFoundForSelectedRoute, NoSeatAvailableForSelectedRoute, RideAlreadyBookedForGivenRoute {
        System.out.println("BookingInput is " +bookingInput);
        Booking booking = bookingService.bookRide(bookingInput);
        return (objectMapper.convertValue(booking,BookingOutput.class));
    }
    @DeleteMapping("cancelRide/{bookingId}")
    public BookingOutput cancelRide(@PathVariable UUID bookingId){
        return objectMapper.convertValue(bookingService.cancelRide(bookingId),BookingOutput.class);
    }
    @PostMapping("closeRide/{bookingId}")
    public int closeRide(@PathVariable UUID bookingId){
        return bookingService.closeRide(bookingId);
    }

    @GetMapping("getAllBookings")
    public List<BookingOutput> getAllRidesBooked(){
        List<BookingOutput> bookingOutputs = new ArrayList<>();
        List<Booking> bookings = bookingService.getAllRidesBooked();
        for(Booking booking : bookings){
            bookingOutputs.add(objectMapper.convertValue(booking,BookingOutput.class));
        }
        return bookingOutputs;
    }

}
