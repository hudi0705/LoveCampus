package org.example.lovecampus.Contorlle;

import org.example.lovecampus.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping
public class userContorlle {
    @Autowired
private org.example.lovecampus.Serve.usersServe usersServe;
    @GetMapping("/users")
    public ResponseEntity<?> getUsers(@RequestParam(required = false) String username) {
        if (username != null) {
            // 根据 id 查询单个用户
            users user = usersServe.getuser(username);
            return ResponseEntity.ok(user);
        } else {
            // 查询所有用户
            List<users> users = usersServe.getUsers();
            return ResponseEntity.ok(users);
        }
    }



 @PostMapping("/postuser")
public ResponseEntity<?> addUser(@RequestBody users user) {
     try {
         int result = usersServe.adduser(user);
         if (result > 0) {
             // 返回插入后的用户对象（包含自增 id）
             return ResponseEntity.ok(user);
         } else {
             return ResponseEntity.badRequest().body("插入用户失败")   ;
         }
     } catch (Exception e) {
         return ResponseEntity.internalServerError().body("服务器错误: " + e.getMessage());
     }
 }
}
