package com.example.anirudh.otpverification;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class database extends AppCompatActivity {

Firebase myfirebase;

    UsersAdapter adapter;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        ArrayList<User> arrayOfUsers = new ArrayList<User>();
// Create the adapter to convert the array to views
       adapter= new UsersAdapter(this, arrayOfUsers);
// Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

        Firebase.setAndroidContext(getApplicationContext());






        myfirebase = new Firebase("https://my-project-1538840324945.firebaseio.com/");
        myfirebase.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                for (com.firebase.client.DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    for (com.firebase.client.DataSnapshot post1Snapshot : postSnapshot.getChildren()) {
                        User newUser = new User(post1Snapshot.child("number").getValue(String.class), post1Snapshot.child("message").getValue(String.class));
                        adapter.add(newUser);

                    }
                }

                /*User newUser = new User(dataSnapshot.child("number").getValue(String.class),dataSnapshot.child("message").getValue(String.class) );
                adapter.add(newUser);*/


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Toast.makeText(database.this, firebaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }





}
