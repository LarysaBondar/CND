package info.bondar.user.application.registerUser;

import info.bondar.user.domain.User;
import info.bondar.user.domain.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService implements RegisterUserUseCase {
    private final UserRepository userRepository;

    public RegisterUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void execute(RegisterUserCommand command) {
        System.err.println("AAAAAAAAAAAAAAAAAAAAAAA");
        User newUser = new User(null, command.getUsername(), command.getPassword());
        userRepository.save(newUser);
    }
}