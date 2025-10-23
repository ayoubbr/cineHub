package ma.youcode.repository;

import ma.youcode.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<Greeting, Long> {
    // Spring Data JPA automatically provides methods like save, findById, findAll, etc.
}
