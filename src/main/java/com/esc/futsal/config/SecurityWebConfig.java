package com.esc.futsal.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;


@Configuration
@EnableWebSecurity
public class SecurityWebConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomAuthenticationSucecessHandler customAuthenticationSucecessHandler;

    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    @Qualifier("userDetailsService1")
    private UserDetailsService userDetailsService1;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/","/index/**","/contact" ,"/saveMember","/register").permitAll()
                .antMatchers("/resources/**" )
                .permitAll().antMatchers("/favicon.ico").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/bootstrap/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/console/**").permitAll().
                antMatchers("/member/**").access("hasAnyRole('ROLE_MEMBER')")
                .antMatchers("/admin/**").access("hasAnyRole('ROLE_ADMIN')")
                .antMatchers("/user/**").access("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").successHandler(customAuthenticationSucecessHandler)
                .failureUrl("/login?error=true")

                .permitAll()
                .and()
                .logout().logoutSuccessUrl("/index")
                .permitAll()
                .and().exceptionHandling().accessDeniedPage("/403").and().
                headers()
                .frameOptions().disable();
        super.configure(http);
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        auth.userDetailsService(userDetailsService1);


    }








}
