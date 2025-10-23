package ma.youcode.controller;

import ma.youcode.model.Film;
import ma.youcode.service.FilmService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @PostMapping
    public ResponseEntity<Film> create(@RequestBody Film film) {
        return ResponseEntity.status(HttpStatus.CREATED).body(filmService.create(film));
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        filmService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
