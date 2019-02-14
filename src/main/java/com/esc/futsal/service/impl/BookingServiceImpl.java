package com.esc.futsal.service.impl;

import com.esc.futsal.entity.Booking;
import com.esc.futsal.repository.BookingRepository;
import com.esc.futsal.service.BookingService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingServiceImpl implements BookingService {

    private BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Booking> getAllBooking() {
        return bookingRepository.findAll();
    }

    @Override
    public void addBooking(Booking booking) {

        booking.setDatetime(booking.getDate()+":"+ booking.getTime());

        bookingRepository.save(booking);
    }

    @Override
    public void updateBooking(Booking booking) {
        bookingRepository.save(booking);

    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.delete(id);

    }

    @Override
    public Booking getById(Long id) {

        return bookingRepository.findByBookingId(id);
    }
}
