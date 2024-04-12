package com.erands.erands.Service.UserService;

import com.erands.erands.Model.User;
import com.erands.erands.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public String createUser(User user) {
        user.setCreatedAt(LocalDateTime.now().toString());
        try{
            userRepository.save(user);
            return "User Created";
        }catch(Exception e){
            return e.toString();
        }
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User updateUser(Long userId, User updatedUser) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            updatedUser.setId(userId);
            return userRepository.save(updatedUser);
        } else {
            throw new RuntimeException("User not found with id: " + userId);
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
