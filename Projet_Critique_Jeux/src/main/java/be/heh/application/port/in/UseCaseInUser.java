package be.heh.application.port.in;

import be.heh.application.domain.model.User;

public interface UseCaseInUser {
    User createUser(String username, String email, String password);
    User getUserById(int userId);
    User getUserByUsername(String username);
    void deleteUser(int userId);
    boolean authenticateUser(String username, String password);
}
