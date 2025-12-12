package com.movie.ticket.booking.booking_Service.Services.IMpl;

import com.movie.ticket.booking.booking_Service.Brokerss.PaymentsServiceBrokers;
import com.movie.ticket.booking.booking_Service.Services.IBookingService;
import com.movie.ticket.booking.booking_Service.dtos.BookingDtos;
import com.movie.ticket.booking.booking_Service.dtos.ResponseDTo;
import com.movie.ticket.booking.booking_Service.entites.BookingEntiy;
import com.movie.ticket.booking.booking_Service.entites.Bookingstatus;
import com.movie.ticket.booking.booking_Service.repository.BoolingRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BookingServiceIMpl implements IBookingService {

    @Autowired
    private BoolingRepository boolingRepository;
    @Autowired
    private PaymentsServiceBrokers paymentsServiceBrokers;

    @Override
    @Transactional
    public ResponseDTo makePayments(BookingDtos bookingDtos) {
      log.info("Entereed into BookingService IMple createBooking with request data as "+bookingDtos);

      /*  BookingEntiy bookingEntiy = new BookingEntiy();
        bookingEntiy.setMovieId(bookingDtos.getMovieId());
        bookingEntiy.setBookingAmount(bookingDtos.getBookingAmount());
        bookingEntiy.setBookingstatus(Bookingstatus.PENDING);
        bookingEntiy.setShowDate(bookingDtos.getShowDate());
        bookingEntiy.setShowTime(bookingDtos.getShowTime());
        bookingEntiy.setSeatSeleacted(bookingDtos.getSeatSeleacted());*/


        BookingEntiy bookingEntiy1 = BookingEntiy.builder()
                .userId(bookingDtos.getUserId())
                .movieId(bookingDtos.getMovieId())
                .bookingAmount(bookingDtos.getBookingAmount())
                .bookingstatus(Bookingstatus.PENDING)
                .showDate(bookingDtos.getShowDate())
                .showTime(bookingDtos.getShowTime())
                .seatSeleacted(bookingDtos.getSeatSeleacted()).build();
        this.boolingRepository.save(bookingEntiy1);
           bookingDtos.setBookingId(bookingEntiy1.getBookingid());
         com.movie.ticket.booking.booking_Service.dtos.BookingDtos bookingDtosPaymentResponse =  this.paymentsServiceBrokers.mekePayments(bookingDtos);
          bookingEntiy1.setBookingstatus(bookingDtosPaymentResponse.getBookingstatus());
       return ResponseDTo.builder().bookingDtos( BookingDtos.builder()
               .bookingId(bookingEntiy1.getBookingid())
               .userId(bookingEntiy1.getUserId())
               .movieId(bookingEntiy1.getMovieId())
               .bookingAmount(bookingEntiy1.getBookingAmount())
               .bookingstatus(bookingEntiy1.getBookingstatus())
               .showDate(bookingEntiy1.getShowDate())
               .showTime(bookingEntiy1.getShowTime())
               .seatSeleacted(bookingEntiy1.getSeatSeleacted()).build()).build();
    }
}
