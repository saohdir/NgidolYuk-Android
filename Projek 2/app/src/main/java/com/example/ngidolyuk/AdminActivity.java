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
import android.widget.Toast;

import com.example.ngidolyuk.Common.Common;
import com.example.ngidolyuk.Model.User;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.lang.ref.Reference;
import java.util.HashMap;

public class AdminActivity extends AppCompatActivity {
    EditText adminid, tanggalshow, waktushow, setlist, namateam;
    Button addadmin, updateadmin, removeadmin;

    DatabaseReference reference;

    Request req = new Request();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        adminid = findViewById(R.id.adminID);
        tanggalshow = findViewById(R.id.tanggalShow);
        waktushow = findViewById(R.id.waktuShow);
        setlist = findViewById(R.id.setList);
        namateam = findViewById(R.id.namateam);
        addadmin = findViewById(R.id.addAdmin);
        updateadmin = findViewById(R.id.updateAdmin);
        removeadmin = findViewById(R.id.removeAdmin);


        //Init Firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_users = database.getReference("users");


        addadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDialog = new ProgressDialog(AdminActivity.this);



                reference = FirebaseDatabase.getInstance().getReference().child("Request");

                getValue();



                table_users.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String AdminId = adminid.getText().toString();
                        String tanggal_show = tanggalshow.getText().toString();
                        String waktu_show = waktushow.getText().toString();
                        String nama_show = setlist.getText().toString();
                        String nama_team = namateam.getText().toString();

                        if (TextUtils.isEmpty(AdminId)) {
                            adminid.setError("Id is required");
                            return;
                        }
                        if (TextUtils.isEmpty(tanggal_show)) {
                            tanggalshow.setError("Tanggal Show is required");
                            return;
                        }
                        if (TextUtils.isEmpty(waktu_show)) {
                            waktushow.setError("Waktu Show is required");
                            return;
                        }
                        if (TextUtils.isEmpty(nama_show)) {
                            setlist.setError("Rata is required");
                            return;
                        }
                        if (TextUtils.isEmpty(nama_team)) {
                            namateam.setError("Nama Team is required");
                            return;
                        }

                        if (dataSnapshot.child(adminid.getText().toString()).exists()) {
                            Toast.makeText(AdminActivity.this, "Id Admin udah ada Lur", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        else {
                            Request request = new Request(AdminId, tanggal_show, waktu_show, nama_show, nama_team);

                            table_users.child(adminid.getText().toString()).setValue(request);
                            Toast.makeText(AdminActivity.this, "Succcess", Toast.LENGTH_SHORT).show();
                            adminid.setText("");
                            tanggalshow.setText("");
                            waktushow.setText("");
                            setlist.setText("");
                            namateam.setText("");

                        }



                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });


        updateadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDialog = new ProgressDialog(AdminActivity.this);

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference table_users = database.getReference("users");


                reference = FirebaseDatabase.getInstance().getReference().child("users");

                getValue();

                table_users.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String AdminId = adminid.getText().toString();
                        String tanggal_show = tanggalshow.getText().toString();
                        String waktu_show = waktushow.getText().toString();
                        String nama_show = setlist.getText().toString();
                        String nama_team = namateam.getText().toString();


                        if(TextUtils.isEmpty(AdminId)){
                            adminid.setError("Id is required");
                            return;
                        }
                        if(TextUtils.isEmpty(tanggal_show)){
                            tanggalshow.setError("Tanggal Show is required");
                            return;
                        }
                        if(TextUtils.isEmpty(waktu_show)){
                            waktushow.setError("Waktu Show is required");
                            return;
                        }
                        if(TextUtils.isEmpty(nama_show)){
                            setlist.setError("Rata is required");
                            return;
                        }
                        if(TextUtils.isEmpty(nama_team)){
                            namateam.setError("Nama Team is required");
                            return;
                        }

                        if (dataSnapshot.child(adminid.getText().toString()).exists()) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("tanggal_show",tanggal_show);
                            hashMap.put("waktu_show",waktu_show);
                            hashMap.put("nama_show",nama_show);
                            hashMap.put("nama_team",nama_team);




                            reference.child(AdminId).updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                                @Override
                                public void onSuccess(Object o) {
                                    Toast.makeText(AdminActivity.this, "Data Successfully Updated", Toast.LENGTH_SHORT).show();
                                    adminid.setText("");
                                    tanggalshow.setText("");
                                    waktushow.setText("");
                                    setlist.setText("");
                                    namateam.setText("");

                                }
                            });




                        }



                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }
        });

        removeadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String AdminId = adminid.getText().toString();
                if(TextUtils.isEmpty(AdminId)){
                    adminid.setError("Id is required");
                    return;
                }

                delete(AdminId);
            }
        });








    }

    public void logout (View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }

    private void getValue()
    {

        req.setTanggal_show(tanggalshow.getText().toString());
        req.setWaktu_show(waktushow.getText().toString());
        req.setNama_show(setlist.getText().toString());
        req.setNama_team(namateam.getText().toString());
    }

    public void delete(String AdminId){
        DatabaseReference DR = FirebaseDatabase.getInstance().getReference("users").child(AdminId);
        DR.removeValue();
        Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
        adminid.setText("");
    }



}
