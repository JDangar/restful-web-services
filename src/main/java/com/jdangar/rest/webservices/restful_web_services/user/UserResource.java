package com.jdangar.rest.webservices.restful_web_services.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {

    private UserDaoService userDaoService;

    public UserResource(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers(){
        return userDaoService.getUsers();
    }

    @GetMapping(path = "/users/{id}")
    public User retrieveUser(@PathVariable Integer id){
        return userDaoService.findUser(id);
    }

    @PostMapping(path = "/users")
    public void saveUser(@RequestBody User user){
        userDaoService.save(user);
    }
}
