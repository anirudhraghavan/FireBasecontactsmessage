
package com.example.anirudh.otpverification;

        import android.content.Context;
        import android.content.Intent;
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
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;

        import java.util.ArrayList;

public class induvidual extends AppCompatActivity {

    Firebase myfirebase;

    UsersAdapter adapter;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_induvidual);
        ArrayList<User> arrayOfUsers = new ArrayList<User>();
// Create the adapter to convert the array to views
        adapter= new UsersAdapter(induvidual.this, arrayOfUsers);
// Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

        Firebase.setAndroidContext(getApplicationContext());

        FirebaseAuth firebaseAuth;
        firebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser currentUser=firebaseAuth.getInstance().getCurrentUser();

        String c=currentUser.getUid();




String url=("https://my-project-1538840324945.firebaseio.com/"+c);
        myfirebase = new Firebase(url);
        myfirebase.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                for (com.firebase.client.DataSnapshot postSnapshot: dataSnapshot.getChildren()) {

                        User newUser = new User(postSnapshot.child("number").getValue(String.class), postSnapshot.child("message").getValue(String.class));
                        adapter.add(newUser);


                }

                /*User newUser = new User(dataSnapshot.child("number").getValue(String.class),dataSnapshot.child("message").getValue(String.class) );
                adapter.add(newUser);*/


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Toast.makeText(induvidual.this, firebaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }





}
