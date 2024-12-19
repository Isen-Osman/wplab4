package mk.finki.ukim.mk.wezba1.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;


    @OneToMany(mappedBy = "category")
    private List<Event> events;

    public Category( String name, String description) {
        this.name = name;
        this.description = description;

    }

    public Category() {

    }
}
