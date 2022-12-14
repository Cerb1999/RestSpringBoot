package masterIL.RestSpringBoot.user.web;

import masterIL.RestSpringBoot.user.model.User;
import masterIL.RestSpringBoot.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Value("${me}")
    private String me;

    @GetMapping(value = "/Cestqui")
    public String getName() {
        return me;
    }

    @GetMapping(value = "/users")
    public List<User> getAllUsers() {
        return userService.listAllUsers();
    }

    @PostMapping(value = "/users")
    public User addUser(@RequestBody User u) {
        return userService.addUser(u);
    }

    @GetMapping(value = "/user/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getById(id);
    }

    @PatchMapping(value = "/user/{id}")
    public void updateUser(@PathVariable String id, @RequestBody User u) {
        userService.updateUser(id, u);
    }

    @GetMapping(value = "/users/{lastname}")
    public List<User> getUsersByLastName(@PathVariable String lastname) {
        return userService.listAllUsersByLastname(lastname);
    }

    @DeleteMapping(value = "/user/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.removeUser(id);
    }
}
