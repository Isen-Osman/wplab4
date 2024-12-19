//package mk.finki.ukim.mk.wezba1.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.finki.ukim.mk.wezba1.model.EventBooking;
//import mk.finki.ukim.mk.wezba1.service.EventBookingService;
//import mk.finki.ukim.mk.wezba1.service.impl.EventBookingServiceImpl;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//@WebServlet(name = "eventBook" ,urlPatterns = "/eventBooking")
//public class EventBookingServlet extends HttpServlet {
//    private final EventBookingService eventBookingService;
//    private final SpringTemplateEngine springTemplateEngine;
//
//    public EventBookingServlet(EventBookingService eventBookingService, SpringTemplateEngine springTemplateEngine) {
//        this.eventBookingService = eventBookingService;
//        this.springTemplateEngine = springTemplateEngine;
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp);
//
//        WebContext context = new WebContext(webExchange);
//        String name = "Isen Osman";
//        String ipAddress = req.getRemoteAddr();
//        String numTickets =req.getParameter("numTickets");
//        String eventName = req.getParameter("eventName");
//
//
//        EventBooking booking = eventBookingService.placeBooking(eventName,name,ipAddress,Integer.parseInt(numTickets));
//        context.setVariable("booking",booking);
//        springTemplateEngine.process("bookingConfirmation.html", context, resp.getWriter());
//    }
//}
//
