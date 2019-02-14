package com.esc.futsal.service;

import com.esc.futsal.entity.Booking;

import java.util.List;

public interface BookingService {
    List<Booking> getAllBooking();

    void addBooking(Booking booking);

    void updateBooking(Booking booking);

    void deleteBooking(Long id);

    Booking getById(Long id);

}
