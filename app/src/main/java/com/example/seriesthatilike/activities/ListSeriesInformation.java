package com.example.seriesthatilike.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.DatePicker;

import com.example.seriesthatilike.databinding.ActivityListSeriesInformationBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ListSeriesInformation extends AppCompatActivity {
    private ActivityListSeriesInformationBinding binding;
    private Calendar calendar = Calendar.getInstance();
    private DatePickerDialog.OnDateSetListener dateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolSeriesInformation);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.toolSeriesInformation.setNavigationOnClickListener(
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

        updateDateInView();
    }

    private void updateDateInView(){
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.getDefault());

        binding.txtDtWatchingSeriesList.setText(sdf.format(calendar.getTime()).toString());
    }
}