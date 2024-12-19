package mk.finki.ukim.mk.wezba1.service;

import mk.finki.ukim.mk.wezba1.model.Location;

import java.util.List;
import java.util.Optional;

public interface LocationService {
    List<Location> findAll();
    Optional<Location> findById(Long id);

}
