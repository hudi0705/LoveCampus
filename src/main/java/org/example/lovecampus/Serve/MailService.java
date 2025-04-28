package org.example.lovecampus.Serve;


import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Properties;
/**
 * 邮件业务类
 * @author qzz
 */
@Service
public class MailService {

    public void sendEmail(){

        MailAccount mailAccount = new MailAccount();
        mailAccount.setHost("smtp.qq.com");
        mailAccount.setFrom("1830225455@qq.com");
        mailAccount.setPass("fiyymlbbhmcfchfh");
        mailAccount.setUser("1830225455");
        mailAccount.setPort(465);
        mailAccount.setAuth(true);
        mailAccount.setSslEnable(true);

        for (int i = 0; i < 10; i++) {
            MailUtil.send(mailAccount,"1954558835@qq.com", "测试", "<a href='www.baidu.com'><h1 style='color:pink;'>小美女</h1></a>", true);
        }
    }

}

