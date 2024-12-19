package mk.finki.ukim.mk.wezba1.service;

import mk.finki.ukim.mk.wezba1.model.User;

public interface AuthService {

    User login(String username, String password);

}
