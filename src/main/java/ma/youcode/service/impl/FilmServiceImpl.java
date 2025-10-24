package ma.youcode.service.impl;

import ma.youcode.exception.NotFoundException;
import ma.youcode.model.Category;
import ma.youcode.model.Director;
import ma.youcode.model.Film;
import ma.youcode.repository.CategoryRepository;
import ma.youcode.repository.DirectorRepository;
import ma.youcode.repository.FilmRepository;
import ma.youcode.service.FilmService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepo;
    private final DirectorRepository directorRepo;
    private final CategoryRepository categoryRepo;

    public FilmServiceImpl(FilmRepository filmRepo,
                           DirectorRepository directorRepo, CategoryRepository categoryRepo) {
        this.filmRepo = filmRepo;
        this.directorRepo = directorRepo;
        this.categoryRepo = categoryRepo;
    }

    public Film create(Film film) {
        film.validateBusinessRules();
        Director d = directorRepo.findById(film.getDirector().getIdDirector())
                .orElseThrow(() -> new NotFoundException("Director not found"));
        Category c = categoryRepo.findById(film.getCategory().getIdCategory())
                .orElseThrow(() -> new NotFoundException("Category not found"));
        film.setDirector(d);
        film.setCategory(c);
        return filmRepo.save(film);
    }

    public Film update(Long id, Film film) {
        Film existing = findById(id);
        existing.setTitle(film.getTitle());
        existing.setDuration(film.getDuration());
        existing.setReleaseYear(film.getReleaseYear());
        existing.setRating(film.getRating());
        existing.setSynopsis(film.getSynopsis());
        existing.validateBusinessRules();
        return filmRepo.save(existing);
    }

    public void delete(Long id) {
        Film f = findById(id);
        filmRepo.delete(f);
    }

    public Film findById(Long id) {
        return filmRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Film not found"));
    }

    public List<Film> search(String title, Integer year, String category) {
        if (title != null) return filmRepo.findByTitleContainingIgnoreCase(title);
        if (year != null) return filmRepo.findByReleaseYear(year);
        if (category != null) return filmRepo.findByCategory_Name(category);
        return filmRepo.findAll();
    }
}
