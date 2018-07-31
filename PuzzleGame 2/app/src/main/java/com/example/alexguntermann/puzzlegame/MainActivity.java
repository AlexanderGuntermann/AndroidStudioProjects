package com.example.alexguntermann.puzzlegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button button;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);


        button = findViewById(R.id.playGameButton);

        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, PlayGame.class);
                startActivityForResult(intent, 0);
            }
        });


    }
}