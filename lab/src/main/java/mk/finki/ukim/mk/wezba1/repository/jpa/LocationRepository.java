package mk.finki.ukim.mk.wezba1.repository.jpa;

import mk.finki.ukim.mk.wezba1.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    public Optional<Location> findById(Long id);
}

