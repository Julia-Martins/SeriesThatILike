package com.example.seriesthatilike.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seriesthatilike.R;
import com.example.seriesthatilike.database.DatabaseHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

public class ListSeriesGallery extends AppCompatActivity {
    private FloatingActionButton btnAddSeries;
    private DatabaseHelper databaseHelper;
    private RecyclerView recyclerView;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_series_gallery);

        recyclerView = findViewById(R.id.rec_view_series_gallery);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btnAddSeries = findViewById(R.id.btn_flt_series_gallery);
        Intent intent = new Intent(getApplication(), CreateSeries.class);

        btnAddSeries.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(intent);
                    }
                }
        );
    }
}