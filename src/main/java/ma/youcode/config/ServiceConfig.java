package ma.youcode.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"ma.youcode.service"}) // Scan for @Service
public class ServiceConfig {
}
