package com.example.demo4.SecurityApp;

import com.example.demo4.SecurityApp.entities.User;
import com.example.demo4.SecurityApp.services.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecurityAppApplicationTests {

    @Autowired
    private JwtService jwtService;

    @Test
    void contextLoads(){
        User user = new User(4L,"nishant@gmail.com","nishant","1234",null);

        String token = jwtService.generateAccessToken(user);

        System.out.println(token);

        Long id = jwtService.getUserIdFromToken(token);

        System.out.println(id   );
    }

}
