package mk.finki.ukim.mk.wezba1.service.impl;

import mk.finki.ukim.mk.wezba1.model.Location;
import mk.finki.ukim.mk.wezba1.repository.impl.InMemoryLocationRepository;
import mk.finki.ukim.mk.wezba1.repository.jpa.LocationRepository;
import mk.finki.ukim.mk.wezba1.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImp implements LocationService {

    private final LocationRepository inMemoryLocationRepository;
    public LocationServiceImp(LocationRepository repository) {
        this.inMemoryLocationRepository = repository;
    }
    @Override
    public List<Location> findAll() {
        return inMemoryLocationRepository.findAll();
    }

    @Override
    public Optional<Location> findById(Long id) {
        return inMemoryLocationRepository.findById(id);
    }

}
