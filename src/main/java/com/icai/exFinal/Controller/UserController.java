package com.icai.exFinal.Controller;

import com.icai.exFinal.DTO.UserDocumentsDto;
import com.icai.exFinal.DTO.UserWIthDocumentsDto;
import com.icai.exFinal.Model.Document;
import com.icai.exFinal.Model.User;
import com.icai.exFinal.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users/")
public class UserController {


    @Autowired
    private UserService userService;

    @Transactional
    @GetMapping("exits/{id}")
    public ResponseEntity<Boolean> exitsById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(userService.existsById(id));
    }

    @GetMapping("getAll")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }
    @GetMapping("join")
    public ResponseEntity<List<UserDocumentsDto>> getAllUserDocuments(){
        return ResponseEntity.ok().body(userService.getAllUserDocuments());
    }

}
