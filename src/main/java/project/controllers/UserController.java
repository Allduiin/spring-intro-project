package project.controllers;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.UserResponseDto;
import project.model.User;
import project.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/inject")
    public String inject() {
        userService.add(new User("Bob", "1234"));
        userService.add(new User("Alisa", "1234"));
        userService.add(new User("Bogdan", "1234"));
        userService.add(new User("Vasa", "1234"));
        return "Users was injected";
    }

    @RequestMapping("/{userId}")
    public UserResponseDto get(@PathVariable Long userId) {
        return getUserDto(userService.getById(userId));
    }

    @RequestMapping("/")
    public List<UserResponseDto> getAll() {
        return userService.getAll()
                .stream()
                .map(this::getUserDto)
                .collect(Collectors.toList());
    }

    private UserResponseDto getUserDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setEmail(user.getEmail());
        return userResponseDto;
    }
}
