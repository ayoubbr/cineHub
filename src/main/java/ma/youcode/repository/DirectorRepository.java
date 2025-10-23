package ma.youcode.repository;

import ma.youcode.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DirectorRepository extends JpaRepository<Director, Long> {
    List<Director> findByFirstNameContainingIgnoreCase(String FirstName);

}
