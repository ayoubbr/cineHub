package ma.youcode.controller;

import ma.youcode.dto.FilmRequestDTO;
import ma.youcode.dto.FilmResponseDTO;
import ma.youcode.model.Category;
import ma.youcode.model.Director;
import ma.youcode.model.Film;
import ma.youcode.service.CategoryService;
import ma.youcode.service.DirectorService;
import ma.youcode.service.FilmMapper;
import ma.youcode.service.FilmService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {

    private final FilmService filmService;
    private final DirectorService directorService; // Assume you have this
    private final CategoryService categoryService; // Assume you have this
    private final FilmMapper filmMapper;


    public FilmController(FilmService fs, DirectorService ds, CategoryService cs, FilmMapper fm) {
        this.filmService = fs;
        this.directorService = ds;
        this.categoryService = cs;
        this.filmMapper = fm;
    }

    @PostMapping
    public ResponseEntity<FilmResponseDTO> create(@RequestBody FilmRequestDTO filmDto) {
        Director director = directorService.findById(filmDto.getDirector().getIdDirector());
        Category category = categoryService.findById(filmDto.getCategory().getIdCategory());

        // 2. Map DTO to Entity
        Film filmToSave = filmMapper.toEntity(filmDto, director, category);

        // 3. Save the entity
        Film savedFilm = filmService.create(filmToSave);

        // 4. Map the saved Entity back to a Response DTO
        FilmResponseDTO response = filmMapper.toResponseDTO(savedFilm);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Film> get(@PathVariable Long id) {
        return ResponseEntity.ok(filmService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Film>> list(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) String category) {
        return ResponseEntity.ok(filmService.search(title, year, category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Film> update(@PathVariable Long id, @RequestBody Film film) {
        Film updatedFilm = filmService.update(id, film);
        return ResponseEntity.ok(updatedFilm);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        filmService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
