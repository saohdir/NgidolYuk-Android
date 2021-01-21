package com.example.ngidolyuk;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginAdmin extends AppCompatActivity {
    EditText emailadmin, passwordadmin;
    Button btnSignInAdmin;
    FirebaseAuth fAuth;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        emailadmin = findViewById(R.id.email_admin);
        passwordadmin = findViewById(R.id.password_admin);
        fAuth = FirebaseAuth.getInstance();
        btnSignInAdmin = findViewById(R.id.adminbtn);


        btnSignInAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDialog = new ProgressDialog(LoginAdmin.this);
                mDialog.setMessage("Sabar Yaaaaa!");
                mDialog.show();

                String email = emailadmin.getText().toString().trim();
                String password = passwordadmin.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    mDialog.dismiss();
                    emailadmin.setError("Isi dulu ya");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    mDialog.dismiss();
                    passwordadmin.setError("Isi dulu ya");
                    return;
                }

                //autentifikasi

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(LoginAdmin.this, "Login berhasil", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),AdminActivity.class));
                            finish();
                        }
                        else
                        {
                            mDialog.dismiss();
                            Toast.makeText(LoginAdmin.this, "Cuma Admin Gan yang bisa, hehe :)", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


    }
}
