package org.example.lovecampus.Utils;

import cn.hutool.jwt.JWT;
import org.example.lovecampus.Entily.Token;

public class TokenS {

    public static org.example.lovecampus.Entily.Token getToken(String user,String name){
//        获取token
        byte[] key = "HANHAOQIANDASHABI".getBytes();
        String tokens = JWT.create()
                .setPayload("sub", "1234567890")
                .setPayload("name", "looly")
                .setPayload("admin", true)
                .setPayload("time", System.currentTimeMillis() + 1000 * 60 * 60 *24 * 7)
                .setKey(key)
                .sign();
//         验证token
        boolean validate = JWT.of(tokens).setKey(key).validate(0);
    return new Token(user,name,tokens);
    }
}
