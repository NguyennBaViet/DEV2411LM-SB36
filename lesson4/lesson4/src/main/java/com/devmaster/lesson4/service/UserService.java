package com.devmaster.lesson4.service;

import com.devmaster.lesson4.dto.UserDTO;
import com.devmaster.lesson4.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    List<User> userList = new ArrayList<User>();
    public UserService() {
        userList.add(new User("Vương Kiên","kien123@gmail.com",19));
        userList.add(new User("Tiến Trung","trung@gmail.com",20));
        userList.add(new User("Bá Việt","viet@gmail.com",20));
        userList.add(new User("Đình Nam","nam@gmail.com",25));
        userList.add(new User("Mai Nhi","nhi@gmail.com",18));
    }
    //lấy ds
    public List<User> getUserList() {
        return userList;
    }
    //Thêm mới
    public boolean addUser(UserDTO userDTO) {
        try {
            User user = new User();
            user.setName(userDTO.getName());
            user.setEmail(userDTO.getEmail());
            user.setAge(userDTO.getAge());
            userList.add(user);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    //Sửa
    public User updateUser(User user) {
        for (User u : userList) {
            if (u.getName().equals(user.getName())) {
                u.setEmail(user.getEmail());
                u.setAge(user.getAge());
                return user;
            }
        }
        return null;
    }
    //Xóa
    public boolean deleteUser(User user) {
        for (User u : userList) {
            if (u.getName().equals(user.getName())) {
                userList.remove(u);
                return true;
            }
        }
        return false;
    }
}
