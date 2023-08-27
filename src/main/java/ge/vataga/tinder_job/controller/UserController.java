package ge.vataga.tinder_job.controller;

import ge.vataga.tinder_job.entity.User;
import ge.vataga.tinder_job.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/get")
    public ResponseEntity<User> getUser(@RequestParam Integer userId) {
        User userById = userService.getUserById(userId);
        return ResponseEntity.ok(userById); // Создайте HTML-шаблон с формой добавления пользователя (например, add-user.html)
    }

    // Обработка отправки формы для добавления пользователя
    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        // Вызываем сервис для добавления пользователя
        userService.createUser(user.getUsername(), user.getPassword(), user.getName(), user.getRole(), user.getSkills());

        // Перенаправляем пользователя на страницу успешного добавления
        return ResponseEntity.ok("success");
    }
}
