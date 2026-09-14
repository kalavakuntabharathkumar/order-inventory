package com.example.notificationservice;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
@RestController @RequestMapping("/api/notifications")
public class NotificationController {
 @PostMapping public Map<String,Object> notify(@RequestBody Map<String,Object> event) {
   return Map.of("status","accepted","event",event);
 }
}
