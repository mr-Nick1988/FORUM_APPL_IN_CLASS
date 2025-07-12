package telran.java58.accounting.dto;

import lombok.Getter;

import java.util.Set;

@Getter
public class UserDto {
    private String login;
    private String firstName;
    private String lastName;
    Set<String> roles;
}
