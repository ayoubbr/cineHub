package ma.youcode.controller;

import ma.youcode.model.Category;
import ma.youcode.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.save(category));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> get(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<Category>> list() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable Long id, @RequestBody Category categoryDetails) {
        Category existingCategory = categoryService.findById(id);

        if (existingCategory == null) {
            return ResponseEntity.notFound().build();
        }

        existingCategory.setName(categoryDetails.getName());
        existingCategory.setDescription(categoryDetails.getDescription());
        Category updatedCategory = categoryService.save(existingCategory);
        return ResponseEntity.ok(updatedCategory);
    }
}
