package ma.youcode.controller;

import ma.youcode.model.Greeting;
import ma.youcode.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService service;

    @Autowired
    public GreetingController(GreetingService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public ResponseEntity<Greeting> sayHello() {
        Greeting greeting = service.getHelloWorld();
        return ResponseEntity.ok(greeting);
    }
}