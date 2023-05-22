package ru.boronin.onlineshop.config.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ru.boronin.onlineshop.services.MyUserDetailsService;

import java.util.Collection;
import java.util.Collections;

@Component

public class AuthProviderImpl implements AuthenticationProvider {

    private MyUserDetailsService myUserDetailsService;
@Autowired
public AuthProviderImpl (MyUserDetailsService myUserD){
    this.myUserDetailsService=myUserD;
}
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName=authentication.getName();
        UserDetails userDetails=myUserDetailsService.loadUserByUsername(userName);
        String password=authentication.getCredentials().toString();
        if(!password.equals(userDetails.getPassword())){
throw new BadCredentialsException("Неправильный пароль");
        }
        return new UsernamePasswordAuthenticationToken(userDetails,password, Collections.emptyList());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
