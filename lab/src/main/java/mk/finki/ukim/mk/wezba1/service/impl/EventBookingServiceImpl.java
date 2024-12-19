package mk.finki.ukim.mk.wezba1.service.impl;

import mk.finki.ukim.mk.wezba1.model.Event;
import mk.finki.ukim.mk.wezba1.model.EventBooking;
import mk.finki.ukim.mk.wezba1.repository.impl.InMemoryEventRepository;
import mk.finki.ukim.mk.wezba1.repository.jpa.EventBookingRepository;
import mk.finki.ukim.mk.wezba1.service.EventBookingService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EventBookingServiceImpl implements EventBookingService {

    private final EventBookingRepository eventRepository;

    public EventBookingServiceImpl(EventBookingRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, long numberOfTickets) {



        EventBooking eventBooking = new EventBooking(eventName, attendeeName, attendeeAddress, numberOfTickets);

        eventRepository.save(eventBooking);
        return eventBooking;

//        if (optionalEvent.isPresent()) {
//            Event event = optionalEvent.get();
//
//            if (event.getAvalivableTickets() >= numberOfTickets) {
//
//                event.setAvalivableTickets(event.getAvalivableTickets() - numberOfTickets);
//
//                return new EventBooking(eventName, attendeeName, attendeeAddress, (long) numberOfTickets);
//
//            } else {
//                throw new IllegalArgumentException("Nema dovolno karti za ovoj nastan");
//            }
//        } else {
//            throw new NoSuchElementException("Event not found: " + eventName);
//        }

    }

    @Override
    public Optional<EventBooking> findById(Long id) {
        return eventRepository.findById(id);
    }

}
