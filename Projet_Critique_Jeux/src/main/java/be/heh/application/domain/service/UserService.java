package be.heh.application.domain.service;

import be.heh.application.domain.model.User;
import be.heh.application.port.out.UserRepository;

public class UserService {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String username, String email, String password) {
        User newUser = new User(0, username, email, password);
        return userRepository.createUser(newUser);
    }

    public User getUserById(int userId) {
        return userRepository.getUserById(userId);
    }

    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    public void deleteUser(int userId) {
        userRepository.deleteUser(userId);
    }

    public boolean authenticateUser(String username, String password) {
        User user = userRepository.getUserByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}
