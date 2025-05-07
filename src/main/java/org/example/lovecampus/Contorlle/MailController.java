package org.example.lovecampus.Contorlle;

import org.example.lovecampus.Serve.EmailServe;
import org.example.lovecampus.Serve.MailService;
import org.example.lovecampus.Entily.email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping// 建议使用复数形式作为路径
@CrossOrigin(origins = "*")
public class MailController {
    @Autowired
    private MailService mailService;
    @Autowired // 添加自动注入
    private EmailServe emailServe;

    //    发送邮箱保存验证码
    @PostMapping("/sendEmail")
    public String sendEmail(@RequestBody email email) {
        mailService.sendEmail(email);
        return "发送成功";
    }

    @PostMapping("/yzEmail")
    public String yzEmail(@RequestBody email email) {
        mailService.yzEmail(email);
        return "验证成功";
    }
    @PostMapping("/DeleteEmail")
    public String DeleteEmail(@RequestBody email email) {
mailService.DeleteEmail(email);
return "执行成功";
    }

//测试测试
}
