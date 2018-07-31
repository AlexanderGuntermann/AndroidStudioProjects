package com.example.alexguntermann.hw6_universalsupply;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by alexguntermann on 4/25/18.
 */

public class llistView extends BaseAdapter {

    Context context;
    Employees[] individual;


    public llistView(Context conTXT, Employees[] person) {
        context = conTXT;
        individual = person;
    }

    @Override
    public int getCount() {
        return individual.length;
    }

    @Override
    public Object getItem(int i) {
        return 0;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        LayoutInflater inf = LayoutInflater.from(context);

        // if the view is null, set it to be the one created in the layout resource file
        if (convertView == null) {
            view = inf.inflate(R.layout.individual_person_layout, null, true);
        } else {

            view = convertView;
        }

            // set all properties inside of the view based on their ID
            TextView name = (TextView) view.findViewById(R.id.Name);
            TextView age = (TextView) view.findViewById(R.id.Age);
            TextView salary = (TextView) view.findViewById(R.id.Salary);
            TextView food1 = (TextView) view.findViewById(R.id.food1);
            TextView food2 = (TextView) view.findViewById(R.id.food2);
            ImageView gender = (ImageView) view.findViewById(R.id.genderpicture);
            ImageView diet = (ImageView) view.findViewById(R.id.meatImg);
            ImageView color = (ImageView) view.findViewById(R.id.colorpicture);

            // set each TextView based on the array with each individual
            name.setText(individual[position].getFullName());
            age.setText("Age: "+ individual[position].getAge());
            salary.setText("Salary: "+individual[position].getSalary());
            food1.setText(individual[position].getFavorite_food1());
            food2.setText(individual[position].getFavorite_food2());

            // check the gender of the person and load the correct image based on their gender

        if(individual[position].getGender().equalsIgnoreCase("male")){
            gender.setImageResource(R.drawable.male);
        }else if(individual[position].getGender().equalsIgnoreCase("female")){
            gender.setImageResource(R.drawable.female);
        }

        // now check the diet from the Employees object and set the correct diet image

        if (individual[position].getDiet().equalsIgnoreCase("redMeat")){
            diet.setImageResource(R.drawable.redmeat);
        } else if (individual[position].getDiet().equalsIgnoreCase("poultry")){
            diet.setImageResource(R.drawable.poultry);
        } else if (individual[position].getDiet().equalsIgnoreCase("vegetarian")) {
            diet.setImageResource(R.drawable.vegetarian);
        }

            // now check the color from the Employees object and set the correct color to the image





    if(individual[position].getFavorite_color().equalsIgnoreCase("orange")){
        color.setColorFilter(0xffff6600);
    }else if(individual[position].getFavorite_color().equalsIgnoreCase("blue")){
        color.setColorFilter(0xff0000ff);
    }else if(individual[position].getFavorite_color().equalsIgnoreCase("yellow")){
        color.setColorFilter(0xffffff00);
    }else if(individual[position].getFavorite_color().equalsIgnoreCase("green")){
        color.setColorFilter(0xff00c000);
    }else if(individual[position].getFavorite_color().equalsIgnoreCase("red")){
        color.setColorFilter(0xffff0000);
    }





        Log.d("all info",""+individual[position].getFullName()+" "+individual[position].getGender()
                +" "+individual[position].getDiet()+" "+individual[position].getFavorite_food1()+" "+individual[position].getFavorite_food2()
        +" "+individual[position].getFavorite_color()+" "+individual[position].getAge()+" "+ individual[position].getSalary());


        // return the view

        return view;
    }
}



