package com.esc.futsal.service.impl;

import com.esc.futsal.entity.Member;
import com.esc.futsal.entity.MemberRole;
import com.esc.futsal.repository.MemberRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service("userDetailsService1")
public class MemberDetailsServiceImpl  implements UserDetailsService {
    private MemberRepository memberRepository;


    public MemberDetailsServiceImpl(MemberRepository mRepository) {
      this.memberRepository = mRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member =  memberRepository.findByUsername(username);

        if(member == null){
            throw new UsernameNotFoundException("Member Not Found");
        }

        Set<GrantedAuthority> authorities = new HashSet<>();

        try{
            for(MemberRole role : member.getMemberRoleList()){
                authorities.add(new SimpleGrantedAuthority(role.getMemberRoleName()));            }
        }catch(NullPointerException ne){
            ne.printStackTrace();
        }

        return new User(member.getUsername(), member.getPassword(),authorities);
    }
}
