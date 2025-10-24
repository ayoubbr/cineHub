package ma.youcode.service; // Or create a new 'mapper' package

import ma.youcode.dto.*;
import ma.youcode.model.*;
import org.springframework.stereotype.Service;

@Service
public class FilmMapper {

    // --- CONVERT DTO TO ENTITY (For incoming requests) ---
    public Film toEntity(FilmRequestDTO dto, Director director, Category category) {
        Film film = new Film();
        film.setTitle(dto.getTitle());
        film.setReleaseYear(dto.getReleaseYear());
        film.setDuration(dto.getDuration());
        film.setSynopsis(dto.getSynopsis());
        film.setRating(dto.getRating());

        // Set relationships using the fully loaded entities
        film.setDirector(director);
        film.setCategory(category);
        return film;
    }

    // --- CONVERT ENTITY TO DTO (For outgoing responses) ---
    public FilmResponseDTO toResponseDTO(Film film) {
        FilmResponseDTO dto = new FilmResponseDTO();
        dto.setIdFilm(film.getIdFilm());
        dto.setTitle(film.getTitle());
        dto.setReleaseYear(film.getReleaseYear());
        dto.setDuration(film.getDuration());
        dto.setSynopsis(film.getSynopsis());
        dto.setRating(film.getRating());

        // Map related entities to their Response DTOs
        dto.setDirector(mapDirector(film.getDirector()));
        dto.setCategory(mapCategory(film.getCategory()));
        return dto;
    }

    private DirectorResponseDTO mapDirector(Director director) {
        DirectorResponseDTO dto = new DirectorResponseDTO();
        dto.setIdDirector(director.getIdDirector());
        dto.setFirstName(director.getFirstName());
        dto.setLastName(director.getLastName());
        return dto;
    }

    private CategoryResponseDTO mapCategory(Category category) {
        CategoryResponseDTO dto = new CategoryResponseDTO();
        dto.setIdCategory(category.getIdCategory());
        dto.setName(category.getName());
        return dto;
    }
}