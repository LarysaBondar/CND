package info.bondar.user.presentation.in;


import info.bondar.user.application.registerUser.RegisterUserCommand;
import info.bondar.user.application.registerUser.RegisterUserService;
import info.bondar.user.domain.User;
import info.bondar.user.domain.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.*;

import javax.print.DocFlavor;

// Controller responsible for handling incoming HTTP requests related to user operations.
@RestController
@CrossOrigin("*")
public class UserController {

    private final RegisterUserService registerUserService;
    private final UserRepository userRepository;

    public UserController(RegisterUserService registerUserService, UserRepository userRepository) {

        this.registerUserService = registerUserService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hello!");
    }

    @PostMapping("/user")
    public ResponseEntity<String> registerUser(@RequestBody RegisterUserCommand command) {
        try {
            registerUserService.execute(command);
            return ResponseEntity.ok("User registered successfully. " + command);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error registering user.");
        }
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        return userRepository.findById(id);
    }
}