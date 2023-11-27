package com.example.seriesthatilike.activities;

import android.Manifest;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AlertDialogLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.app.DialogCompat;
import androidx.core.content.ContextCompat;

import com.example.seriesthatilike.database.DatabaseHelper;
import com.example.seriesthatilike.databinding.ActivityCreateSeriesBinding;
import com.example.seriesthatilike.models.ItemSeriesListModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CreateSeries extends AppCompatActivity {
    private ActivityCreateSeriesBinding binding;
    private Calendar calendar = Calendar.getInstance();
    private DatePickerDialog.OnDateSetListener dateSetListener;
    private Uri saveImageSeries;
    private Uri saveImagePlatform;
    private Uri saveImageWatch;

    private ItemSeriesListModel mSeriesListModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolBarAddSeries);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.toolBarAddSeries.setNavigationOnClickListener(
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

        binding.btnAddSeries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveImageSeries = Uri.parse(
                        mSeriesListModel.getUriSeries()
                );
                saveImagePlatform = Uri.parse(
                        mSeriesListModel.getUriPlatform()
                );
                String seriesName = binding.txtEdtNameAddSeries.getText().toString();
                String seriesTitleDescription = binding.txtDescriptionAddSeries.getText().toString();
                String seriesDescription = binding.txtEdtDescriptionAddSeries.getText().toString();
                String seriesDate = binding.txtEdtDateAddSeries.getText().toString();
                int intEpiNum = binding.txtEdtEpisodeAddSeries.getText().length();
                int intSeasonNum = binding.txtEdtSeasonAddSeries.getText().length();
                saveImageWatch = Uri.parse(
                        mSeriesListModel.getBtnWatch()
                );

                if (saveImageSeries == null){
                    Toast.makeText(CreateSeries.this, "Não pode salvar sua série sem uma imagem",
                            Toast.LENGTH_SHORT).show();
                }else if(seriesName.isEmpty()) {
                    Toast.makeText(CreateSeries.this, "Título não pode estar vázio.",
                            Toast.LENGTH_SHORT).show();
                }else if(seriesDescription.isEmpty()){
                    Toast.makeText(CreateSeries.this, "Descrição não pode estar vázio.",
                            Toast.LENGTH_SHORT).show();
                }else if(seriesDate != null){
                    Toast.makeText(CreateSeries.this, "Data não pode estar vázio.",
                            Toast.LENGTH_SHORT).show();
                }else if(intEpiNum <= 0){
                    Toast.makeText(CreateSeries.this, "Episódio não pode ser menor ou igual a 0.",
                            Toast.LENGTH_SHORT).show();
                } else if (intSeasonNum <= 0) {
                    Toast.makeText(CreateSeries.this, "Temporada não pode ser menor ou igual a 0.",
                            Toast.LENGTH_SHORT).show();
                }else {
                    DatabaseHelper databaseHelper = new DatabaseHelper(CreateSeries.this);

                    SQLiteDatabase db = databaseHelper.getWritableDatabase();

                    ContentValues values = new ContentValues();
                    values.put("series_name", seriesName);
                    values.put("img_series", String.valueOf(saveImageSeries));
                    values.put("img_platform", String.valueOf(saveImagePlatform));

                    if(seriesTitleDescription.isEmpty()) {
                        seriesTitleDescription = binding.txtEdtNameAddSeries.getText().toString();
                        Toast.makeText(CreateSeries.this, "Título da descrição terá o mesmo nome da série.",
                                Toast.LENGTH_SHORT).show();
                    }

                    values.put("series_title_description", seriesTitleDescription);
                    values.put("series_description", seriesDescription);
                    values.put("series_date", seriesDate);
                    values.put("int_episodes_num", intEpiNum);
                    values.put("int_season_num", intSeasonNum);

                    long newRowId = db.insert(databaseHelper.TABLE_SERIES, null, values);

                    db.close();
                    finish();
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_PERMISSIONS){

        }
    }

    private void updateDateInView(){
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.getDefault());

        binding.txtEdtDateAddSeries.setText(sdf.format(calendar.getTime()).toString());
    }

    private void checkPermissions(){
        int permissionGranted1 = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int permissionGranted2 = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);

        if(permissionGranted1 != PackageManager.PERMISSION_GRANTED && permissionGranted2 != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE}, CONTEXT_INCLUDE_CODE);
        }else{
            Toast.makeText(this, "Permissão de armazenamento negada",
                    Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            intent.setData(Uri.fromParts("package", getPackageName(), null));
            startActivity(intent);
        }
    }

    protected class showRationalDialogPermissions(){
        AlertDialog.Builder.
    }
}