package ma.youcode.service;

import ma.youcode.model.Film;

import java.util.List;

public interface FilmService {
    Film create(Film film);
    Film update(Long id, Film film);
    void delete(Long id);
    Film findById(Long id);
    List<Film> findAll();
    List<Film> search(String title, Integer year, String category);
}
