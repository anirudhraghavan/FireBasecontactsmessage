package com.example.anirudh.otpverification;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    String num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






    }

    public void onclick(View view)
    {
        EditText numb=(EditText)findViewById(R.id.editText);
        num=numb.getText().toString();
        Intent intent=new Intent(MainActivity.this,Main2Activity.class);
        intent.putExtra("number",num);
        startActivity(intent);





    }

    public void onclick1(View view)
    {
        Intent intent=new Intent(MainActivity.this,database.class);
        startActivity(intent);
    }

}
