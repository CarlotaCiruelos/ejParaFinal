package com.icai.exFinal.Service;

import com.icai.exFinal.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public interface UserService {
    List<User> getUsers();
    boolean existsById(Long id);
}
