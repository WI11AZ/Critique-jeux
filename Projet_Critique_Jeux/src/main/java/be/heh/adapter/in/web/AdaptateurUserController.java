package be.heh.adapter.in.web;

import be.heh.application.domain.model.User;
import be.heh.application.domain.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdaptateurUserController {

    private final UserService userService;

    public AdaptateurUserController(UserService userService) {
        this.userService = userService;
    }
//tester avec mock mvc pour les controller
    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable int userId) {
        User user = userService.getUserById(userId);

        if (user != null) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(user);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }
    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable int userId, @RequestBody User updatedUserData) {
        User updatedUser = userService.updateUser(userId, updatedUserData);

        if (updatedUser != null) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(updatedUser);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable int userId) {
        boolean deleted = userService.deleteUser(userId);

        if (deleted) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User userData) {
        User createdUser = userService.createUser(userData.getUsername(), userData.getPassword());

        if (createdUser != null) {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(createdUser);
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
}
