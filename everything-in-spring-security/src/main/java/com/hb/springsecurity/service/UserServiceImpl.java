package com.hb.springsecurity.service;

import com.hb.springsecurity.entity.Users;
import com.hb.springsecurity.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    //@Autowired
    //private BCryptPasswordEncoder passwordEncoder;


    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }


    @Override
    public void saveUser(Users user) {

        //System.out.println("Hashed Password using BCryptPasswordEncoder: "+this.passwordEncoder.encode(user.getPassword()));
        //String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        //user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
