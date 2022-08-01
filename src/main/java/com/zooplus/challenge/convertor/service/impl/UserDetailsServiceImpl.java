package com.zooplus.challenge.convertor.service.impl;

import com.zooplus.challenge.convertor.entity.User;
import com.zooplus.challenge.convertor.entity.UserDetailsImpl;
import com.zooplus.challenge.convertor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for "+ username + ".");
        }
        UserDetailsImpl userDetails = new UserDetailsImpl(user);
        return userDetails;
    }

}
