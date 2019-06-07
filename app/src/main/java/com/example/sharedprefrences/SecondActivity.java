package com.example.sharedprefrences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
   Button load,remove,clear;
   TextView name,email;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        final String FILE="com.example.sharedprefrences.my_file";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        load=findViewById(R.id.load2);
        remove=findViewById(R.id.remove);
        clear=findViewById(R.id.clear);
        name=findViewById(R.id.txt3);
        email=findViewById(R.id.txt4);

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences(FILE, Context.MODE_PRIVATE);
               String myName= sharedPreferences.getString("name","not");
                String myEmail= sharedPreferences.getString("email","not");
                name.setText(myName);
                email.setText(myEmail);

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences(FILE,Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.apply();
            }
        });
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences(FILE,Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.remove("name");
                editor.apply();
            }
        });
    }
}
