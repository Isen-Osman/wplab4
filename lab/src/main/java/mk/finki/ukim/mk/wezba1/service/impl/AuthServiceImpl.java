package mk.finki.ukim.mk.wezba1.service.impl;

import mk.finki.ukim.mk.wezba1.model.User;
import mk.finki.ukim.mk.wezba1.repository.jpa.UserRepository;
import mk.finki.ukim.mk.wezba1.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Username or password is empty");
        }
        return userRepository.findByUsernameAndPassword(username, password).orElseThrow(IllegalArgumentException::new);
    }

}

