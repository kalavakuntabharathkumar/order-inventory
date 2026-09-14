package com.example.inventoryservice;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/inventory")
public class InventoryItemController {
  private final InventoryItemRepository repo;
  public InventoryItemController(InventoryItemRepository repo) { this.repo=repo; }
  @GetMapping public List<InventoryItem> all() { return repo.findAll(); }
  @PostMapping public InventoryItem create(@RequestBody InventoryItem value) { return repo.save(value); }
}
