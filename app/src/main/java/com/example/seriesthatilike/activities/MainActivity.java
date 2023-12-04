  package com.example.seriesthatilike.activities;

  import android.content.Intent;
  import android.os.Bundle;
  import android.text.TextUtils;
  import android.view.View;
  import android.widget.Button;
  import android.widget.EditText;
  import android.widget.TextView;
  import android.widget.Toast;

  import androidx.annotation.NonNull;
  import androidx.appcompat.app.AppCompatActivity;

  import com.example.seriesthatilike.R;
  import com.google.android.gms.tasks.OnCompleteListener;
  import com.google.android.gms.tasks.Task;
  import com.google.firebase.auth.AuthResult;
  import com.google.firebase.auth.FirebaseAuth;

  public class MainActivity extends AppCompatActivity {
      private FirebaseAuth mAuth;
      private EditText txt_edt_email_create_account;
      private EditText txt_edt_password_create_account;
    private Button btnCreateAccount;
    private TextView txt_link_login_account;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        txt_edt_email_create_account = findViewById(R.id.txt_edt_email_create_account);
        txt_edt_password_create_account = findViewById(R.id.txt_edt_password_create_account);

        btnCreateAccount = findViewById(R.id.btn_create_account);
        txt_link_login_account = findViewById(R.id.txt_link_login_account);

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });
        txt_link_login_account.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent intentLogin = new Intent(getApplication(), UserLogin.class);
                  startActivity(intentLogin);
              }
          }
        );
    }
    private void createUser(){
        String userEmail = txt_edt_email_create_account.getText().toString();
        String userPassword = txt_edt_password_create_account.getText().toString();

        if (TextUtils.isEmpty(userEmail)) {
            txt_edt_email_create_account.requestFocus();
            Toast.makeText(this, "EMAIL CAN'T BE EMPTY!",
                    Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(userPassword)) {
            txt_edt_password_create_account.requestFocus();
            Toast.makeText(this, "PASSWORD CAN'T BE EMPTY!",
                    Toast.LENGTH_SHORT).show();
        }else {
            mAuth.createUserWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Intent intent = new Intent(getApplication(), UserLogin.class);
                                startActivity(intent);
                                Toast.makeText(MainActivity.this, "USER SUCCESSFULLY CREATED!",
                                        Toast.LENGTH_LONG).show();

                                clear();
                            }else {
                                Toast.makeText(MainActivity.this,
                                        "Something is wrong : " + task.getException().getMessage(),
                                        Toast.LENGTH_LONG)
                                .show();
                            }
                        }
                    }

            );
        }
    }

    private void clear(){
        txt_edt_email_create_account.setText("");
        txt_edt_password_create_account.setText("");
    }
}