package mk.finki.ukim.mk.wezba1.service.impl;

import mk.finki.ukim.mk.wezba1.model.Category;
import mk.finki.ukim.mk.wezba1.repository.jpa.CategoryRepository;
import mk.finki.ukim.mk.wezba1.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(long id) {
        return categoryRepository.findById(id);
    }
}
