package main;

import java.util.ArrayList;
import java.util.List;
import model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vital
 */
@RestController
@RequestMapping("/users")
public class UserController {
    
    private final List<User> users = new ArrayList<>();
    
    public UserController() {
        users.add(new User("mark"));
        users.add(new User("carl"));
    }
    
    @GetMapping
    public List<User> getProducts() {
        return users;
    }
    
    @GetMapping("/count")
    public int countProducts() {
        return users.size();
    }
    
    @GetMapping("/{name}")
    public User getProduct(@PathVariable("name") String name) {
        return users.stream()
                .filter(p -> p.getName().equals(name)).findFirst().orElse(null);
    }
}
