package mk.finki.ukim.mk.wezba1.service;

import mk.finki.ukim.mk.wezba1.model.User;
import mk.finki.ukim.mk.wezba1.model.enumerations.Role;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


public interface UserService extends UserDetailsService {
    User register(String username, String password, String repeatPassword, String name, String surname, Role role);
}
