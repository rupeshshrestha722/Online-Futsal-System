package com.esc.futsal.repository;

import com.esc.futsal.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    Booking findByBookingId(Long id);
    Booking findByUsername(String username);
  //  Booking findDistinctByDate();
    Booking findDistinctByDateInAndTime(String date, String time);
//    Booking findByDatetime(String datetime);

}
