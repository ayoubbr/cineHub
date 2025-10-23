package ma.youcode.service;

import ma.youcode.model.Category;

import java.util.List;

public interface CategoryService {
    Category save(Category category);
    Category update(Category category);
    void delete(Long id);
    Category findById(Long id);
    List<Category> findAll();
}
