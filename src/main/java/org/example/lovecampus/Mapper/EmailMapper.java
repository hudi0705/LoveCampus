package org.example.lovecampus.Mapper;

import org.apache.ibatis.annotations.*;
import org.example.lovecampus.Entily.email;

import java.util.List;

@Mapper
public interface EmailMapper {

    @Select("SELECT id, email FROM email WHERE email = #{email}") // 表名统一小写
    email GetEmail(String email); // 添加 @Param 明确参数绑定

    @Select("SELECT id, email FROM email")
    List<email> SelectEmail();

    @Insert("INSERT INTO email (email,code) VALUES (#{email},#{code})")
//    @Options(useGeneratedKeys = true, keyProperty = "param.id") // 确保实体类有 id 字段的 setter
    int InsertEmail(email email);
    @Select("select code from email where email = #{emial}")
    int GetCode(String emial);
}