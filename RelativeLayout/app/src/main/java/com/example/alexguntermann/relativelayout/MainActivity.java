package com.example.alexguntermann.relativelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button ab, fb;
    Spinner spinner1;
    TextView bottomView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //forLayout1();
        forLayout2();
    }

    void forLayout2(){
        //set the layout first
        setContentView(R.layout.main2_relative_layout);
        spinner1 = findViewById(R.id.spinner1);
        bottomView = findViewById(R.id.textView);

        List<String> thelist = new ArrayList<>();

        thelist.add("doritos");
        thelist.add("chipahoy");
        thelist.add("kit-kat");
        thelist.add("almond-joy");

        // change the spinner info

        ArrayAdapter<String>adapter = new ArrayAdapter<String>(MainActivity.this,
                    android.R.layout.simple_spinner_item,thelist);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);

        // create a listener for the spinner

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int selected, long id) {
                bottomView.setText("Selected row: " + selected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

            void forLayout1() {
                ab = findViewById(R.id.middlebutton);
                fb = findViewById(R.id.floatbutton);

                ab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        view.setVisibility(View.GONE);
                    }
                });


                fb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ab.setVisibility(View.VISIBLE);
                    }
                });
            }
        });
    }

    void eventLayout() {
        setContentView(R.layout.main_relative_event);
        ab = findViewById(R.id.middlebutton);
        bottomView = findViewById(R.id.textView);

//        ab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//    }
//
//    @Override
//    public void onClick(View view) {
//
//   //implement of class

        ab.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}





