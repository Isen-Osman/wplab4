package mk.finki.ukim.mk.wezba1.repository.impl;

import mk.finki.ukim.mk.wezba1.boostrap.DataHolder;
import mk.finki.ukim.mk.wezba1.model.Category;
import mk.finki.ukim.mk.wezba1.model.Event;
import mk.finki.ukim.mk.wezba1.model.Location;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryEventRepository {

    public List<Event> findAll(){
        return DataHolder.eventList;
    }

    public List<Event> searchEvent(String text,long number){
        return  DataHolder.eventList.stream().filter(event -> event.getName().equals(text) && event.getPopularityScore() <= number).toList();
    }

    public Optional<Event> findById(long id){
        return DataHolder.eventList.stream().filter(event -> event.getId() == id).findFirst();
    }

    public Optional<Event> findByName(String name){
        return DataHolder.eventList.stream().filter(event -> event.getName().equals(name)).findFirst();
    }

    public void deleteById(long id){
        DataHolder.eventList.removeIf(event -> event.getId() == id);
    }

    public Optional<Event> saveOrUpdate(String name, String description, double popularityScore, Location location, Category category){

        DataHolder.eventList.removeIf(event -> event.getName().equals(name));
        Event event = new Event(name, description, popularityScore, location,category);
        DataHolder.eventList.add(event);
        return Optional.of(event);
    }

}
