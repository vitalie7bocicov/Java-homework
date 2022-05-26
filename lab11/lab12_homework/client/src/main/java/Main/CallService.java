package Main;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author vital
 */
@RestController
@RequestMapping("/call")
public class CallService {

    final String uri = "http://localhost:8090/";

    @GetMapping("/influencers/{id}")
    public List<String> getInfluencers(@PathVariable int id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<String>> response = restTemplate.exchange(
                uri + "/influencers/" + id, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<String>>() {
        });
        List<String> result = response.getBody();
        return result;
    }

    @GetMapping("/friends")
    public Map<String, List<User>> getFriends() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map<String, List<User>>> response = restTemplate.exchange(
                uri + "/friends", HttpMethod.GET, null,
                new ParameterizedTypeReference<Map<String, List<User>>>() {
        });
        Map<String, List<User>> result = response.getBody();
        return result;
    }

    @PostMapping("/friends")
    public ResponseEntity<String> createFriendship(@RequestParam int userId, @RequestParam int friendId) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                uri + "/friends?userId=" + userId + "&friendId=" + friendId, HttpMethod.POST, null,
                new ParameterizedTypeReference<String>() {
        });
        return response;
    }
}
