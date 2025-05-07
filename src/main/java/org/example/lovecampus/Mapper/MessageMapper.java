package org.example.lovecampus.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.lovecampus.DTO.MessageDTO;
import org.example.lovecampus.Entily.Message;
import org.example.lovecampus.Entily.email;
import java.util.List;
@Mapper
public interface MessageMapper {
    @Insert("INSERT INTO message (LiuYan) VALUE (#{liuYan})")
    int InsertMessage( MessageDTO m);
    @Select("SELECT id,LiuYan FROM message")
    List<Message> GetAllMessages();
}