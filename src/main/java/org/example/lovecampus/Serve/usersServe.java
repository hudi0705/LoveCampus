package org.example.lovecampus.Serve;

import org.example.lovecampus.Entily.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class usersServe {
@Autowired
private org.example.lovecampus.Mapper.usersMapper usersMapper;
public int adduser(users users){
    return usersMapper.insertUser(users) ;
}
public  users getuser(String username){
return usersMapper.getusersname(username);
}
public List<users> getUsers(){
    return usersMapper.getUsers();
}
}
