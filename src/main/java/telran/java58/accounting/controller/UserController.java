package telran.java58.accounting.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import telran.java58.accounting.dto.NewUserDto;
import telran.java58.accounting.dto.RoleResponseDto;
import telran.java58.accounting.dto.UpdateUserDto;
import telran.java58.accounting.dto.UserDto;
import telran.java58.accounting.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class UserController {

    private final UserService userService;


    @RequestMapping("/register")
    public UserDto registerUser(@RequestBody NewUserDto userDto) {
        return userService.registerUser(userDto);
    }

    @PostMapping("/login")
    public UserDto loginUser() {
        return null;
    }

    @DeleteMapping("/user/{user}")
    public UserDto removeUser(@PathVariable String user) {
        return userService.removeUser(user);
    }

    @PatchMapping("/user/{user}")
    public UserDto updateUser(@PathVariable String user, @RequestBody UpdateUserDto userDto) {
        return userService.updateUser(user, userDto);
    }

    @PatchMapping("/user/{user}/role/{role}")
    public RoleResponseDto addRole(@PathVariable String user, @PathVariable String role) {
        return userService.addRole(user, role);
    }

    @DeleteMapping("/user/{user}/role/{role}")
    public RoleResponseDto deleteRole(@PathVariable String user, @PathVariable String role) {
        return userService.deleteRole(user, role);
    }

    @PatchMapping("/password")
    public void changePassword() {
        throw new UnsupportedOperationException();
    }

    @GetMapping("/user/{user}")
    public UserDto getUser(@PathVariable String user) {
        return userService.getUser(user);

    }
}