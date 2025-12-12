package com.movie.ticket.booking.booking_Service.Brokerss;

import com.movie.ticket.booking.booking_Service.dtos.BookingDtos;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment-service")
public interface PaymentsServiceBrokers {
    @PostMapping("/payments")
    public BookingDtos  mekePayments(@RequestBody BookingDtos bookingDtos);

}
