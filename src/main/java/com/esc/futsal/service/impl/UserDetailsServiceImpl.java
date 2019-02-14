package com.esc.futsal.service.impl;



import com.esc.futsal.entity.Role;
import com.esc.futsal.entity.User;
import com.esc.futsal.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {


    private UserRepository userRepository;


    public UserDetailsServiceImpl(UserRepository uRepository) {
        this.userRepository = uRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User Not Found");
        }


        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        try {
            for (Role role : user.getRoleList()) {
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));


            }
        } catch (NullPointerException ne) {
            ne.printStackTrace();
        }


        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);


    }

}
