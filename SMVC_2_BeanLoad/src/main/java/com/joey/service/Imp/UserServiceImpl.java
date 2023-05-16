package com.joey.service.Imp;

import com.joey.domain.User;
import com.joey.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    public void save(User user) {
        System.out.println("user service");
    }
}
