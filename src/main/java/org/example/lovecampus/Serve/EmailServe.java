package org.example.lovecampus.Serve;

import org.example.lovecampus.email;
import org.example.lovecampus.Mapper.EmailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServe {

    @Autowired
    private EmailMapper emailMapper;

    public List<email> SelectEmail() {
        return emailMapper.SelectEmail();
    }
    public List<email> SelectEmailleng() {
        return emailMapper.SelectEmail();
    }
    public email GetEmail(String email) {
        return emailMapper.GetEmail(email);
    }
    public int addEmail(email email) {
        return emailMapper.InsertEmail(email);
    }
}