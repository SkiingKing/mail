package com.example.user.mail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class Secondary extends AppCompatActivity {

    private TextView t;
    private TextView t2;
    private TextView t3;
    private TextView t4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondary_activity);


        EmailItem emailItem = getIntent().getParcelableExtra("email item");
        // Extract data




        t = findViewById(R.id.title_text);
        t2 = findViewById(R.id.second_text);
        t3 = findViewById(R.id.t1);
        t4 = findViewById(R.id.data_text);



    }
}