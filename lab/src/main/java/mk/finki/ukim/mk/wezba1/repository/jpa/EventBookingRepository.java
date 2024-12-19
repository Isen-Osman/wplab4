package mk.finki.ukim.mk.wezba1.repository.jpa;

import mk.finki.ukim.mk.wezba1.model.EventBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventBookingRepository extends JpaRepository<EventBooking, Long> {
    Optional<EventBooking> findById(Long id);
}
