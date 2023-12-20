package be.heh.application.port.out;

import be.heh.application.domain.model.User;

public interface UserRepository {
    User createUser(User user);
    User getUserById(int userId);
    User getUserByUsername(String username);
    boolean deleteUser(int userId);

    void updateUser(User user);
}
