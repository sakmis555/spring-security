package com.saksham.springsecdemo.service;

import com.saksham.springsecdemo.dao.UserRepo;
import com.saksham.springsecdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public User saveUser(User user) {
        return repo.save(user);
    }
}
