package org.example.lovecampus.Serve;


import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import org.example.lovecampus.Mapper.EmailMapper;
import org.example.lovecampus.Entily.email;
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
        String content = "<div style=\"max-width: 600px; margin: 0 auto; padding: 20px; font-family: Arial, sans-serif; background-color: #f8f9fa; border-radius: 10px;\">" +
                "<div style=\"text-align: center; padding: 20px; background-color: #4CAF50; border-radius: 8px 8px 0 0;\">" +
                "<h1 style=\"color: white; margin: 0; font-size: 24px;\">🎉 欢迎加入 恋与校园 🎉</h1>" +
                "</div>" +
                "<div style=\"padding: 30px; background-color: white; border-radius: 0 0 8px 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1);\">" +
                "<p style=\"font-size: 16px; color: #333; line-height: 1.6;\">亲爱的用户：</p>" +
                "<p style=\"font-size: 16px; color: #333; line-height: 1.6;\">感谢您注册 SevenMusic！您的验证码是：</p>" +
                "<div style=\"background-color: #f8f9fa; padding: 15px; border-radius: 5px; text-align: center; margin: 20px 0;\">" +
                "<span style=\"font-size: 24px; font-weight: bold; color: #4CAF50; letter-spacing: 5px;\">" + randomNum + "</span>" +
                "</div>" +
                "<p style=\"font-size: 14px; color: #666; line-height: 1.6;\">验证码有效期为5分钟，请尽快完成注册。</p>" +
                "<div style=\"margin-top: 30px; padding-top: 20px; border-top: 1px solid #eee;\">" +
                "<p style=\"font-size: 14px; color: #666; margin: 0;\">祝您使用愉快！</p>" +
                "<p style=\"font-size: 14px; color: #666; margin: 5px 0 0 0;\">SevenMusic 团队</p>" +
                "</div>" +
                "</div>" +
                "</div>";
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
    public void yzEmail(email email){
        String successContent = "<div style=\"max-width: 600px; margin: 0 auto; padding: 20px; font-family: Arial, sans-serif; background-color: #f8f9fa; border-radius: 10px;\">" +
                "<div style=\"text-align: center; padding: 20px; background-color: #4CAF50; border-radius: 8px 8px 0 0;\">" +
                "<h1 style=\"color: white; margin: 0; font-size: 24px;\">🎉 注册成功 🎉</h1>" +
                "</div>" +
                "<div style=\"padding: 30px; background-color: white; border-radius: 0 0 8px 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1);\">" +
                "<p style=\"font-size: 16px; color: #333; line-height: 1.6;\">亲爱的用户：</p>" +
                "<p style=\"font-size: 16px; color: #333; line-height: 1.6;\">恭喜您已成功注册恋与校园！</p>" +
                "<div style=\"text-align: center; margin: 20px 0;\">" +
                "<span style=\"font-size: 60px; color: #4CAF50;\">✓</span>" +
                "</div>" +
                "<p style=\"font-size: 16px; color: #333; line-height: 1.6;\">现在您可以：</p>" +
                "<ul style=\"font-size: 15px; color: #333; line-height: 1.6; padding-left: 20px;\">" +
                "<li>完善个人资料</li>" +
                "<li>浏览校园动态</li>" +
                "<li>结识志同道合的朋友</li>" +
                "</ul>" +
                "<div style=\"margin-top: 30px; padding-top: 20px; border-top: 1px solid #eee;\">" +
                "<p style=\"font-size: 14px; color: #666; margin: 0;\">如有任何问题，请联系客服。</p>" +
                "<p style=\"font-size: 14px; color: #666; margin: 5px 0 0 0;\">恋与校园团队</p>" +
                "</div>" +
                "</div>" +
                "</div>";
        boolean b = email.getCode() == emailMapper.GetCode(email.getEmail());
        if(b){
            MailAccount mailAccount = new MailAccount();
            mailAccount.setHost("smtp.qq.com");
            mailAccount.setFrom("1830225455@qq.com");
            mailAccount.setPass("fiyymlbbhmcfchfh");
            mailAccount.setUser("1830225455");
            mailAccount.setPort(465);
            mailAccount.setAuth(true);
            mailAccount.setSslEnable(true);
            MailUtil.send(mailAccount,email.getEmail(), "测试", successContent, true);
}
    }
}

