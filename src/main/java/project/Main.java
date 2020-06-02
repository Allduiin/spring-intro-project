package project;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import project.config.AppConfig;
import project.model.User;
import project.service.UserService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.add(new User("Bob", "1234"));
        userService.add(new User("Alisa", "1234"));
        userService.add(new User("Bogdan", "1234"));
        userService.add(new User("Vasa", "1234"));

        userService.getAll().forEach(user -> System.out.println(user.toString()));
    }
}
