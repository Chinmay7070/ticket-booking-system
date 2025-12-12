package com.payment.sservice.payment_sservice.PaymentRepository;

import com.payment.sservice.payment_sservice.Entites.PaymentEntities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IPaymentRepo extends JpaRepository<PaymentEntities, UUID> {
}
