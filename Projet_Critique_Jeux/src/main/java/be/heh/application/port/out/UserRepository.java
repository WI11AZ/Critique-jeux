package be.heh.application.port.out;

import be.heh.application.domain.model.User;

public interface UserRepository {
    void addAccount(User user);
}
