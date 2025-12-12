package com.movie.ticket.booking.booking_Service.repository;

import com.movie.ticket.booking.booking_Service.entites.BookingEntiy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface BoolingRepository extends CrudRepository<BookingEntiy, UUID> {


}
