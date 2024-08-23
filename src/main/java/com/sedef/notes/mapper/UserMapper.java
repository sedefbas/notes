package com.sedef.notes.mapper;


import com.sedef.notes.Model.User;
import com.sedef.notes.mapper.Dto.UserRequest;
import org.springframework.stereotype.Component;

@Component
public class UserMapper { // Sınıfı interface olarak değiştiriyoruz


    public User toUser(UserRequest request){
        User user = new User();
        user.setPassword(request.getPassword());
        user.setSurname(request.getSurname());
        user.setFirstName(request.getFirstName());
        user.setEmail(request.getEmail());
        return user;
    }
}
