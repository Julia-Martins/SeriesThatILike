package com.example.seriesthatilike.activities;

import static com.example.seriesthatilike.R.id;
import static com.example.seriesthatilike.R.layout;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CreateSeries extends AppCompatActivity {
    private Calendar calendar = Calendar.getInstance();
    private DatePickerDialog.OnDateSetListener dateSetListener;
    private Toolbar toolBar_add_series;
    private EditText txt_edt_name_add_series;
    private EditText txt_edt_date_add_series;
    private EditText txt_edt_episode_add_series;
    private EditText txt_edt_season_add_series;
    private EditText txt_edt_platform_add_series;
    private EditText txt_edt_description_add_series;
    private CheckBox chk_watch_add_series;
    private Button btn_add_series;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_create_series);

        toolBar_add_series = findViewById(id.toolBar_add_series);

        txt_edt_name_add_series = findViewById(id.txt_edt_name_add_series);
        txt_edt_date_add_series = findViewById(id.txt_edt_date_add_series);
        txt_edt_episode_add_series = findViewById(id.txt_edt_episode_add_series);
        txt_edt_season_add_series = findViewById(id.txt_edt_season_add_series);
        txt_edt_platform_add_series = findViewById(id.txt_edt_platform_add_series);
        txt_edt_description_add_series = findViewById(id.txt_edt_description_add_series);

        chk_watch_add_series = findViewById(id.chk_watch_add_series);
        btn_add_series = findViewById(id.btn_add_series);

        setSupportActionBar(toolBar_add_series);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolBar_add_series.setNavigationOnClickListener(
                View -> {
                    onBackPressed();
                }
        );

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                updateDateInView();
            }
        };

        txt_edt_date_add_series.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        CreateSeries.this,
                        dateSetListener,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                );
                datePickerDialog.show();
            }
        });
        chk_watch_add_series.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int watchedStatus = chk_watch_add_series.isChecked() ? 1 : 0;
                Log.i("Know if it's everything okay ", String.valueOf(watchedStatus));
            }
        });

        btn_add_series.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
            @Override
            public void onClick(View v) {
                createSeries();
            }
        });

    }

    private void createSeries(){
        String seriesName = txt_edt_name_add_series.getText().toString();
        String seriesDescription = txt_edt_description_add_series.getText().toString();
        String seriesDate = txt_edt_date_add_series.getText().toString();
        String seriesPlatform = txt_edt_platform_add_series.getText().toString();

        int intEpiNum = txt_edt_episode_add_series.getText().length();
        int intSeasonNum = txt_edt_season_add_series.getText().length();
        int intSeriesWatched = chk_watch_add_series.isChecked() ? 1 : 0;

        if(seriesName.isEmpty()) {
            Toast.makeText(CreateSeries.this, "Título não pode estar vázio.",
                    Toast.LENGTH_SHORT).show();
        }else if(seriesDescription.isEmpty()){
            Toast.makeText(CreateSeries.this, "Descrição não pode estar vázio.",
                    Toast.LENGTH_SHORT).show();
        }else if(seriesDate.isEmpty()) {
            Toast.makeText(CreateSeries.this, "Data não pode estar vázio.",
                    Toast.LENGTH_SHORT).show();
        }else if(seriesPlatform.isEmpty()){
            Toast.makeText(CreateSeries.this, "Plataforma não pode estar vázio.",
                    Toast.LENGTH_SHORT).show();
        }else if(intEpiNum <= 0){
            Toast.makeText(CreateSeries.this, "Episódio não pode ser menor ou igual a 0.",
                    Toast.LENGTH_SHORT).show();
        } else if (intSeasonNum <= 0) {
            Toast.makeText(CreateSeries.this, "Temporada não pode ser menor ou igual a 0.",
                    Toast.LENGTH_SHORT).show();

        }else {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference seriesRef = database.getReference("tbl_series");

            seriesRef.child(seriesName).child("seriesName").setValue(seriesName);
            seriesRef.child(seriesDescription).child("seriesDescription").setValue(seriesDescription);
            seriesRef.child(seriesDate).child("seriesDate").setValue(seriesDate);
            seriesRef.child(seriesPlatform).child("seriesPlatform").setValue(seriesPlatform);
            seriesRef.child(String.valueOf(intEpiNum)).child("intEpiNum").setValue(intEpiNum);
            seriesRef.child(String.valueOf(intSeasonNum)).child("intSeasonNum").setValue(intSeasonNum);
            seriesRef.child(String.valueOf(intSeriesWatched)).child("intSeriesWatched").setValue(intSeriesWatched);

            Toast.makeText(
                    this,
                    "SERIES SUCCESSFULLY ADDED",
                    Toast.LENGTH_SHORT)
            .show();
        }
    }

    private void updateDateInView(){
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.getDefault());

        txt_edt_date_add_series.setText(sdf.format(calendar.getTime()).toString());
    }
}