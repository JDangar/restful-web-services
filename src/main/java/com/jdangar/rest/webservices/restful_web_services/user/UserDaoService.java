package com.jdangar.rest.webservices.restful_web_services.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private static int userCount = 0;

    static {
        users.add(new User(++userCount,"Jim", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount,"Pam", LocalDate.now().minusYears(28)));
        users.add(new User(++userCount,"Carry", LocalDate.now().minusYears(25)));
    }

    public List<User> getUsers() {
        return users;
    }

    public void save(User user) {
        user.setId(++userCount);
        users.add(user);
    }

    public User findUser(Integer id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().get();
    }
}
