package mk.finki.ukim.mk.wezba1.repository.jpa;

import mk.finki.ukim.mk.wezba1.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    public Optional<Category> findById(Long id);

    public Optional<Category> findAllByName(String name);

}
