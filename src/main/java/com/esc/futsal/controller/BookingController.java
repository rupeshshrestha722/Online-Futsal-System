package com.esc.futsal.controller;

import com.esc.futsal.entity.Booking;
import com.esc.futsal.entity.User;
import com.esc.futsal.repository.BookingRepository;

import com.esc.futsal.service.BookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes({"memberfullname","username","userfullname"})
public class BookingController {
    private BookingRepository bookingRepository;
    private BookingService bookingService;



    public BookingController(BookingRepository bookingRepository, BookingService bookingService) {
        this.bookingRepository = bookingRepository;
        this.bookingService = bookingService;
    }



    @ModelAttribute
    public void addToMode( @ModelAttribute("memberfullname") String name, @ModelAttribute("username")String username,@ModelAttribute("userfullname")String userfullname, Model model) {
        model.addAttribute("memberfullname", name);
        model.addAttribute("username",username);
        model.addAttribute("userfullname",userfullname);
    }

    @GetMapping("/member/viewBooking/{id}")
    public String viewreservation(Model model, @PathVariable(value="id", required = false)Long id){

        model.addAttribute("booking",bookingService.getById(id));
        return "member/viewBooking";
    }


    @GetMapping("/member/viewBooking")
    public String viewBooking(Model model){

        model.addAttribute("booking",bookingService.getAllBooking());
        return "member/viewBooking";
    }
    @GetMapping("/admin/viewBooking")
    public String adminviewBooking(Model model){
        List<Booking> reservationList = bookingService.getAllBooking();
        model.addAttribute("bookings",reservationList);
        return "admin/viewBooking";
    }




    @GetMapping("/member/book")
    public String reserveBook(Model model){
        model.addAttribute("booking", new Booking());

        return "member/bookForm";
    }

    @PostMapping("member/saveBook")
    public String saveBook(@Valid @ModelAttribute("booking") Booking booking, BindingResult result, Model model){

       Booking list = bookingRepository.findDistinctByDateInAndTime(booking.getDate(),booking.getTime());
        if( list != null){
           result.rejectValue("time",null,"This Date time is already booked");

        }

        if(result.hasErrors()){
            return "member/bookForm";
        }
        bookingService.addBooking(booking);
        Long bookingId = booking.getBookingId();

        return "redirect:/member/viewBooking/"+bookingId;
    }

    @GetMapping("/admin/deleteBooking/{id}")
    public String deleteReservation(@PathVariable("id")Long id){
        bookingService.deleteBooking(id);

        return "redirect:/admin/viewBooking";
    }

    @GetMapping("/admin/editBooking/{id}")
    public String editReservation(Model model,@PathVariable("id")long id){
        if(id != 0){
            model.addAttribute("booking",bookingService.getById(id));
        }else{
            model.addAttribute("booking", new Booking());
        }
        return "admin/editBooking";
    }

    @PostMapping("/admin/saveEditBooking")
    public String saveEditReservation(@Valid @ModelAttribute("booking")Booking booking, BindingResult result, Model model){
        bookingService.updateBooking(booking);
        return "redirect:/admin/viewBooking";
    }

    @GetMapping("/admin/addAdmin")
    public String addAdmin(Model model){
        model.addAttribute("admin",new User());
        return "admin/addAdmin";
    }




}
