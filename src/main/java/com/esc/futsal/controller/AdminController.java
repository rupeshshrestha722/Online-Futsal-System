package com.esc.futsal.controller;

import com.esc.futsal.entity.Booking;
import com.esc.futsal.entity.Member;
import com.esc.futsal.entity.User;
import com.esc.futsal.service.MemberService;
import com.esc.futsal.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@SessionAttributes({"userfullname"})
public class AdminController {

    private UserService userService;

    private MemberService memberService;

    public AdminController(UserService userService, MemberService memberService) {
        this.userService = userService;
        this.memberService = memberService;
    }




    @ModelAttribute("userfullname")
    public String addStuffToRequestScopeName() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
           User user = userService.findByUsername(username);
            return (user.getFirstName()+" "+user.getMiddleName() + " "+ user.getLastName());
        }
        return "";
    }

    @GetMapping("/adminIndex")
    public String adminIndex(){
        return "adminIndex";
    }

    @GetMapping("/admin/viewAdmin")
    public  String viewAdmin(Model model){
        model.addAttribute("admins",userService.getAllUser());
        return "admin/viewAdmin";
    }

    @GetMapping("/admin/viewMember")
    public String viewMember(Model model){
        model.addAttribute("members",memberService.getAllMember());
        return "admin/viewMember";
    }


    @GetMapping("/admin/deleteMember/{id}")
    public  String deleteMember(@PathVariable("id")Long id){
        memberService.deleteMember(id);
        return "redirect:/admin/viewMember";
    }

}
