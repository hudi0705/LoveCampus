package org.example.lovecampus.Contorlle;

import org.example.lovecampus.Serve.EmailServe;
import org.example.lovecampus.Serve.MailService;
import org.example.lovecampus.email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping// 建议使用复数形式作为路径
@CrossOrigin(origins="*")
public class EmailController { // 修正类名拼写

    @Autowired // 添加自动注入
    private EmailServe emailServe;

    @Autowired
    private MailService mailService;

    @GetMapping("/emails")
    public ResponseEntity<?> getEmail(@RequestParam(required = false) String email) {
        if (email != null) {
            // 根据 email 查询单个记录
            org.example.lovecampus.email email1 = emailServe.GetEmail(email); // 修正参数传递
            return ResponseEntity.ok(email1); // 返回查询结果
        } else {
            // 查询所有记录
            List<email> emails = emailServe.SelectEmail();
            return ResponseEntity.ok(emails);
        }
    }
    @GetMapping("/emailsleng")
    public ResponseEntity<?> getEmailleng() {

            // 查询所有记录
            List<email> emails = emailServe.SelectEmailleng();
            return ResponseEntity.ok(emails.size());
        }


    @PostMapping("/postemail")
    public ResponseEntity<?> addUser(@RequestBody email email) {
        try {
            int result = emailServe.addEmail(email);
            if (result > 0) {
                // 返回插入后的用户对象（包含自增 id）
                return ResponseEntity.ok(email);
            } else {
                return ResponseEntity.badRequest().body("插入用户失败");
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("服务器错误: " + e.getMessage());
        }
    }


    @GetMapping("/sendEmail")
    public void sendEmail() {
        mailService.sendEmail();
    }

}