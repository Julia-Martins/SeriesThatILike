package com.example.seriesthatilike.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seriesthatilike.R;
import com.example.seriesthatilike.adapters.ItemSeriesListAdapter;
import com.example.seriesthatilike.models.ItemSeriesListModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListSeriesGallery extends AppCompatActivity {

    private FloatingActionButton btnAddSeries;
    private RecyclerView rv_series_gallery;
    private DatabaseReference databaseReference;
    private ItemSeriesListAdapter seriesAdapter;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_series_gallery);

        rv_series_gallery = findViewById(R.id.rec_view_series_gallery);
        rv_series_gallery.setHasFixedSize(true);
        rv_series_gallery.setLayoutManager(new LinearLayoutManager(this));

        btnAddSeries = findViewById(R.id.btn_flt_series_gallery);
        Intent intent = new Intent(getApplication(), CreateSeries.class);
        btnAddSeries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null){
            String userEmail = user.getEmail().replace(".", ",");
            Log.d("EMAIL #################", userEmail);
            databaseReference = FirebaseDatabase.getInstance().getReference().child(userEmail);
        }

        seriesAdapter = new ItemSeriesListAdapter();
        rv_series_gallery.setAdapter(seriesAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<ItemSeriesListModel> itemSeriesListModels = new ArrayList<>();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Log.d("Entrance ", snapshot.toString());

                    String seriesName = snapshot.getKey();
                    String seriesDate = snapshot.child("seriesDate").getValue(String.class);
                    String seriesPlatform = snapshot.child("seriesPlatform").getValue(String.class);

                    int intEpiNum = snapshot.child("intEpiNum").getValue(Integer.class);
                    int intSeasonNum = snapshot.child("intSeasonNum").getValue(Integer.class);
                    Boolean intSeriesWatched = snapshot.child("intSeriesWatched").getValue(Boolean.class);

                    ItemSeriesListModel seriesListModel = new ItemSeriesListModel(
                            seriesName,
                            seriesDate,
                            seriesPlatform,
                            intEpiNum,
                            intSeasonNum,
                            intSeriesWatched);
                    itemSeriesListModels.add(seriesListModel);
                }
                seriesAdapter.setItemSeriesModel(itemSeriesListModels);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError dataSnapshot) {
                Toast.makeText(ListSeriesGallery.this,
                                "Something goes wrong : " + dataSnapshot.getMessage(),
                                Toast.LENGTH_LONG)
                        .show();
            }
        });
    }
}