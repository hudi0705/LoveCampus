package org.example.lovecampus.Contorlle;

import org.example.lovecampus.Serve.EmailServe;
import org.example.lovecampus.Serve.MailService;
import org.example.lovecampus.Entily.email;
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
//查询邮箱
    @GetMapping("/emails")
    public ResponseEntity<?> getEmail(@RequestParam(required = false) String email) {
        if (email != null) {
            // 根据 email 查询单个记录
            org.example.lovecampus.Entily.email email1 = emailServe.GetEmail(email); // 修正参数传递
            return ResponseEntity.ok(email1); // 返回查询结果
        } else {
            // 查询所有记录
            List<email> emails = emailServe.SelectEmail();
            return ResponseEntity.ok(emails);
        }
    }
//    查询邮箱人数
    @GetMapping("/emailsleng")
    public ResponseEntity<?> getEmailleng() {

            // 查询所有记录
            List<email> emails = emailServe.SelectEmailleng();
            return ResponseEntity.ok(emails.size());
        }

}