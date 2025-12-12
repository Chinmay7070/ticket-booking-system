package com.movie.ticket.booking.booking_Service.Services;

import com.movie.ticket.booking.booking_Service.dtos.BookingDtos;
import com.movie.ticket.booking.booking_Service.dtos.ResponseDTo;

public interface IBookingService {

    public ResponseDTo makePayments(BookingDtos bookingDtos);
}
