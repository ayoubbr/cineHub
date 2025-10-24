package ma.youcode.controller;

import ma.youcode.model.Director;
import ma.youcode.service.CategoryService;
import ma.youcode.service.DirectorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/directors")
public class DirectorController {

    private DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @PostMapping
    public ResponseEntity<Director> create(@RequestBody Director doctor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(directorService.create(doctor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Director> get(@PathVariable Long id) {
        return ResponseEntity.ok(directorService.findById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<Director>> list() {
        return ResponseEntity.ok(directorService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        directorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Director> update(@PathVariable Long id, @RequestBody Director doctorDetails) {
        Director updatedDirector = directorService.update(id, doctorDetails);
        return ResponseEntity.ok(updatedDirector);
    }
}
