package com.icai.exFinal.Controller;

import com.icai.exFinal.DTO.UserDocumentsDto;
import com.icai.exFinal.DTO.UserWIthDocumentsDto;
import com.icai.exFinal.Model.Document;
import com.icai.exFinal.Model.User;
import com.icai.exFinal.Service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/api/users/")
public class UserController {

    private static final Logger LOGGER = (Logger)
            LoggerFactory.getLogger(UserController.class);


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
        LOGGER.info("OK");
        return ResponseEntity.ok().body(userService.getAllUserDocuments());
    }
/*
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}*/

    @PostMapping( "postbody")
    public ResponseEntity<User> postBody( @RequestBody User user) {
        LOGGER.info(user.getUser());
        User user1 = userService.save(user);
    return ResponseEntity
            .created(URI.create(String.format("/user/%s",user.getUser()))).body(user1);
    }

}
