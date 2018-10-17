package com.example.anirudh.otpverification;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main3Activity extends AppCompatActivity {
    private DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        FirebaseUser currentUser=firebaseAuth.getInstance().getCurrentUser();

        String c=currentUser.getUid();
        databaseReference= FirebaseDatabase.getInstance().getReference(c);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        firebaseAuth=FirebaseAuth.getInstance();
        Intent intent =getIntent();




    }
    public void onclick(View view)
    {
        EditText ed1=(EditText)findViewById(R.id.editText2);

        EditText ed2=(EditText)findViewById(R.id.editText4);
        String num=ed1.getText().toString();
        String message=ed2.getText().toString();


        FirebaseUser currentUser=firebaseAuth.getInstance().getCurrentUser();

String c=currentUser.getUid();
Intent intent=new Intent(Main3Activity.this,induvidual.class);
intent.putExtra("uid",c);
        UserInformation userInformation=new UserInformation(num,message,c);

        databaseReference.child(num).setValue(userInformation);



        Toast.makeText(Main3Activity.this,"REGISTREED SUCCESFULLY",Toast.LENGTH_SHORT).show();


    }
    public void onc(View view)
    {

        Intent intent=new Intent(Main3Activity.this,induvidual.class);
        startActivity(intent);
    }


}
