package com.esc.futsal.controller;

import com.esc.futsal.constant.ApplicationConstants;
import com.esc.futsal.entity.Member;
import com.esc.futsal.entity.MemberRole;
import com.esc.futsal.repository.MemberRepository;
import com.esc.futsal.repository.MemberRoleRepository;
import com.esc.futsal.service.MemberService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes({"memberRoles","memberfullname","username"})
public class MemberController {

    private MemberRepository memberRepository;

    private MemberService memberService;

    private MemberRoleRepository memberRoleRepository;


    public MemberController(MemberRepository memberRepository, MemberService memberService, MemberRoleRepository memberRoleRepository) {
        this.memberRepository = memberRepository;
        this.memberService = memberService;
        this.memberRoleRepository = memberRoleRepository;
    }

    @ModelAttribute("memberfullname")
    public String addStuffToRequestScopeName() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            Member member = memberRepository.findByUsername(username);
            System.out.println();
            return (member.getMemberFullName());
        }
        return "";
    }

    @ModelAttribute("username")
    public String addStuffRequestScopeName() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();

            return (username);
        }
        return "";
    }


    @GetMapping("/customerIndex")
    public String customerIndex(Model model){

        return "customerIndex";
    }
    @GetMapping("/register")
    public String registerPassenger(Model model){

        model.addAttribute("member",new Member());
        model.addAttribute("memberType", ApplicationConstants.MEMBER_TYPE);
        return "register";

    }




    @PostMapping("/saveMember")
    public  String savePassenger(@Valid @ModelAttribute("member")Member member, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return "register";
        }
        memberService.addMember(member);
        return "redirect:/login";
    }

    @ModelAttribute("memberRoles")
    public List<MemberRole> initializeRole() {

        return memberRoleRepository.findAll();
    }





}
