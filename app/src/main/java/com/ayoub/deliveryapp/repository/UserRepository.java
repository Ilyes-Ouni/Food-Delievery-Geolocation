package com.ayoub.deliveryapp.repository;

import androidx.lifecycle.LiveData;

import com.ayoub.deliveryapp.model.User;

public interface UserRepository {
    LiveData<User> loginUser(String email, String password);
    LiveData<User> registerUser(User user);
    void logoutUser();
    LiveData<User> getUserData();
}
