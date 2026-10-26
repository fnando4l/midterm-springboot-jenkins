package com.fernand.devops;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloController {
    @GetMapping("/")
    public String home() { return "Hello from my Spring Boot Jenkins project!"; }
    @GetMapping("/health")
    public Map<String, String> health() { return Map.of("status", "UP"); }
}
