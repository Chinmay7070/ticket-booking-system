package com.movie.ticket.booking.system.api_gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingApiHandler {

    @GetMapping("/booking-fallback")
    public String bookingApiFallback(){
        System.out.println("fffffffffffffffffffffff");
        return "Booking services is in maintainence mode plz try after sometime......";
    }
}
