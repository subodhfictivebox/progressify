package com.example.progressify.service;


import com.example.progressify.entity.User;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserServiceTest {


    @Autowired
    private UserService userService;

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "4,6,10",
            "4,2,6"
    })
    public void test(int a , int b, int expected){
        assertEquals(expected, a+b);
    }

    @ParameterizedTest
    @ArgumentsSource(UserArgumentProvider.class)
    public void saveUserTest(User user){
        assertTrue(userService.saveNewUser(user));
    }

}
