package com.sedef.notes.Businnes;

import com.sedef.notes.Dto.UserRequest;
import com.sedef.notes.Model.User;
import com.sedef.notes.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User add(UserRequest request){
        User user = new User();
        user.setId(0);
        user.setFirstName(request.getFirstName());
        user.setSurname(request.getSurname());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return repository.save(user);
    }

    public void delete(int userId){
        repository.deleteById(userId);
    }

    public List<User> getAll(){
       return repository.findAll();
    }

    public User getbyId(int userId){
     return repository.findById(userId).get();
    }

}
