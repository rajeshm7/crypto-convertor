package com.zooplus.challenge.convertor.repository;

import com.zooplus.challenge.convertor.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
