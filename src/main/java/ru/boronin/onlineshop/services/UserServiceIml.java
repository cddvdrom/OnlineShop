package ru.boronin.onlineshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.boronin.onlineshop.DTO.UserDTO;
import ru.boronin.onlineshop.entities.Bucket;
import ru.boronin.onlineshop.entities.MyUser;

import ru.boronin.onlineshop.entities.Product;
import ru.boronin.onlineshop.enums.Roles;
import ru.boronin.onlineshop.repositories.BacketRepository;
import ru.boronin.onlineshop.repositories.UserRepository;

import java.util.List;

@Service
public class UserServiceIml implements UserService {

    private final UserRepository userRepository;
    private final BacketRepository backetRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceIml(UserRepository userRepository, BacketRepository backetRepository, PasswordEncoder passwordEncoder) {
        //   this.passwordEncoder = passwordEncoder;
        this.userRepository
                = userRepository;
        this.backetRepository = backetRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public List<MyUser> getaAllUsers() {return userRepository.findAll();

    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    @Override
    public boolean save(UserDTO userDTO) {

        if (!userDTO.getPassword().equals(userDTO.getMatchPassword())) {
            throw new RuntimeException("Пароль неверен");
        }
String encPass=passwordEncoder.encode(userDTO.getPassword());
        Bucket bucket = new Bucket();
        MyUser user = new MyUser();
        user.setPhonenumber("1");
        user.setActive(true);
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setRole(Roles.ROLE_CLIENT);
        user.setPassword(encPass);
        user.setBucket(bucket);
        MyUser UserDb = userRepository.save(user);
        bucket.setUser(UserDb);
        backetRepository.save(bucket);
        return true;
    }

    @Override
    public boolean create(UserDTO userDTO) {
        if (userRepository.findByEmail(userDTO.getEmail()) != null) {
            return false;
        }
        if (userDTO.getPassword() != userDTO.getMatchPassword()) {
            throw new RuntimeException("Пароль неверен");
        }
        MyUser user = new MyUser();
        user.setActive(true);
        user.setEmail(userDTO.getEmail());
        user.setRole(Roles.ROLE_CLIENT);
        user.setPassword(userDTO.getPassword());
        userRepository.save(user);
        return true;
    }

}
