package com.example.alexguntermann.mylayouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // global references

    TextView tv1;
    SeekBar thebar;
    Button b1;
    int changer = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // always set the layout (tell the app where to get the views from)
        setContentView(R.layout.main_lllineartext);

        // get references of views

        //change the default value of the seek bar

        thebar.setMax(50);

        // it simply is returning a view. It doesn't know the type. You have to cast it.
        tv1 = (TextView)findViewById(R.id.numbervalue);

        thebar = (SeekBar)findViewById(R.id.seekBar);

        b1 = (Button)findViewById(R.id.button9);

        b1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      changer++;
                                      tv1.setText(changer+"");
                                  }
                              });

                // add a listener to the seekbar

                thebar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


                    @Override //change the seekbar text
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        // change the text of the text view

                        tv1.setText(i + "");

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
    }
}
