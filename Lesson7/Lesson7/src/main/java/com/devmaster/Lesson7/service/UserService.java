package com.devmaster.Lesson7.service;

import com.devmaster.Lesson7.entity.User;
import com.devmaster.Lesson7.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    //List user
    @Transactional
    public List<User> findAll() {
        return userRepository.findAll();
    }
    //Get userById
    @Transactional
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    //Save user
    @Transactional
    public User saveUser(User user) {
        //Thêm mới
        if(user.getId() == null) {
            return userRepository.save(user);
        }
        //Sửa => Cập nhật
        User newUser = new User();
        newUser.setId(user.getId());
        newUser.setFullName(user.getFullName());
        newUser.setUserName(user.getUserName());
        newUser.setPassword(user.getPassword());
        newUser.setEmail(user.getEmail());
        newUser.setAddress(user.getAddress());
        newUser.setPhone(user.getPhone());
        newUser.setActive(user.getActive());
        return userRepository.save(newUser);
    }
    //Delete user
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    //exist username
    public Boolean existByUserName(String userName) {
        return userRepository.existsByUserName(userName);
    }
}
