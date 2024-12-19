package mk.finki.ukim.mk.wezba1.service;

import mk.finki.ukim.mk.wezba1.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

   List<Category> findAll();
   Optional<Category> findById(long id);
}
