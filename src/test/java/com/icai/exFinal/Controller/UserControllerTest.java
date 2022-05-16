package com.icai.exFinal.Controller;

import com.icai.exFinal.Model.User;
import com.icai.exFinal.Repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    UserRepository userRepository;

    @Test
    public void return_ok_when_getAll() {
        //given
        List<User> expextedResult = (List<User>) userRepository.findAll();
        String url = "http://localhost:" + Integer.toString(port) + "/api/users/getAll";
        HttpHeaders headers = HttpHeaders.EMPTY;
        HttpEntity<String> entity = new HttpEntity<>(headers);

        //when
        ResponseEntity<List<User>> result = testRestTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<User>>() {
        });

        //then
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertEquals(expextedResult, result.getBody());

    }

}