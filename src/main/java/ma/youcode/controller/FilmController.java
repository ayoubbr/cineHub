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
import java.util.stream.Collectors;

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
    public ResponseEntity<List<FilmResponseDTO>> list() {
        List<Film> films = filmService.findAll();
        List<FilmResponseDTO> responseDTOs = films.stream()
                .map(filmMapper::toResponseDTO)
                .toList();

        return ResponseEntity.ok(responseDTOs);
    }

    @GetMapping("/search")
    public ResponseEntity<List<FilmResponseDTO>> list(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) String category) {
        List<Film> films = filmService.search(title, year, category);
        List<FilmResponseDTO> responseDTOs = films.stream()
                .map(filmMapper::toResponseDTO)
                .toList();

        return ResponseEntity.ok(responseDTOs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmResponseDTO> update(@PathVariable Long id, @RequestBody FilmRequestDTO filmDto) {
        Director director = directorService.findById(filmDto.getDirector().getIdDirector());
        Category category = categoryService.findById(filmDto.getCategory().getIdCategory());

        // 2. Map DTO to Entity
        Film filmToUpdate = filmMapper.toEntity(filmDto, director, category);

        // 3. Save the entity
        Film updatedFilm = filmService.update(id, filmToUpdate);

        // 4. Map the saved Entity back to a Response DTO
        FilmResponseDTO response = filmMapper.toResponseDTO(updatedFilm);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        filmService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
