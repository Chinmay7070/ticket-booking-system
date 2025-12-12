package com.payment.sservice.payment_sservice.Entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;


@Table(name = "payments")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class PaymentEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "payment_id")
    private UUID paymentId;
    @Column(name = "booking_id")
    private UUID bookingId;
    @Column(name = "payment_status")
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    @Column(name = "payment_amount")
    private Double paymentAmount;
    @Column(name = "payment_date_and_time")
    private LocalDateTime paymentDatetime;

}
