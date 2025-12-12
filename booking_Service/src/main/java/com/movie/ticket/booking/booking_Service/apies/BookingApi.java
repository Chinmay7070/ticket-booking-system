package com.movie.ticket.booking.booking_Service.apies;


import com.movie.ticket.booking.booking_Service.Services.IBookingService;
import com.movie.ticket.booking.booking_Service.dtos.BookingDtos;
import com.movie.ticket.booking.booking_Service.dtos.ResponseDTo;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("booking")
public class BookingApi {

    @Autowired
    private IBookingService iBookingService;

    @PostMapping
    public ResponseEntity<ResponseDTo> createBooking(@Valid @RequestBody BookingDtos bookingDtos){
         log.info("Entered into Booking APi with JSON request "+ bookingDtos);
        ResponseDTo responseDTo = this.iBookingService.makePayments(bookingDtos);
        return new ResponseEntity<ResponseDTo>(responseDTo, HttpStatus.CREATED);
    }
    @GetMapping("/test")
    public String test(){
        System.out.println("thiiiiiiiiiiii");
        return "booking sercivice";
    }
}
