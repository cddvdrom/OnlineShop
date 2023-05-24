package ru.boronin.onlineshop.services;
import ru.boronin.onlineshop.DTO.UserDTO;
import ru.boronin.onlineshop.entities.MyUser;
import ru.boronin.onlineshop.entities.Product;

import java.util.List;

public interface UserService {
    boolean create (UserDTO userDTO);

    boolean save(UserDTO userDTO);

     List<MyUser> getaAllUsers();

     void delete(Long id);
}
