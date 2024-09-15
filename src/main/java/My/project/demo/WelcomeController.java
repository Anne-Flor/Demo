package My.project.demo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping
    public String welcome(){
        return "Welcome to my Spring Boot web API";
    }
    @GetMapping("/users")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public String users(){
        return "Authorized user";
    }
    @GetMapping("/managers")
    @PreAuthorize("hasRole('ADMIN')")
    public String managers(){
        return "Authorized manager";
    }
}
