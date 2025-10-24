package ma.youcode.service;

import ma.youcode.model.Director;

import java.util.List;

public interface DirectorService {
    Director create(Director director);
    Director update(Long id, Director director);
    void delete(Long id);
    Director findById(Long id);
    List<Director> findAll();
}
