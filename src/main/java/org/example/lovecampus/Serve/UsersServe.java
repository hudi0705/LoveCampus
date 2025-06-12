package org.example.lovecampus.Serve;

import org.example.lovecampus.DTO.usersDTO;
import org.example.lovecampus.Entily.Token;
import org.example.lovecampus.Entily.users;
import org.example.lovecampus.Mapper.UsersMapper;
import org.example.lovecampus.Misc.Result;
import org.example.lovecampus.Utils.TokenS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServe {

    @Autowired
    UsersMapper usersMapper;

    public Result<List<users>> getusers(){

        return Result.success("获取成功",usersMapper.Getusers());
    }
    
    /**
     * 用户登录方法
     * 修改说明：
     * 1. 将 usersMapper.Login(user) 的返回值存储到 foundUser 变量中，而不仅仅检查 !=null
     * 2. 从数据库获取的 foundUser 对象中提取 name 值 (foundUser.getName())
     * 3. 使用从数据库获取的 name 值生成 token，而不是使用传入的 DTO 中的 name
     * 4. 解决了 name 返回为 null 的问题，因为现在使用的是数据库中的实际值
     * 5. 优化了错误提示信息，更加具体和准确
     * 6. 修复了代码中的语法错误（移除了多余的分号）
     */
    public Result<Token> Login(usersDTO user) {
        users foundUser = usersMapper.Login(user);
        if (foundUser != null) {
            // 从数据库获取到的用户对象中获取name
            String userName = foundUser.getName();
            return Result.success("登录成功", TokenS.getToken(user.getUsername(), userName));
        }
        return Result.error("用户名或密码错误");
    }
    public  Result<Integer> InsetUser(usersDTO user){
        if (usersMapper.SelectUserName(user)>2) {
Result.success("用户重名");
        }
        return Result.success("注册成功",usersMapper.InsertUers(user));
    }

}

