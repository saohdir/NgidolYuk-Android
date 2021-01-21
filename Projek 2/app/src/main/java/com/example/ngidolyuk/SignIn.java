package com.example.ngidolyuk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ngidolyuk.Common.Common;
import com.example.ngidolyuk.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignIn extends AppCompatActivity {
    EditText edtUser, edtPass;
    Button btnSignIn;
    TextView madminbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        edtPass = (MaterialEditText)findViewById(R.id.edtPass);
        edtUser = (MaterialEditText)findViewById(R.id.edtUser);
        btnSignIn = (Button)findViewById(R.id.btnSignIn);
        madminbtn = (TextView)findViewById(R.id.adminbtn);

        //Init Firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_Visitor = database.getReference("Visitor");




        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mDialog = new ProgressDialog(SignIn.this);
                mDialog.setMessage("Sabar Yaaaaa!");
                mDialog.show();
                table_Visitor.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        // Kalo belom daftar
                        String username = edtUser.getText().toString().trim();
                        String passwordd = edtPass.getText().toString().trim();
                        if (TextUtils.isEmpty(username)){
                            mDialog.dismiss();
                            edtUser.setError("Isi dulu ya");
                            return;
                        }
                        if (TextUtils.isEmpty(passwordd)){
                            mDialog.dismiss();
                            edtPass.setError("Isi dulu ya");
                            return;
                        }


                        if (dataSnapshot.child(edtUser.getText().toString()).exists()){

                            // Dapetin Informasi User
                            mDialog.dismiss();

                            User Visitor = dataSnapshot.child(edtUser.getText().toString()).getValue(User.class);
                            if (Visitor.getPassword().equals(edtPass.getText().toString()))
                            {
                                Intent homeIntent = new Intent(SignIn.this, HomeActivity.class);
                                Common.currentUser = Visitor;
                                startActivity(homeIntent);
                                finish();
                            }
                            else
                            {
                                Toast.makeText(SignIn.this, "Passwordnya salah Lur!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            mDialog.dismiss();
                            Toast.makeText(SignIn.this, "Kalo belom buat akun, daftar dulu gan!", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }

                });




            }


        });


    }


}