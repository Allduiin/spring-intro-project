package project.dao;

import java.util.List;
import java.util.Optional;
import project.model.User;

public interface UserDao {
    User add(User user);

    Optional<User> findByEmail(String email);

    List<User> getAll();
}
