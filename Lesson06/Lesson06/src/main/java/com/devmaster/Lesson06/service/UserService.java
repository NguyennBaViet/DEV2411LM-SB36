package com.devmaster.Lesson06.service;

import com.devmaster.Lesson06.entity.User;
import com.devmaster.Lesson06.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //Tạo mới người dùng
    public User createUser(User user) {
        return userRepository.save(user);
    }

    //Lấy toàn bộ user
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    //Cập nhật người dùng
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    //Xóa người dùng
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
