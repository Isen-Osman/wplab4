//package mk.finki.ukim.mk.wezba1.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.finki.ukim.mk.wezba1.service.EventService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//@WebServlet
//public class EventListServlet extends HttpServlet {
//
//    private final EventService eventService;
//    private final SpringTemplateEngine springTemplateEngine;
//
//    public EventListServlet(EventService eventService, SpringTemplateEngine springTemplateEngine) {
//        this.eventService = eventService;
//        this.springTemplateEngine = springTemplateEngine;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp);
//        WebContext webContext = new WebContext(webExchange);
//
//        webContext.setVariable("events", eventService.listAll());
//
//        springTemplateEngine.process("listEvent.html", webContext, resp.getWriter());
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//          String name = req.getParameter("name");
//          String category = req.getParameter("category");
//
//          if (!name.isEmpty()){
//              double rating = Double.parseDouble(req.getParameter("rating"));
//              req.getSession().setAttribute("eventList", eventService.searchEvents(name, (long) rating));
//              resp.sendRedirect("/");
//          }
//    }
//}
