package info.bondar.user.application.registerUser;

// Handles the registration of a new user based on the RegisterUserCommand.

import info.bondar.user.domain.User;
import info.bondar.user.domain.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public interface RegisterUserUseCase {
    void execute(RegisterUserCommand command);
}