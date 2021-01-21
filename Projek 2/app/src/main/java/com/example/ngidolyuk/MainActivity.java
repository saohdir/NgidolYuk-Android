package com.example.ngidolyuk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ngidolyuk.Common.Common;
import com.example.ngidolyuk.Model.User;

public class MainActivity extends AppCompatActivity {

        Button btnSignIn,btnSignUp,btnSignAdmin;


        private void goToHomeActivity(User userModel) {
            Common.currentUser = userModel;
            startActivity(new Intent(MainActivity.this,HomeActivity.class) );
            finish();
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignIn = (Button)findViewById(R.id.btnSignIn);
        btnSignUp = (Button)findViewById(R.id.btnSignUp);
        btnSignAdmin = (Button)findViewById(R.id.btnSignAdmin) ;

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signUp = new Intent(MainActivity.this, SignUp.class);
                startActivity(signUp);
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signIn = new Intent(MainActivity.this, SignIn.class);
                startActivity(signIn);
            }
        });

        btnSignAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginadmin = new Intent(MainActivity.this, LoginAdmin.class);
                startActivity(loginadmin);
            }
        });
    }
}
