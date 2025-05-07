package org.example.lovecampus.Serve;

import org.example.lovecampus.DTO.MessageDTO;
import org.example.lovecampus.Entily.Message;
import org.example.lovecampus.Mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServe {
    @Autowired
    MessageMapper messageMapper;

    public int InsertMessage(MessageDTO m) {
        return messageMapper.InsertMessage(m);
    }

    public List<Message> getMessageList() {
        return messageMapper.GetAllMessages();
    }
}
