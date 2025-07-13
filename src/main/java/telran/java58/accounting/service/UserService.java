package telran.java58.accounting.service;

import telran.java58.accounting.dto.NewUserDto;
import telran.java58.accounting.dto.RoleResponseDto;
import telran.java58.accounting.dto.UpdateUserDto;
import telran.java58.accounting.dto.UserDto;

public interface UserService {

    UserDto registerUser(NewUserDto userDto);

    UserDto removeUser(String user);

    UserDto updateUser(String user, UpdateUserDto userDto);

    RoleResponseDto addRole(String user, String role);

    RoleResponseDto deleteRole(String user, String role);

    UserDto getUser(String user);
}
