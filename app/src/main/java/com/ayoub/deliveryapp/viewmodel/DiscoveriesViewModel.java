package com.ayoub.deliveryapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ayoub.deliveryapp.model.Discovery;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DiscoveriesViewModel extends ViewModel {
    private final MutableLiveData<List<Discovery>> discoveries = new MutableLiveData<>();
    private final DatabaseReference databaseReference;

    public DiscoveriesViewModel() {
        databaseReference = FirebaseDatabase.getInstance().getReference().child("discoveries");
        loadDiscoveries();
    }

    private void loadDiscoveries() {
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Discovery> discoveriesList = new ArrayList<>();
                for (DataSnapshot discoveriesSnapshot : dataSnapshot.getChildren()) {
                    Discovery discovery = discoveriesSnapshot.getValue(Discovery.class);
                    discoveriesList.add(discovery);
                }
                discoveries.setValue(discoveriesList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // TODO: Handle error
            }
        });
    }

    public LiveData<List<Discovery>> getDiscoveries() {
        return discoveries;
    }
}
