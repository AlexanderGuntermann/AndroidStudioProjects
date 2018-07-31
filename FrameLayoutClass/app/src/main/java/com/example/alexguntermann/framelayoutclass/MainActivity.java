package com.example.alexguntermann.framelayoutclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    Button bOne,bTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //set layout
    setContentView(R.layout.main_layout_frame);
    //get references
    bOne = findViewById(R.id.button);
    bTwo = findViewById(R.id.button2);
    //get the size of the screen and save it
    DisplayMetrics metrics =  new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(metrics);
    int width = metrics.widthPixels;
    int height = metrics.heightPixels;

    //set the width and height of the desired view
    FrameLayout.LayoutParams temp = new FrameLayout.LayoutParams((int)(width *.2), (int)(height*.2));
    //set position using margins, last two are right and bottom
        temp.setMargins((int)(width*.4),(int)(height*.2),0,0);
    //set the new param to the view
        bOne.setLayoutParams(temp);
    }
}
