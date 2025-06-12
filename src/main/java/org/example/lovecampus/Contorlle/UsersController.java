package org.example.lovecampus.Contorlle;

import org.example.lovecampus.DTO.usersDTO;
import org.example.lovecampus.Entily.Message;
import org.example.lovecampus.Entily.Token;
import org.example.lovecampus.Entily.users;
import org.example.lovecampus.Misc.Result;
import org.example.lovecampus.Serve.MessageServe;
import org.example.lovecampus.Serve.UsersServe;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class UsersController {
    @Autowired
   UsersServe usersServe;
    @GetMapping("/GatUser")
    public ResponseEntity<?> GetMeassage() {
        Result<List<users>> users = usersServe.getusers();
        return ResponseEntity.ok(users);
    }
    @PostMapping("/Login")
    public Result<Token> Login(@RequestBody(required = true) usersDTO user) {
        return usersServe.Login(user);
    }
    @PostMapping("/InsetUser")
    public Result<Integer> InsetUser(@RequestBody(required = true) usersDTO user) {
        return  usersServe.InsetUser(user);
    }

}
