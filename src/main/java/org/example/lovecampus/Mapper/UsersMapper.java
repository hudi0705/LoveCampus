package org.example.lovecampus.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.lovecampus.DTO.usersDTO;
import org.example.lovecampus.Entily.users;
import org.example.lovecampus.Misc.Result;

import java.util.List;

@Mapper
public interface UsersMapper {
    @Select("SELECT Name,Uid FROM users ")
    List<users> Getusers();
    
    /**
     * 登录查询方法
     * 修改说明：
     * 1. 将 SELECT * 改为明确列出所有需要的字段，提高查询效率
     * 2. 添加 Name as name 的映射，解决Java对象字段名(name)与数据库列名(Name)大小写不匹配问题
     * 3. 返回类型改为users对象，而不是int计数，以便获取完整的用户信息
     * 4. 这样可以获取到用户的name属性，用于生成包含用户名的token
     */
    @Select("SELECT id, UserName, Password, Uid, Name as name FROM users WHERE UserName= #{username} and Password=#{password}")
    users Login(usersDTO usersDTO);
    @Insert("INSERT INTO users (UserName,Password,Name) VALUE (#{username},#{password},#{name})")
    int InsertUers(usersDTO usersDTO);
    @Select("SELECT UserName FROM users WHERE UserName= #{username}")
    int SelectUserName(usersDTO usersDTO);

}
