package com.jdangar.rest.webservices.restful_web_services.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    private UserDaoService userDaoService;

    public UserResource(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers() {
        return userDaoService.getUsers();
    }

    @GetMapping(path = "/users/{id}")
    public User retrieveUser(@PathVariable Integer id) {
        User user = userDaoService.findUser(id);

        if (user == null) {
            throw new UserNotFoundException("id:" + id);
        }

        return user;
    }

    @PostMapping(path = "/users")
    public ResponseEntity<Object> saveUser(@RequestBody User user) {
        User savedUser = userDaoService.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@PathVariable int id){
        User user = userDaoService.delete(id);

        if (user == null){
            throw new UserNotFoundException("id: "+id);
        }
    }
}
