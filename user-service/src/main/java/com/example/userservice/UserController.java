package com.example.userservice;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/users")
public class UserController {
  private final UserRepository repo;
  public UserController(UserRepository repo) { this.repo=repo; }
  @GetMapping public List<User> all() { return repo.findAll(); }
  @PostMapping public User create(@RequestBody User value) { return repo.save(value); }
}
