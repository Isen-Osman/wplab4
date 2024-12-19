package mk.finki.ukim.mk.wezba1.boostrap;


import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.wezba1.model.Category;
import mk.finki.ukim.mk.wezba1.model.Event;
import mk.finki.ukim.mk.wezba1.model.Location;
import mk.finki.ukim.mk.wezba1.model.User;
import mk.finki.ukim.mk.wezba1.model.enumerations.Role;
import mk.finki.ukim.mk.wezba1.repository.jpa.CategoryRepository;
import mk.finki.ukim.mk.wezba1.repository.jpa.LocationRepository;
import mk.finki.ukim.mk.wezba1.repository.jpa.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Event> eventList = new ArrayList<>(10);
    public static List<Location> locationList = new ArrayList<>(10);
    public  static List<User> userList = new ArrayList<>(10);
    public  static List<Category> categoryList = new ArrayList<>(10);

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final LocationRepository locationRepository;
    private final PasswordEncoder passwordEncoder;

    public DataHolder(UserRepository userRepository, CategoryRepository categoryRepository, LocationRepository locationRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.locationRepository = locationRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //treba za sekoj event da ima broj na karti naprimer 90 i koga kje napravam bookingConfriamtion so 4 karti da se namali 86
    @PostConstruct
    public void init(){
//        Location location = new Location("USA","Los Angeles","30","Description for USA");
//        Location location2 = new Location("Russia","s","330","Description for Russia");
//        Location locatio3 = new Location("Japan","Japan","44","Description for Japan");
//
//        locationList.add(location);
//        locationList.add(location2);
//        locationList.add(locatio3);
//
//        eventList.add(new Event("Theater Play", "A night of drama and performances", 5,location));
//        eventList.add(new Event("Yoga Retreat", "A relaxing weekend retreat", 65,location2));
//        eventList.add(new Event("Charity Gala", "A gala dinner for charity", 54,locatio3));
//        eventList.add(new Event("Isen Movie","Night",12,location,55));

        if (this.userRepository.count() == 0) {
            userList.add(new User("isen",passwordEncoder.encode("isen"),"isen","osman", Role.ROLE_ADMIN));
            userList.add(new User("amir",passwordEncoder.encode("amir"),"amir","osman", Role.ROLE_USER));
            userRepository.saveAll(userList);
        }

        if (this.locationRepository.count() == 0) {
            locationList.add(new Location("Skopje", "Karpos 2", "120", "haha" ));
            locationList.add(new Location("Kumanovo", "kumanovoAdress","200", "haha" ));
            locationList.add(new Location("Veles", "velesadress", "250", "haha" ));
            locationRepository.saveAll(locationList);
        }

        if (categoryRepository.count() == 0) {
            categoryList.add(new Category("Fashion", "zara"));
            categoryList.add(new Category("Sport", "football"));
            categoryList.add(new Category("Education", "book"));
            categoryRepository.saveAll(categoryList);
        }
    }
}
