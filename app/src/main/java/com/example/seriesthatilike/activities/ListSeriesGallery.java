package com.example.seriesthatilike.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.seriesthatilike.R;

public class ListSeriesGallery extends AppCompatActivity {
    private Button btnAddSeries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_series_gallery);

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