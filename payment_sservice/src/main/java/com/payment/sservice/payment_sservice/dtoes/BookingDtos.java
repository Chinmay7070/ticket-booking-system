package com.payment.sservice.payment_sservice.dtoes;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
@Builder
public class BookingDtos {
    private UUID bookingId;
    @NotBlank(message = "User id is mandatory")
    private String userId;
    @NotNull(message = "movie id is mandatory")
    @Positive(message = "please provide movie id")
    private Integer movieId;
    @NotNull(message = "you need to select at least one seat to crate a bookig")
    private List<String> seatSeleacted;
    @NotNull(message = "select the show date")
    private LocalDate showDate;
    @NotNull(message = "select the show time ")
    private LocalTime showTime;
    @NotNull(message = "booking amount is mandatory")
    @Positive(message = "Booking amount must be a positive value")
    private Double bookingAmount;
    private Bookingstatus bookingstatus;
}
