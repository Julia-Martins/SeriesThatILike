package com.example.seriesthatilike.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.seriesthatilike.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class UserLogin extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText txt_edt_email;
    private EditText txt_edt_password;
    private Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        mAuth = FirebaseAuth.getInstance();

        txt_edt_email = findViewById(R.id.txt_edt_email);
        txt_edt_password = findViewById(R.id.txt_edt_password);

        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
    }

    private void loginUser(){
        String email = txt_edt_email.getText().toString();
        String password = txt_edt_password.getText().toString();

        if (TextUtils.isEmpty(email)) {
            txt_edt_email.requestFocus();
            Toast.makeText(this, "EMAIL CAN'T BE EMPTY!",
                    Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(password)) {
            txt_edt_password.requestFocus();
            Toast.makeText(this, "PASSWORD CAN'T BE EMPTY!",
                    Toast.LENGTH_SHORT).show();
        }else {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Intent loginIntent = new Intent(getApplication(), ListSeriesGallery.class);
                        startActivity(loginIntent);
                        Toast.makeText(UserLogin.this,
                                        "Login was SUCCESSFULLY completed!!",
                                        Toast.LENGTH_LONG)
                        .show();

                        clear();
                    }else{
                        Toast.makeText(UserLogin.this,
                                    "Something goes wrong : " + task.getException().getMessage(),
                                    Toast.LENGTH_LONG)
                        .show();

                        clear();
                    }
                }
            });
        }
    }

    private void clear(){
        txt_edt_email.setText("");
        txt_edt_password.setText("");
    }
}