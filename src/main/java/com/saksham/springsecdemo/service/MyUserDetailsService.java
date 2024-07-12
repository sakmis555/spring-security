package com.saksham.springsecdemo.service;

import com.saksham.springsecdemo.dao.UserRepo;
import com.saksham.springsecdemo.model.User;
import com.saksham.springsecdemo.model.UserPrincipal;
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

        User user = repo.findByUsername(username);
        if(user == null) {
            System.out.println("user 404 not found");
            throw new UsernameNotFoundException(username);
        }

        return new UserPrincipal(user);
    }
}
