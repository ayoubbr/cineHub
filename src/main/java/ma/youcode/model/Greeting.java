package ma.youcode.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Greeting {
    @Id
    private Long id;
    private String message;
    private LocalDate creationDate;

    public Greeting() {
    }

    public Greeting(Long id, String message, LocalDate creationDate) {
        this.id = id;
        this.message = message;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}