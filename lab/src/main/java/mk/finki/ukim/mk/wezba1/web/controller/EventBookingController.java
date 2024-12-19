package mk.finki.ukim.mk.wezba1.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.finki.ukim.mk.wezba1.model.EventBooking;
import mk.finki.ukim.mk.wezba1.model.User;
import mk.finki.ukim.mk.wezba1.service.EventBookingService;
import mk.finki.ukim.mk.wezba1.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EventBookingController {

    private final EventBookingService eventBookingService;
    private final UserService userService;

    public EventBookingController(EventBookingService eventBookingService, UserService userService) {
        this.eventBookingService = eventBookingService;
        this.userService = userService;
    }

    // TODO EVENTBOOKING.HTMl
    @GetMapping("/eventBooking")
    public String showEventBookingPage( Model model) {

        return "eventBooking";
    }


    // TODO POST RESERVATION


    @PostMapping("/eventBooking")
    public String booking(@RequestParam String eventName,
                          @RequestParam(required = false) Long numTickets,
                          HttpServletRequest request,
                          Model model) {
        String username = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        String ipAddress = request.getLocalAddr();

        EventBooking booking = null;
        try {
            booking = eventBookingService.placeBooking(eventName, username, ipAddress, numTickets);
            model.addAttribute("booking", booking);

            return "bookingConfirmation";
        } catch (IllegalArgumentException e) {

            return "redirect:/events?error=NemaDovolnoKarti" ;
        }
    }

}
