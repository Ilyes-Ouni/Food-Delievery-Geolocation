package com.ayoub.deliveryapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.ayoub.deliveryapp.model.User;
import com.ayoub.deliveryapp.repository.UserRepository;
import com.ayoub.deliveryapp.repository.UserRepositoryImpl;

public class UserViewModel extends ViewModel {
    private UserRepository userRepository;

    public UserViewModel() {
        userRepository = new UserRepositoryImpl(); // Initialize with your implementation
    }

    public LiveData<User> loginUser(String email, String password) {
        return userRepository.loginUser(email, password);
    }

    public LiveData<User> registerUser(User user) {
        return userRepository.registerUser(user);
    }


    public void logoutUser() {
        userRepository.logoutUser();
    }

    public LiveData<User> getUserData() {
        return userRepository.getUserData();
    }
}