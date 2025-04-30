package org.example.lovecampus.Serve;


import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import org.example.lovecampus.Mapper.EmailMapper;
import org.example.lovecampus.email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * 邮件业务类
 * @author qzz
 */
@Service
public class MailService {
    @Autowired
    private EmailMapper emailMapper;
    public void sendEmail(email email){
int randomNum =suiji();
        String content = String.format(
                "<h3>您的验证码是: <span style='color:red;'>%s</span></h3>" +
                        "<p>验证码5分钟内有效，请勿泄露给他人。</p>",
                randomNum
        );
        MailAccount mailAccount = new MailAccount();
        mailAccount.setHost("smtp.qq.com");
        mailAccount.setFrom("1830225455@qq.com");
        mailAccount.setPass("fiyymlbbhmcfchfh");
        mailAccount.setUser("1830225455");
        mailAccount.setPort(465);
        mailAccount.setAuth(true);
        mailAccount.setSslEnable(true);
            MailUtil.send(mailAccount,email.getEmail(), "测试", content, true);
       emailMapper.InsertEmail(new email(email.getId(),email.getEmail(),randomNum));
    }
    static int suiji(){
        Random random = new Random();
        int randomNum = random.nextInt(9999)+1;
        return randomNum;
    };
}

