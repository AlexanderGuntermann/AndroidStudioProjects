package com.example.alexguntermann.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_gridlayout);

        final TextView outputBar = findViewById(R.id.textView);
        Button clear = findViewById(R.id.clear);
        Button minus = findViewById(R.id.minus);
        Button multiply = findViewById(R.id.multiply);
        Button divide = findViewById(R.id.divide);
        Button num1 = findViewById(R.id.num1);
        Button num2 = findViewById(R.id.num2);
        Button num3 = findViewById(R.id.num3);
        Button plus = findViewById(R.id.plus);
        Button num4 = findViewById(R.id.num4);
        Button num5 = findViewById(R.id.num5);
        Button num6 = findViewById(R.id.num6);
        Button num7 = findViewById(R.id.num7);
        Button num8 = findViewById(R.id.num8);
        Button num9 = findViewById(R.id.num9);
        Button equal = findViewById(R.id.equals);
        Button num0 =
                findViewById(R.id.num0);
        Button dot = findViewById(R.id.dot);

        final Variable example = new Variable();

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                outputBar.setText("");
                example.operandOne = "";
                example.operandTwo = "";
                example.phase = false;
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (example.phase == false) {
                    if (!example.operandOne.contains(".")) {
                        example.operandOne += "." ;
                        outputBar.setText(example.operandOne);
                    }
                } else {
                    if (!example.operandTwo.contains(".")){
                        example.operandTwo += ".";
                        outputBar.setText(example.operandTwo);
                    }
                }
            }
        });

        Button.OnClickListener numberListener = new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button btn=(Button) view;
                String num=btn.getText().toString();
                if (!example.phase){
                    //in phase 1
                    example.operandOne+=num;
                    outputBar.setText(example.operandOne);
                } else {
                    // in phase 2
                    example.operandTwo+=num;
                    outputBar.setText(example.operandTwo);
                }


            }
        };


        Button.OnClickListener operatorListener = new Button.OnClickListener(){


            @Override
            public void onClick(View view) {
                Button btn=(Button) view;

                switch (view.getId()){
                    case R.id.multiply:
                        example.operator="*";
                        outputBar.setText("*");
                        break;
                    case R.id.minus:
                        example.operator="-";
                        outputBar.setText("-");
                        break;
                    case R.id.divide:
                        example.operator="/";
                        outputBar.setText("/");
                        break;
                    case R.id.plus:
                        example.operator="+";
                        outputBar.setText("+");
                        break;
                    case R.id.equals:
                        if (example.phase==false){
                            return;
                        }
                        double result=example.computation();
                        example.operandOne = result+"";
                        example.justFinished=true;
                        outputBar.setText(result+"");
                        example.operandTwo="";


                        break;

                }
                example.phase=!example.phase;//phase 2


            }
        };
        num0.setOnClickListener(numberListener);
        num1.setOnClickListener(numberListener);
        num2.setOnClickListener(numberListener);
        num3.setOnClickListener(numberListener);
        num4.setOnClickListener(numberListener);
        num5.setOnClickListener(numberListener);
        num6.setOnClickListener(numberListener);
        num7.setOnClickListener(numberListener);
        num8.setOnClickListener(numberListener);
        num9.setOnClickListener(numberListener);

        minus.setOnClickListener(operatorListener);
        plus.setOnClickListener(operatorListener);
        multiply.setOnClickListener(operatorListener);
        divide.setOnClickListener(operatorListener);
        equal.setOnClickListener(operatorListener);


    }
}
