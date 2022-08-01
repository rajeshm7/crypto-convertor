package com.zooplus.challenge.convertor.repository;

import com.zooplus.challenge.convertor.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @AfterEach
    void tearDown(){
        userRepository.deleteAll();
    }

    @Test
    void findByUsername() {

        User expected = new User("admin", "password", "admin", "admin@email.con", true);

        userRepository.save(expected);

        User actual = userRepository.findByUsername("admin");
        Assertions.assertEquals(expected.getUsername(), actual.getUsername());

    }
}