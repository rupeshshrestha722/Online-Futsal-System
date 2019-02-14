package com.esc.futsal.controller;


import com.esc.futsal.constant.LoginControllerConstant;
import com.esc.futsal.entity.Member;
import com.esc.futsal.entity.User;
import com.esc.futsal.service.MemberService;
import com.esc.futsal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LoginController {




    private UserService userService;

    private MemberService memberService;


    public LoginController(UserService userService, MemberService memberService) {
        this.userService = userService;
        this.memberService = memberService;
    }

//    @ModelAttribute
//    public void globalData(Model model){
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        if(principal instanceof UserDetails){
//            String username = ((UserDetails)principal).getUsername();
//
//            User user = userService.findByUsername(username);
//            Member member = memberService.findByUsername(username);
//            model.addAttribute("userfullname",user.getFirstName() + ' ' + user.getMiddleName() + ' '+ user.getLastName());
//           model.addAttribute("memberfullname", member.getMemberFullName());
//           model.addAttribute("username",member.getUsername());
//        }
//    }



    @GetMapping(LoginControllerConstant.LOGIN_PATH)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return LoginControllerConstant.LOGIN_PAGE;
    }


    @GetMapping(LoginControllerConstant.ACCESS_DENIED_PATH)
    public String accessDenied(Model model) {

        return LoginControllerConstant.ACCESS_DENIED_PAGE;
    }
}
