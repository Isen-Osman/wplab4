package mk.finki.ukim.mk.wezba1.service;

import mk.finki.ukim.mk.wezba1.model.Event;
import mk.finki.ukim.mk.wezba1.model.Location;

import java.util.List;
import java.util.Optional;

public interface EventService {
    List<Event> listAll();

    Optional<Event> findById(long id);

    Optional<Event> findByName(String name);

    void deleteById(long id);

    Optional<Event> save(String name, String description, double popularityScore, Long locationid,Long categoryid);

    Optional<Event> update(Long id, String name, String description, double popularityScore, Long locationid,Long categoryid);

    List<Event> findAllByLocation_Id(Long locationId);
}
