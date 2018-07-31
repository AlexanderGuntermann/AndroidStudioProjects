package com.example.alexguntermann.hw6_universalsupply;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by alexguntermann on 4/27/18.
 */

public class InfoAndPic extends AppCompatActivity {


    Button button;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);


        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(InfoAndPic.this,MainActivity.class);
                startActivityForResult(intent,0);
            }
        });





    }
}