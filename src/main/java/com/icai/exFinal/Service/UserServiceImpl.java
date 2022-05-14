package com.icai.exFinal.Service;

import com.icai.exFinal.DTO.UserDocumentsDto;
import com.icai.exFinal.DTO.UserWIthDocumentsDto;
import com.icai.exFinal.Model.User;
import com.icai.exFinal.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers(){
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(obj -> new User(
                        obj.getUser_id(),
                        obj.getUser(),
                        obj.getComment())).toList();
    }

    @Override
    public boolean existsById(Long id){
        return  userRepository.existsById(id);
    }

    @Override
    public List<UserDocumentsDto> getAllUserDocuments(){
        return StreamSupport.stream(userRepository.getAllUserDocuments().spliterator(), false)
                .map(obj -> new UserDocumentsDto(
                        obj.getUser_id(),
                        obj.getUser(),
                        obj.getComment(),
                        obj.getDoc(),
                        obj.getDoc_id()
                        )).toList();
    }
}
