package com.payment.sservice.payment_sservice.appies;

import com.payment.sservice.payment_sservice.PaymetService.paymentService;
import com.payment.sservice.payment_sservice.dtoes.BookingDtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentApi {

    @Autowired
    private paymentService paymentservice;

    @PostMapping
    public BookingDtos makePayment(@RequestBody BookingDtos bookingDTO) throws Exception {
        return paymentservice.mekePayments(bookingDTO);
    }
}

