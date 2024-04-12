package com.erands.erands.Service.UserService;

import com.erands.erands.Model.User;

import java.util.List;

public interface UserService {
    String createUser(User user);
    void deleteUser(Long userId);
    User updateUser(Long userId, User updatedUser);
    List<User> getAllUsers();
}
