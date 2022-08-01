package com.zooplus.challenge.convertor.utility;

import com.zooplus.challenge.convertor.entity.User;
import com.zooplus.challenge.convertor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DBInit implements CommandLineRunner {


    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public DBInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User("zooplus", passwordEncoder.encode("password"), "zooplus", "zooplus@email.com", true);
        User user2 = new User("test", passwordEncoder.encode("password"), "test", "test@email.com", true);
        User user3 = new User("admin", passwordEncoder.encode("admin"), "admin", "admin@email.com", true);
        User user4 = new User("user", passwordEncoder.encode("password"), "user", "user@email.com", true);
        List<User> users = Arrays.asList(user1, user2, user3, user4);
        this.userRepository.saveAll(users);
    }
}

