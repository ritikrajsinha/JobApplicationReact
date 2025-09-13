package com.ritik.RestDemo.service;

import com.ritik.RestDemo.model.UserPrinciple;
import com.ritik.RestDemo.model.Users;
import com.ritik.RestDemo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));


        return new UserPrinciple(user);
    }
}
