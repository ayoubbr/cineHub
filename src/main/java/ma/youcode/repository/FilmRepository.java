package ma.youcode.repository;

import ma.youcode.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {
    List<Film> findByTitleContainingIgnoreCase(String title);
    List<Film> findByReleaseYear(Integer year);
    List<Film> findByCategory_Name(String categoryName);
}
