package com.esc.futsal.controller;

import com.esc.futsal.entity.Member;
import com.esc.futsal.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DefaultController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(value= {"/index"}, method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value= {"/contact"}, method = RequestMethod.GET)
    public String contact(){
        return "contact";
    }


}
