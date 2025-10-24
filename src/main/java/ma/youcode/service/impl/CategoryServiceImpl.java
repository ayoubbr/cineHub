package ma.youcode.service.impl;

import ma.youcode.model.Category;
import ma.youcode.repository.CategoryRepository;
import ma.youcode.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category save(Category category) {
        categoryRepository.save(category);
        return category;
    }

    @Override
    public Category update(Category category) {
        Optional<Category> existingCategory = categoryRepository.findById(category.getIdCategory());
        if (existingCategory.isPresent()) {
            Category updatedCategory = existingCategory.get();
            updatedCategory.setName(category.getName());
            updatedCategory.setDescription(category.getDescription());
            categoryRepository.save(updatedCategory);
            return updatedCategory;
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
