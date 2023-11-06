package be.heh.application.domain.service;

import be.heh.application.domain.model.User;
import be.heh.application.port.in.UserAccount;
import be.heh.application.port.out.UserRepository;

public class UserAccountService implements UserAccount{
    private UserRepository userRepository;
    public UserAccountService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public void userConnection(User user) {
        userRepository.addAccount(user);
    }
}
