package com.example.alexguntermann.relativelayout;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2 extends Activity {


    Button ab, fb;
    Spinner spinner1;
    TextView bottomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);


        //get intent

        Intent tent = getIntent();
        // get string

        String info = tent.getStringExtra("wave");

        Toast ff = Toast.makeText(Main2.this,info, Toast.LENGTH_SHORT);

        ff.show();
    }
}
