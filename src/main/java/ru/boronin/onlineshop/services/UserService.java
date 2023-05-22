package ru.boronin.onlineshop.services;
import ru.boronin.onlineshop.DTO.UserDTO;

    public interface UserService {
    boolean create (UserDTO userDTO);

    boolean save(UserDTO userDTO);
}
