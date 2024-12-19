package mk.finki.ukim.mk.wezba1.service.impl;

import mk.finki.ukim.mk.wezba1.model.User;
import mk.finki.ukim.mk.wezba1.model.enumerations.Role;
import mk.finki.ukim.mk.wezba1.repository.jpa.UserRepository;
import mk.finki.ukim.mk.wezba1.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));

    }

    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname, Role role) {
        if (username == null || password == null || repeatPassword == null || name == null || surname == null) {
            throw new UsernameNotFoundException(username);
        }
        if (!password.equals(repeatPassword)) {
            throw new IllegalArgumentException("Passwords do not match");
        }
        if (this.userRepository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }
        User user = new User(username,passwordEncoder.encode(password), name, surname, role);
        return userRepository.save(user);
    }
}
