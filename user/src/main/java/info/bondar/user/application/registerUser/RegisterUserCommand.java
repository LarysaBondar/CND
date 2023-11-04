package info.bondar.user.application.registerUser;
import lombok.*;

// A command for registering a new user.
@Data
public class RegisterUserCommand {
    private String username;
    private String password;
}