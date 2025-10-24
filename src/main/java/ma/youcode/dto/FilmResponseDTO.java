package ma.youcode.dto;

public class FilmResponseDTO {
    private Long idFilm;
    private String title;
    private Integer releaseYear;
    private Integer duration;
    private String synopsis;
    private Double rating;

    // Simplified, non-circular representations
    private DirectorResponseDTO director;
    private CategoryResponseDTO category;



    public Long getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(Long idFilm) {
        this.idFilm = idFilm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public DirectorResponseDTO getDirector() {
        return director;
    }

    public void setDirector(DirectorResponseDTO director) {
        this.director = director;
    }

    public CategoryResponseDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryResponseDTO category) {
        this.category = category;
    }
}
