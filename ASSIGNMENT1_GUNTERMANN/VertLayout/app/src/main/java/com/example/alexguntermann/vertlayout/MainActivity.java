package com.example.alexguntermann.vertlayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends Activity {


    EditText billInput;
    TextView tv5;
    TextView tv10;
    TextView tv15;

    SeekBar seekBar;

    TextView seekPercent;

    TextView finalCustomTotal;

    Button calculateButton;

    double bill;
    final double calculate5Percent = 0;
    final double calculate10Percent = 0;
    final double calculate15Percent = 0;
    final double calculateCustom = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_vertical);

        // edit text input
        billInput = (EditText) findViewById(R.id.enterTip);

        seekBar = findViewById(R.id.seekBarTip);
        seekBar.setMax(50);
        seekBar.setProgress(16);
        calculateButton = findViewById(R.id.calculateButton);
        seekPercent = findViewById(R.id.seekBarTV);








        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekPercent.setText(i + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    if (billInput.getText() != null && !billInput.getText().toString().equals("")) {
                        bill = Double.parseDouble(billInput.getText().toString());
                    } else {

                        Toast.makeText(getApplicationContext(), "Please input an decimal value", Toast.LENGTH_LONG).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "NumberFormatException", Toast.LENGTH_LONG).show();

                }
                // text views to be updated with total amounts based on percentage
                tv5 = findViewById(R.id.with5);
                tv10 = findViewById(R.id.with10);
                tv15 = findViewById(R.id.with15);
                // seek bar

                // text view that displays total amount based on custom percentage
                finalCustomTotal = findViewById(R.id.finalBillCustom);

                // calculate button

                final double seekBarCast = Double.parseDouble(seekPercent.getText().toString());
                 double calculate5Percent = bill * (0.05);
                 double calculate10Percent = bill * (0.10);
                 double calculate15Percent = bill * (0.15);
                 double calculateCustom = bill * (seekBarCast / 100);
                tv5.setText(String.format("$%.2f",calculate5Percent+bill));
                tv10.setText(String.format("$%.2f",calculate10Percent+bill));
                tv15.setText(String.format("$%.2f",calculate15Percent+bill));

                finalCustomTotal.setText(String.format("$%.2f",calculateCustom+bill));
            }
        });


    }

}



