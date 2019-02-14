package com.esc.futsal.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;

@Service
public class CustomAuthenticationSucecessHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException, ServletException {
        HttpSession session = request.getSession();

        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        session.setAttribute("uname", authUser.getUsername());
        session.setAttribute("authorities", authUser.getAuthorities());


        String targetUrl = determineTargetUrl(auth);
        redirectStrategy.sendRedirect(request, response, targetUrl);

    }
    protected String determineTargetUrl(Authentication auth){
        Set<String> authorities = AuthorityUtils.authorityListToSet(auth.getAuthorities());
        if (authorities.contains("ROLE_ADMIN")) {
            return "adminIndex";
        } else if (authorities.contains("ROLE_MEMBER")) {
            return "customerIndex";
        } else {
            return "login";

        }

    }

    public RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }

    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

}
