package com.example.alexguntermann.calculator;

import android.util.Log;

/**
 * Created by alexguntermann on 2/6/18.
 */

public class Variable {


    String operandOne = "";
    String operandTwo = "";
    String operator = "";


    // false = phase 1
    // true = phase 2
    boolean phase = false;
    boolean justFinished = false;

    public double computation(){



        double d_operandOne = Double.parseDouble(operandOne);
        double d_operandTwo = Double.parseDouble(operandTwo);
        Log.d("op1",operandOne);
        Log.d("op2",operandTwo);
        Log.d("op",operator);
        switch(operator){
            case "+":
                return d_operandOne+d_operandTwo;


            case "-":
                return d_operandOne-d_operandTwo;
            case "*":
                return d_operandOne*d_operandTwo;
            case "/":
                return d_operandOne/d_operandTwo;

        }
        return 0;



    }



}
