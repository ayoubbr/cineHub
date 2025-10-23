package ma.youcode.service;

import ma.youcode.model.Greeting;
import ma.youcode.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
public class GreetingService {

    private final GreetingRepository repository;

    @Autowired
    public GreetingService(GreetingRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Greeting getHelloWorld() {
        // Simple logic: try to find the greeting with ID 1, create it if it doesn't exist.
        return repository.findById(1L).orElseGet(() -> {
            Greeting newGreeting = new Greeting(
                    1L,
                    "Hello World from Spring 6 REST API!",
                    LocalDate.now() // Uses Java Time API (LocalDate)
            );
            return repository.save(newGreeting);
        });
    }
}
