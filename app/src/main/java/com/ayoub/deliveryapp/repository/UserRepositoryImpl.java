package com.ayoub.deliveryapp.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ayoub.deliveryapp.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserRepositoryImpl implements UserRepository {
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    public UserRepositoryImpl() {
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
    }

    @Override
    public LiveData<User> loginUser(String email, String password) {
        MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                        String userId = firebaseUser != null ? firebaseUser.getUid() : null;
                        User user = new User(userId, null, email, null, password);
                        userMutableLiveData.setValue(user);
                    } else {
                        userMutableLiveData.setValue(null);
                    }
                });
        return userMutableLiveData;
    }

    @Override
    public LiveData<User> registerUser(User user) {
        MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();
        firebaseAuth.createUserWithEmailAndPassword(user.getEmail(), user.getPassword())
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                        String userId = firebaseUser != null ? firebaseUser.getUid() : null;
                        user.setUserId(userId);
                        databaseReference.child(userId).setValue(user);
                        userMutableLiveData.setValue(user);
                    } else {
                        userMutableLiveData.setValue(null);
                    }
                });
        return userMutableLiveData;
    }

    @Override
    public void logoutUser() {
        firebaseAuth.signOut();
    }

    @Override
    public LiveData<User> getUserData() {
        MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser != null) {
            databaseReference.child(firebaseUser.getUid()).get()
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            User user = task.getResult().getValue(User.class);
                            userMutableLiveData.setValue(user);
                        } else {
                            userMutableLiveData.setValue(null);
                        }
                    });
        }
        return userMutableLiveData;
    }
}