package mk.finki.ukim.mk.wezba1.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.finki.ukim.mk.wezba1.model.Category;
import mk.finki.ukim.mk.wezba1.model.Event;
import mk.finki.ukim.mk.wezba1.model.EventBooking;
import mk.finki.ukim.mk.wezba1.model.Location;
import mk.finki.ukim.mk.wezba1.service.CategoryService;
import mk.finki.ukim.mk.wezba1.service.EventBookingService;
import mk.finki.ukim.mk.wezba1.service.EventService;
import mk.finki.ukim.mk.wezba1.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/events")
public class EventController {
    // Поле за сервисите за настани, локации и резервации
    private final EventService eventService;
    private final LocationService locationService;
    private final EventBookingService eventBookingService;
    private final CategoryService categoryService;
    // Конструктор кој ги иницијализира сервисите


    public EventController(EventService eventService, LocationService locationService, EventBookingService eventBookingService, CategoryService categoryService) {
        this.eventService = eventService;
        this.locationService = locationService;
        this.eventBookingService = eventBookingService;
        this.categoryService = categoryService;
    }

    // TODO ALL EVENTS
    @GetMapping
    public String getEventsPage(@RequestParam(required = false) String error, Model model) {

        // //Dodavanje na site nastani vo modelot
        model.addAttribute("events", eventService.listAll());

        //prikaz na newEvents.html
        return "newEvents";
    }

    //TODO DELETE
    @DeleteMapping("/delete/{eventId}")
    public String deleteEvent(@PathVariable Long eventId) {
        this.eventService.deleteById(eventId); // Brise nastanot so toj ID
        System.out.println("Event with ID " + eventId + " deleted");
        return "redirect:/events"; // prenaso
    }


    // TODO EDIT
    @GetMapping("/edit-event/{id}")
    public String editEventPage(@PathVariable Long id, Model model) {
        // Proveruva dali postoi nastanot so toj ID
        if (this.eventService.findById(id).isPresent()) {
            //Go dobiva nastanot
            Event event = eventService.findById(id).get();
            //Go dodavame nastanot vo modelot
            model.addAttribute("event", event);
            //Gi dodavame site lokacii na formata edit
            model.addAttribute("locations", locationService.findAll());
            //prikaz na add-event stranata
            model.addAttribute("categories",categoryService.findAll());
            return "add-event";
        }
        //prenasocuvanje ako nastanot ne e najden
        return "redirect:/events?errorEventNotFound";
    }

    // TODO ADD BUTTON
    @GetMapping("event/add")
    public String addEventPage(@RequestParam(required = false) String error,Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);

        }

        //gi dodava site lokacii na modelot
        model.addAttribute("locations", locationService.findAll());
        //gi dodava site nastani vo modelot
        model.addAttribute("events", eventService.listAll());

        model.addAttribute("categories",categoryService.findAll());
        //ja prikazuva add-event stranata

        return "add-event";
    }


    // TODO UPDATE OR ADD NEW EVENT
    @PostMapping("/add")
    public String addEvent(@RequestParam(required = false) Long id,
                           @RequestParam String name,
                           @RequestParam String description,
                           @RequestParam Double popularity,
                           @RequestParam Long locationId,
                           @RequestParam Long categoryId
    ) {
        if (id != null) {
            this.eventService.update(id, name, description, popularity, locationId, categoryId);
        }else{
            this.eventService.save(name, description, popularity, locationId,categoryId);
        }
        return "redirect:/events";
    }

     //TODO SEARCH EVENT
    @PostMapping("/searchEvent")
    public String listEvents(@RequestParam Long locationId, Model model) {
        // Primenuva nastani spored imeto i raitingot
        List<Event> filter = eventService.findAllByLocation_Id(locationId);
        //gi dodava filtriranite nastani
       model.addAttribute("events", filter);
        //prikaz na glavnata strana
        return "newEvents";
    }

    //TODO BUTTON DETAILS
  @GetMapping("/details/{id}")
    public String detailsPage( @PathVariable Long id,Model model) {

        //proveruva dali nastanot postoi vo DataHolder
        if (this.eventService.findById(id).isPresent()) {
            //ako nastanot postoi go zema toj objekt od DataHolder
            Event event = eventService.findById(id).get();
            //go dodava event za modelot za da prikaze detalite na eventot
            model.addAttribute("event", event);
            // details.html
            return "details";
        }
        //ako nepostoi so dadenoto ID go prenasocuva kon listata na nastani
        return "redirect:/events";
  }
}
