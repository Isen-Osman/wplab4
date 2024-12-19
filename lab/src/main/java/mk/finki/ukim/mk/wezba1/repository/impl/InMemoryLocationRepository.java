package mk.finki.ukim.mk.wezba1.repository.impl;

import mk.finki.ukim.mk.wezba1.boostrap.DataHolder;
import mk.finki.ukim.mk.wezba1.model.Location;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryLocationRepository {
    public List<Location> findAll(){
        return DataHolder.locationList;
    }



}
