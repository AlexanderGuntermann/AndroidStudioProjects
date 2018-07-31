package com.example.alexguntermann.helloflags;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String [] allRegionsArray = {"Africa","Asia", "Europe", "North America", "South America"};
    Button button;
    Intent intent;
    ArrayList<Integer> selectedRegions = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative_main_menu);




    }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.regions, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {

            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();
            if (id == R.id.Regions) {
                alertDialogCreation();
                return true;
            }
            return super.onOptionsItemSelected(item);
        }

    public void alertDialogCreation() {
        AlertDialog dialog = new AlertDialog.Builder(this).setTitle("Select a Region")
                .setMultiChoiceItems(allRegionsArray, null, new DialogInterface.OnMultiChoiceClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int num, boolean isChecked) {
                        if (isChecked) {
                            // when an item is selected, add it to the selectedRegions list
                            selectedRegions.add(num);

                        } else if (selectedRegions.contains(num)) {
                            // if the item already exists, remove it.
                            selectedRegions.remove(Integer.valueOf(num));
                        }
                    }
                }).setPositiveButton("Start", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        if (selectedRegions.isEmpty()) {

                            Toast.makeText(getApplicationContext(), "Please Select a Region", Toast.LENGTH_LONG).show();
                            alertDialogCreation();

                        } else if(selectedRegions.size() < 4) {
                            Toast.makeText(getApplicationContext(), "Please Select at least 4 Regions", Toast.LENGTH_LONG).show();
                            alertDialogCreation();
                            selectedRegions.clear();

                        } else {
                            Intent intent = new Intent(MainActivity.this, FrameLayout.class);
                            intent.putIntegerArrayListExtra("regions", selectedRegions);
                            startActivity(intent);
                            selectedRegions.clear();

                        }
                    }
                }).create();
        dialog.show();
    }








}

