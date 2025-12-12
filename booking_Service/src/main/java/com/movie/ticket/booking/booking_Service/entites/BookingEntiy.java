package com.movie.ticket.booking.booking_Service.entites;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "bookings")
public class BookingEntiy {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "booking_id")
    private UUID bookingid;
    @Column(name = "user_id")
    private   String userId;
    @Column(name = "movie_id")
    private Integer movieId;
    @ElementCollection
    private List<String> seatSeleacted;
    @Column(name = "show_date")
    private LocalDate showDate;
    @Column(name = "show_time")
    private LocalTime showTime;
    @Enumerated(EnumType.STRING)
    private Bookingstatus bookingstatus;
    @Column(name = "booking_amount")
    private Double bookingAmount;
}
