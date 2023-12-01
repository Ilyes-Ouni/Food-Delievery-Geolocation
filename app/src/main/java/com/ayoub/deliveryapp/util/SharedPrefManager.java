package com.ayoub.deliveryapp.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.ayoub.deliveryapp.model.User;

public class SharedPrefManager {

    private static final String SHARED_PREF_NAME = "my_shared_preferences";
    private SharedPreferences sharedPreferences;
    private Context context;

    public SharedPrefManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    public void saveUser(User user) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("userId", user.getUserId());
        editor.putString("userName", user.getName());
        editor.putString("email", user.getEmail());
        editor.putString("phoneNumber", user.getPhoneNumber());
        editor.putString("password", user.getPassword());
        editor.apply();
    }

    public User getUser() {
        String userId = sharedPreferences.getString("userId", null);
        String userName = sharedPreferences.getString("userName", null);
        String email = sharedPreferences.getString("email", null);
        String phoneNumber = sharedPreferences.getString("phoneNumber", null);
        String password = sharedPreferences.getString("password", null);
        return new User(userId, userName, email, phoneNumber, password);
    }

    public boolean isLoggedIn() {
        return sharedPreferences.getString("userId", null) != null;
    }

    public void clear() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
    public void saveOnboardingComplete(boolean isComplete) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("onboardingComplete", isComplete);
        editor.apply();
    }

    public boolean isOnboardingComplete() {
        return sharedPreferences.getBoolean("onboardingComplete", false);
    }
}
