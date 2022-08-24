package MetThePet.service;

import MetThePet.dto.PasswordDto;
import MetThePet.dto.UserDto;
import MetThePet.exception.EmptyUsernameException;
import MetThePet.exception.InvalidPasswordException;
import MetThePet.exception.WrongPasswordException;
import MetThePet.model.User;

import java.util.List;

public interface UserService {

    boolean existsByUsername(String username) throws EmptyUsernameException;

    void save(User user);

    List<User> findAll();

    void deleteByUsername(String username);

    void save(UserDto userDto);

    void changePassword(String username, PasswordDto passwordDto) throws WrongPasswordException, InvalidPasswordException;

}