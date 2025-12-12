package com.payment.sservice.payment_sservice.PaymetService;


import com.payment.sservice.payment_sservice.dtoes.BookingDtos;

public interface paymentService {

    public BookingDtos mekePayments(BookingDtos bookingDtos)throws Exception;
}
