package com.lyd.TodoTMS.TodoTMS.services;

import com.lyd.TodoTMS.TodoTMS.models.User;
import com.lyd.TodoTMS.TodoTMS.repositories.UserRepository;
import com.lyd.TodoTMS.TodoTMS.services.interfac.UserServiceInter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService implements UserServiceInter {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }


    @Override
    public void createTask() {

    }
}
