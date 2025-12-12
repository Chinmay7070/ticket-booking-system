package com.payment.sservice.payment_sservice.PaymetService.Impl;


import com.payment.sservice.payment_sservice.Entites.PaymentEntities;
import com.payment.sservice.payment_sservice.Entites.PaymentStatus;
import com.payment.sservice.payment_sservice.PaymentRepository.IPaymentRepo;
import com.payment.sservice.payment_sservice.PaymetService.RozerPayPaymentGateway;
import com.payment.sservice.payment_sservice.PaymetService.paymentService;
import com.payment.sservice.payment_sservice.dtoes.BookingDtos;
import com.payment.sservice.payment_sservice.dtoes.Bookingstatus;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class serviceImpl implements paymentService {

    @Autowired
    private IPaymentRepo paymentRepo;

    @Autowired
    private RozerPayPaymentGateway rozerPayPaymentGateway;

    @Override
    @Transactional
    public BookingDtos mekePayments(BookingDtos bookingDtos) throws Exception {

        PaymentEntities paymentEntites = PaymentEntities.builder()
                .bookingId(bookingDtos.getBookingId())
                .paymentStatus(PaymentStatus.PENDING)
                .paymentAmount(bookingDtos.getBookingAmount())
                .build();

        this.paymentRepo.save(paymentEntites);
        BookingDtos updatedBooking = this.rozerPayPaymentGateway.processPayment(bookingDtos);

        if (updatedBooking.getBookingstatus() == Bookingstatus.CONFIRMED) {
            paymentEntites.setPaymentStatus(PaymentStatus.APPROVED);

        } else {
            paymentEntites.setPaymentStatus(PaymentStatus.FAILED);
        }
        this.paymentRepo.save(paymentEntites);


        // 4️⃣ Return updated DTO
        return updatedBooking;
    }


}
