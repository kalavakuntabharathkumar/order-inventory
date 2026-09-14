package com.example.orderservice;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/orders")
public class OrderController {
  private final OrderRepository repo;
  public OrderController(OrderRepository repo) { this.repo=repo; }
  @GetMapping public List<Order> all() { return repo.findAll(); }
  @PostMapping public Order create(@RequestBody Order value) { return repo.save(value); }
}
