package ma.youcode.dto;

public class FilmRequestDTO {
    private String title;
    private Integer releaseYear;
    private Integer duration;
    private String synopsis;
    private Double rating;

    // Nested DTOs/Objects for relationships
    private DirectorIdDTO director;
    private CategoryIdDTO category;


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

    public DirectorIdDTO getDirector() {
        return director;
    }

    public void setDirector(DirectorIdDTO director) {
        this.director = director;
    }

    public CategoryIdDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryIdDTO category) {
        this.category = category;
    }
}