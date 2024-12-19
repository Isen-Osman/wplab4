package mk.finki.ukim.mk.wezba1.service;

import mk.finki.ukim.mk.wezba1.model.Event;
import mk.finki.ukim.mk.wezba1.model.EventBooking;

import java.util.Optional;

public interface EventBookingService {

    EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, long numberOfTickets);

    Optional<EventBooking> findById(Long id);
}
