package com.ayoub.deliveryapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ayoub.deliveryapp.model.Product;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class ProductViewModel extends ViewModel {
    private final MutableLiveData<List<Product>> products = new MutableLiveData<>();
    private final DatabaseReference databaseReference;

    public ProductViewModel() {
        databaseReference = FirebaseDatabase.getInstance().getReference().child("products");
        loadProducts();
    }

    private void loadProducts() {
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Product> productsList = new ArrayList<>();
                for (DataSnapshot productsSnapshot : dataSnapshot.getChildren()) {
                    Product product = productsSnapshot.getValue(Product.class);
                    productsList.add(product);
                }
                products.setValue(productsList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // TODO: Handle error
            }
        });
    }

    public LiveData<List<Product>> getProducts() {
        return products;
    }
}
