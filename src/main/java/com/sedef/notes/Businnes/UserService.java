package com.sedef.notes.Businnes;

import com.sedef.notes.mapper.Dto.UserRequest;
import com.sedef.notes.Model.User;
import com.sedef.notes.mapper.UserMapper;
import com.sedef.notes.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public User add(UserRequest request){
        User user = mapper.toUser(request);
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
