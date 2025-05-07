package org.example.lovecampus.Contorlle;

import org.example.lovecampus.DTO.MessageDTO;
import org.example.lovecampus.Entily.Message;
import org.example.lovecampus.Mapper.MessageMapper;
import org.example.lovecampus.Serve.MessageServe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class MessageController {
    @Autowired
    MessageServe messageServe;

    @PostMapping("/sendMessage")
    public String senMessage(@RequestBody MessageDTO m) {
        System.out.println(m);
        messageServe.InsertMessage(m);
        return "发送成功";
    }
    @GetMapping("/GetMeassage")
    public ResponseEntity<?> GetMeassage() {
        List<Message> message =messageServe.getMessageList();
        return ResponseEntity.ok(message);
    }
}
