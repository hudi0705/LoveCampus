package org.example.lovecampus.Mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.example.lovecampus.users;

import java.util.List;

@Mapper
public interface usersMapper {

@Select("SELECT id, username,password,isYuyue, FROM users WHERE username=#{username}")
users getusersname(String username);

    @Select("SELECT id,username,password,isYuyue FROM users")
    List<users> getUsers();


    @Insert("INSERT INTO users ( username, password,isYuyue) VALUES ( #{username}, #{password},#{isYuyue})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
   public int insertUser(users users);
}
