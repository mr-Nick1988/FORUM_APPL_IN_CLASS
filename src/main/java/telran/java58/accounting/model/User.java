package telran.java58.accounting.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document(collection = "users")
@Getter
@Setter
public class User {
    @Id
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    Set<String> roles = new HashSet<>();
}
