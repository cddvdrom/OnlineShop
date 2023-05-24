package ru.boronin.onlineshop.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.boronin.onlineshop.DTO.UserDTO;
import ru.boronin.onlineshop.entities.MyUser;
import ru.boronin.onlineshop.services.MyUserDetailsService;

import java.util.Optional;

@Component
public class UserValidator implements Validator {

    private final MyUserDetailsService myUserDetailsService;



   @Autowired
    public UserValidator(MyUserDetailsService myUserDetailsService) {
        this.myUserDetailsService = myUserDetailsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return MyUser.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
UserDTO user=(UserDTO) target;

UserDetails userDetails=myUserDetailsService.loadUserByUsername(user.getEmail());
if(user!=null){
errors.rejectValue("username ","Такой пользователь уже существует");}

    }
}
