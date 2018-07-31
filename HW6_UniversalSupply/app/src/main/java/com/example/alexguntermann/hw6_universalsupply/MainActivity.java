package com.example.alexguntermann.hw6_universalsupply;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQL_DB db;
    SQLiteDatabase dbLite;
    static SharedPreferences sharedPref;
    boolean startCreate;
    boolean created;
    Cursor cursor, cursor2;
    int numCounter = 0;
    ListView listVIEW;
    llistView customAdapter;
    String first, second;
    int salaryArrayPosition, ageArrayPosition;
    String food1Array, food2Array, genderArray, colorArray, dietArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_layout);


        // creates shared preference
        sharedPref = getSharedPreferences("hello", Context.MODE_PRIVATE);
        db = new SQL_DB(this, "mydb.db", null, 1);


        // create object where database can become readable
        dbLite = db.getReadableDatabase();
        listVIEW = (ListView) findViewById(R.id.listyview);


        // db cursor to select and create queries
        cursor = dbLite.rawQuery("SELECT * FROM employees", null);
        startCreate = sharedPref.getBoolean("hello", false);

        if (!startCreate || cursor.getCount() == 0) {
            try {

                // read all files and store them in array position
                readFilesToArray();
                created = true;
                sharedPref.edit().putBoolean("hello", created).commit();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu_questions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TextView counter = (TextView) findViewById(R.id.counterEntries);
        sharedPref = getSharedPreferences("hello", Context.MODE_PRIVATE);


        switch (item.getItemId()) {

            // query for everyone
            case R.id.Everyone:
                cursor = dbLite.rawQuery("SELECT * FROM employees", null);
                counter.setText(cursor.getCount() + " ");

                break;

            case R.id.likesChicken:
                cursor = dbLite.query("employees", null, "food='chicken' OR food2='chicken'", null, null, null, null);
                counter.setText(cursor.getCount() + " ");
                break;


            case R.id.likesGoat:
                cursor = dbLite.query("employees", null, "food='goat' OR food2='goat'", null, null, null, null);
                counter.setText(cursor.getCount() + " ");
                break;


            case R.id.lessThan60:
                cursor = dbLite.query("employees", null, "salary<60000", null, null, null, null);
                counter.setText(cursor.getCount() + " ");
                break;


            case R.id.youngerThan38:
                cursor = dbLite.query("employees", null, "age<38", null, null, null, null);
                counter.setText(cursor.getCount() + " ");
                break;

            case R.id.likesBlueAndFemale:
                cursor = dbLite.query("employees", null, "gender='female' AND color='blue'", null, null, null, null);
                counter.setText(cursor.getCount() + " ");
                break;

            case R.id.moreThan80:
                cursor = dbLite.query("employees", null, "salary>80000", null, null, null, null);
                counter.setText(cursor.getCount() + " ");
                break;

            case R.id.olderThan30Poultry:
                cursor = dbLite.rawQuery("SELECT * FROM employees WHERE age>30 AND diet='poultry'", null);
                counter.setText(cursor.getCount() + " ");
                break;

            case R.id.turkey2ndAndUnder35:
                cursor = dbLite.query("employees", null, "age<35 AND food2='turkey'", null, null, null, null);
                counter.setText(cursor.getCount() + " ");
                break;
            case R.id.femaleRedAndMeatLover:
                cursor = dbLite.query("employees", null, "gender='female' AND color='red' AND diet='redMeat'", null, null, null, null);
                counter.setText(cursor.getCount() + " ");
                break;
            case R.id.maleVegetarianTofuFirstOrSecond:
                cursor = dbLite.query("employees", null, "gender='male' AND diet='vegetarian' OR food='tofu' OR food2='tofu'", null, null, null, null);
                counter.setText(cursor.getCount() + " ");
                break;
            case R.id.MorOGreen:
                cursor = dbLite.rawQuery("SELECT * FROM employees WHERE color='green' AND (lastname LIKE 'M%' OR lastname LIKE 'O%')", null);
                counter.setText(cursor.getCount() + " ");
                break;
            case R.id.lastInsaneTeamQuery:

                // girls who like green and eat redMeat
                cursor = dbLite.rawQuery("SELECT * FROM employees WHERE color='green' AND diet='redMeat' AND gender='female'", null);

                ArrayList<Employees> list1 = new ArrayList<Employees>();
                ArrayList<Employees> list2 = new ArrayList<Employees>();
                ArrayList<Employees> list3 = new ArrayList<Employees>();


                // traverse through the cursor and add each string to the ArrayList
                while (cursor.moveToNext()) {
                    list1.add(new Employees(cursor.getString(1), cursor.getString(2), cursor.getString(7), cursor.getString(5)
                            , cursor.getString(3), cursor.getString(4), cursor.getString(8), Integer.parseInt(cursor.getString(6)), Integer.parseInt(cursor.getString(9))));
                }

                // males who like yellow and eat poultry
                cursor2 = dbLite.rawQuery("SELECT * FROM employees WHERE color='yellow' AND diet='poultry' AND gender='male'", null);


                while (cursor2.moveToNext()) {
                    list2.add(new Employees(cursor2.getString(1), cursor2.getString(2), cursor2.getString(7), cursor2.getString(5)
                            , cursor2.getString(3), cursor2.getString(4), cursor2.getString(8),
                            Integer.parseInt(cursor2.getString(6)), Integer.parseInt(cursor2.getString(9))));
                }


                // traverse list 1 and check if anyone is over the age of 38 and makes < 95000
                // if they do, append it to list 3.
                for (int i = 0; i < list1.size(); i++) {
                    if (list1.get(i).getAge() > 38 && list1.get(i).getSalary() < 95000) {
                        list3.add(list1.get(i));
                    }

                }

                // traverse list 2 and check if the age is > 38 and if their salary is < 95k
                for (int i = 0; i < list2.size(); i++) {
                    if (list2.get(i).getAge() > 38 && list2.get(i).getSalary() < 95000) {
                        list3.add(list2.get(i));
                    }

                }

                int list3Size = list3.size();


                counter.setText(list3Size + " ");


                for (int i = 0; i < list3.size(); i++) {
                    Log.d("HIIIII", "onOptionsItemSelected: " + list3.get(i).getAge());
                    Log.d("HIIIII", "onOptionsItemSelected: " + list3.get(i).getSalary());

                }


                break;

            case R.id.cleanAndDelete:
                destroyAllDatabaseValues();
                break;


            default:
                return super.onOptionsItemSelected(item);
        }

        Employees[] allUsers = new Employees[cursor.getCount()];
        cursor.moveToFirst();

        //     // String fst,String scnd,String col,String diet,String food,String food2,String gndr,int ag,int sal
        // 1 -- 2 -- 3 -- 4 -- 5 -- 6 -- 7 -- 8 -- 9

//  public Employees(String firstName, String lastName, String favorite_color, String diet,
        //String favorite_food1, String favorite_food2, String gender, int age, int salary) {

        //information.put("firstname", first);
//        information.put("lastname", last);
//        information.put("color", color);
//        information.put("diet", diet);
//        information.put("food", food1);
//        information.put("food2", food2);
//        information.put("gender", gender);
//        information.put("age", age);
//        information.put("salary", salary);

        for (int i = 0; i < cursor.getCount(); i++) {

            //
            allUsers[i] = new Employees(cursor.getString(1), cursor.getString(2), cursor.getString(7), cursor.getString(5)
                    , cursor.getString(3), cursor.getString(4), cursor.getString(8), Integer.parseInt(cursor.getString(6)), Integer.parseInt(cursor.getString(9)));
            cursor.moveToNext();

        }


        customAdapter = new llistView(MainActivity.this, allUsers);
        listVIEW.setAdapter(customAdapter);


        return true;


    }


    // read all txt files and put them in the Database
    public void readFilesToArray() throws IOException {


        InputStreamReader ages = new InputStreamReader(getAssets().open("age.txt"));
        BufferedReader age = new BufferedReader(ages);


        InputStreamReader foods1 = new InputStreamReader(getAssets().open("food.txt"));
        BufferedReader food1 = new BufferedReader(foods1);

        InputStreamReader foods2 = new InputStreamReader(getAssets().open("food2.txt"));

        InputStreamReader genders = new InputStreamReader(getAssets().open("gender.txt"));
        BufferedReader gender = new BufferedReader(genders);

        InputStreamReader salaries = new InputStreamReader(getAssets().open("salary.txt"));
        BufferedReader salary = new BufferedReader(salaries);
        BufferedReader food2 = new BufferedReader(foods2);

        InputStreamReader diets = new InputStreamReader(getAssets().open("diet.txt"));
        BufferedReader diet = new BufferedReader(diets);

        InputStreamReader colors = new InputStreamReader(getAssets().open("colors.txt"));
        BufferedReader color = new BufferedReader(colors);


        InputStreamReader names = new InputStreamReader(getAssets().open("names.txt"));
        BufferedReader name = new BufferedReader(names);


        int i = 0;

        dbLite = db.getReadableDatabase();

        while (i < 100) {
            numCounter++;

            String[] full = name.readLine().split(" ");
            first = full[0];
            second = full[1];
            genderArray = gender.readLine();
            dietArray = diet.readLine();
            food1Array = food1.readLine();
            food2Array = food2.readLine();
            colorArray = color.readLine();
            ageArrayPosition = Integer.parseInt(age.readLine());
            salaryArrayPosition = Integer.parseInt(salary.readLine());


            //(first, second, ageArr, foodArr, salaryArr, genderArr, food2Arr
            //    , dietArr, colorArr);


//        //     // String fst,String scnd,String col,String diet,String food,String food2,String gndr,int ag,int sal

            insertValuesIntoDataBase(first, second, ageArrayPosition, food1Array,
                    salaryArrayPosition, genderArray, food2Array, dietArray, colorArray);

            i++;

            Log.v("Counter", numCounter + "");

        }

        // close all streams reading the info
        dbLite = db.getReadableDatabase();
        ages.close();
        foods1.close();
        foods2.close();
        genders.close();
        salaries.close();
        diets.close();
        colors.close();
        names.close();


    }
    //     // String fst,String scnd,String col,String diet,String food,String food2,String gndr,int ag,int sal

    public void insertValuesIntoDataBase(String first, String last, int age, String food1, int salary,
                                         String gender, String food2, String diet, String color) {


        ContentValues information = new ContentValues();
        information.put("firstname", first);
        information.put("lastname", last);
        information.put("food", food1);
        information.put("food2", food2);
        information.put("salary", salary);
        information.put("age", age);
        information.put("gender", gender);
        information.put("color", color);

        information.put("diet", diet);


        long insert = dbLite.insert("employees", null, information);


        Log.d("Insert status:", insert + "");

    }

    // newer
    public void destroyAllDatabaseValues() {
        db.deleteDataBase();
    }

}
