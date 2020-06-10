package project.service;

import java.util.List;
import project.model.User;

public interface UserService {
    User add(User user);

    User findByEmail(String email);

    List<User> getAll();

    User getById(Long id);
}
