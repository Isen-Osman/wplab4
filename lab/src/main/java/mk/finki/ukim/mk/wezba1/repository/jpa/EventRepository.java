package mk.finki.ukim.mk.wezba1.repository.jpa;

import jakarta.transaction.Transactional;
import mk.finki.ukim.mk.wezba1.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Optional<Event> findByName(String name);


    void deleteById(Long id);

    List<Event> findAllByLocation_Id(Long locationId);
}
