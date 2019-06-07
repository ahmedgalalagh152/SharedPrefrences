package com.example.sharedprefrences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText name,email;
    TextView nameText,emailText;
    Button save,load,nav;
    RelativeLayout relativeLayout;
    Switch aSwitch;
    boolean check;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        final String FILE="com.example.sharedprefrences.my_file";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        nameText=findViewById(R.id.txt1);
        emailText=findViewById(R.id.txt2);
        save=findViewById(R.id.save);
        load=findViewById(R.id.load);
        relativeLayout=findViewById(R.id.linear);
        nav=findViewById(R.id.btn);
        aSwitch=findViewById(R.id.swtch);

        SharedPreferences sharedPreferences=getPreferences(Context.MODE_PRIVATE);
        check=sharedPreferences.getBoolean("color",false);
        aSwitch.setChecked(check);
        relativeLayout.setBackgroundColor(check ? getResources().getColor(R.color.blue):getResources().getColor(R.color.red));



        nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences(FILE, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("name",name.getText().toString());
                editor.putString("email",email.getText().toString());
                editor.apply();
            }
        });
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences(FILE,Context.MODE_PRIVATE);
                String myName=sharedPreferences.getString("name","not found");
                String myEmail=sharedPreferences.getString("email","not found");
                nameText.setText(myName);
                emailText.setText(myEmail);
            }
        });
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            SharedPreferences sharedPreferences=getSharedPreferences(FILE,Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putBoolean("color",isChecked);
            editor.apply();
            relativeLayout.setBackgroundColor(isChecked ? getResources().getColor(R.color.blue):getResources().getColor(R.color.red));
            }
        });

    }
}
