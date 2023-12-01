package com.ayoub.deliveryapp.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ayoub.deliveryapp.R;
import com.ayoub.deliveryapp.view.adapters.CategoryAdapter;
import com.ayoub.deliveryapp.viewmodel.CategoryViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView listCategories;
    private CategoryAdapter adapter;
    private CategoryViewModel categoryViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listCategories = findViewById(R.id.listCategories);
        listCategories.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        categoryViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);

        categoryViewModel.getCategories().observe(this, categories -> {
            adapter = new CategoryAdapter(HomeActivity.this, categories);
            listCategories.setAdapter(adapter);
        });



        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.navigation_home) {
                    return true;
                } else if (itemId == R.id.navigation_discover) {
                    startActivity(new Intent(HomeActivity.this, DiscoverActivity.class));
                    overridePendingTransition(R.anim.slide_out_left, R.anim.slide_in_right);
                    return true;
                } else if (itemId == R.id.navigation_drivethru) {

                } else if (itemId == R.id.navigation_orders) {

                } else if (itemId == R.id.navigation_profile) {
                    startActivity(new Intent(HomeActivity.this, HomeActivity.class));
                    overridePendingTransition(R.anim.slide_out_left, R.anim.slide_in_right);
                    return true;
                }
                return false;
            }
        });
    }
}