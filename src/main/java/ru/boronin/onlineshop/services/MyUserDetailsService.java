package ru.boronin.onlineshop.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.boronin.onlineshop.config.security.MyUserDetail;
import ru.boronin.onlineshop.entities.MyUser;
import ru.boronin.onlineshop.repositories.UserRepository;

import java.util.Optional;
@Service
public class MyUserDetailsService implements UserDetailsService {
    public final UserRepository userRepository;


    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> user=userRepository.findByEmail(username);
        if (user.isEmpty()){throw  new UsernameNotFoundException("Пользователь не найден");}
        return new MyUserDetail(user.get());
    }
}
