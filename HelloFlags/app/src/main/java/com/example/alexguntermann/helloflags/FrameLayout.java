package com.example.alexguntermann.helloflags;

import android.animation.Animator;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by alexguntermann on 2/19/18.
 */

public class FrameLayout extends MainActivity implements View.OnClickListener {


    Bundle infoFromPreviousActivity;
    ArrayList<RegionsFormat> regionsFormats;

    ArrayList<Integer> regions;
    TextView level, round, select_region;
    String[] Africa, Asia, Europe, North_America, South_America;

    static String correctName, wrongName1, wrongName2, wrongName3;
    ImageView flagImage1, flagImage2, flagImage3, flagImage4;
    Drawable theFlag1, theFlag2, theFlag3, theFlag4;
    Button btn1, btn2, btn3, btn4;
    int count = 0;
    static int roundCounter = 1;
    static int levelCounter = 1;

    Random random;

    int incorrectCounter = 0;
    Animation shake;
    Animation fade;
    Button[] arrayBtns = new Button[4];


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.flag_frame_layout);

        // obtain selected regions from previous activity
        infoFromPreviousActivity = getIntent().getExtras();
        regions = infoFromPreviousActivity.getIntegerArrayList("regions");


        flagImage1 = findViewById(R.id.flag1);
        flagImage2 = findViewById(R.id.flag2);
        flagImage3 = findViewById(R.id.flag3);
        flagImage4 = findViewById(R.id.flag4);

        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);

        level = findViewById(R.id.level);
        round = findViewById(R.id.round);
        select_region = findViewById(R.id.selectRegion);

        arrayBtns[0] = btn1;
        arrayBtns[1] = btn2;
        arrayBtns[2] = btn3;
        arrayBtns[3] = btn4;


        // when guessed correctly, present images fade out
        fade = AnimationUtils.loadAnimation(this, R.anim.fade);
        fade.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                for (int i = 0; i < arrayBtns.length; i++) {
                    arrayBtns[i].setEnabled(false);
                }
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                for (int i = 0; i < arrayBtns.length; i++) {
                    arrayBtns[i].setEnabled(true);
                }


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        shake = AnimationUtils.loadAnimation(this, R.anim.shake);
        shake.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                for (int i = 0; i < arrayBtns.length; i++) {
                    arrayBtns[i].setEnabled(false);
                }
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                for (int i = 0; i < arrayBtns.length; i++) {
                    arrayBtns[i].setEnabled(true);
                }

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        // round 1 - 4 flags / 4 buttons / 4 correct answers advance player to next round


        level.setText("Level 1 ");
        round.setText(" - Round " + roundCounter);
        select_region.setText("Select Region:");


        // must have this method to set location of various views in the layout
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        android.widget.FrameLayout.LayoutParams pp = new android.widget.FrameLayout.LayoutParams
                ((int) (width * 0.30), (int) (width * 0.32));
        pp.setMargins((int) (width * .15), (int) (height * .01), 0, 0);
        round.setLayoutParams(pp);

        pp = new android.widget.FrameLayout.LayoutParams((int) (width * 0.30), (int) (height * 0.2));
        pp.setMargins((int) (width * .01), (int) (height * 0.01), 0, 0);
        level.setLayoutParams(pp);


        pp = new android.widget.FrameLayout.LayoutParams((int) (width * 0.30), (int) (height * 0.2));
        pp.setMargins((int) (width * .40), (int) (height * 0.55), 0, 0);
        select_region.setLayoutParams(pp);

        //flag imageViews and their dimensions / positions on the FrameLayout

        pp = new android.widget.FrameLayout.LayoutParams((int) (width * 0.40), (int) (width * 0.32));
        pp.setMargins((int) (width * .05), (int) (height * 0.075), 0, 0);
        flagImage1.setLayoutParams(pp);

        pp = new android.widget.FrameLayout.LayoutParams((int) (width * 0.40), (int) (width * 0.32));
        pp.setMargins((int) (width * .05), (int) (height * 0.3), 0, 0);
        flagImage2.setLayoutParams(pp);

        pp = new android.widget.FrameLayout.LayoutParams((int) (width * 0.40), (int) (width * 0.32));
        pp.setMargins((int) (width * .50), (int) (height * 0.075), 0, 0);
        flagImage3.setLayoutParams(pp);

        pp = new android.widget.FrameLayout.LayoutParams((int) (width * 0.40), (int) (width * 0.32));
        pp.setMargins((int) (width * .50), (int) (height * 0.3), 0, 0);
        flagImage4.setLayoutParams(pp);


        // dimensions for the buttons and their location on the layout
        pp = new android.widget.FrameLayout.LayoutParams((int) (width * 0.40), (int) (height * 0.1));
        pp.setMargins((int) (width * .05), (int) (height * 0.60), 0, 0);
        btn1.setLayoutParams(pp);

        pp = new android.widget.FrameLayout.LayoutParams((int) (width * 0.40), (int) (height * 0.1));
        pp.setMargins((int) (width * .05), (int) (height * 0.70), 0, 0);
        btn2.setLayoutParams(pp);

        pp = new android.widget.FrameLayout.LayoutParams((int) (width * 0.40), (int) (height * 0.1));
        pp.setMargins((int) (width * .50), (int) (height * 0.60), 0, 0);
        btn3.setLayoutParams(pp);

        pp = new android.widget.FrameLayout.LayoutParams((int) (width * 0.40), (int) (height * 0.1));
        pp.setMargins((int) (width * .50), (int) (height * 0.70), 0, 0);
        btn4.setLayoutParams(pp);


        try {
            initializeImages();

        } catch (IOException e) {
            e.printStackTrace();
        }


        flagImage1.setImageDrawable(theFlag1);
        flagImage2.setImageDrawable(theFlag2);
        flagImage3.setImageDrawable(theFlag3);
        flagImage4.setImageDrawable(theFlag4);

        Log.i("answer", correctName);

        randomizeButtons();

    }

    public void randomizeButtons() {
        for (int i = 0; i <regionsFormats.size(); i++) {
            RegionsFormat f = regionsFormats.get(i);

            btn1.setText(f.getCorrectName());
            btn1.setOnClickListener(this);
            for (int j = 0; j < f.getWrongNames().size(); j++) {
                switch(j){
                    case 0:
                        btn2.setText(f.getWrongNames().get(j));
                        btn2.setOnClickListener(this);
                        break;

                    case 1:
                        btn3.setText(f.getWrongNames().get(j));
                        btn3.setOnClickListener(this);
                        break;
                    case 2:
                        btn4.setText(f.getWrongNames().get(j));
                        btn4.setOnClickListener(this);
                        break;
                }
            }

        }
//        int pickBtn = random.nextInt(4);
//
//        if (pickBtn == 0) {
//            btn1.setText(correctName);
//            btn1.setOnClickListener(this);
//            btn2.setText(wrongName1);
//            btn2.setOnClickListener(this);
//            btn3.setText(wrongName2);
//            btn3.setOnClickListener(this);
//            btn4.setText(wrongName3);
//            btn4.setOnClickListener(this);
//
//
//        } else if (pickBtn == 1) {
//            btn1.setText(wrongName1);
//            btn1.setOnClickListener(this);
//            btn2.setText(correctName);
//            btn2.setOnClickListener(this);
//            btn3.setText(wrongName2);
//            btn3.setOnClickListener(this);
//            btn4.setText(wrongName3);
//            btn4.setOnClickListener(this);
//
//        } else if (pickBtn == 2) {
//            btn1.setText(wrongName1);
//            btn1.setOnClickListener(this);
//            btn2.setText(wrongName2);
//            btn2.setOnClickListener(this);
//            btn3.setText(correctName);
//            btn3.setOnClickListener(this);
//            btn4.setText(wrongName3);
//            btn4.setOnClickListener(this);
//        } else if (pickBtn == 3) {
//            btn1.setText(wrongName1);
//            btn1.setOnClickListener(this);
//            btn2.setText(wrongName2);
//            btn2.setOnClickListener(this);
//            btn3.setText(wrongName3);
//            btn3.setOnClickListener(this);
//            btn4.setText(correctName);
//            btn4.setOnClickListener(this);
//        }
    }
//            }if (count == 4) {
//                }
//                    levelCounter++;
//                    level.setText("Level " + levelCounter);
//                    playGameLevelTwo();
//                }
//                if (count == 7) {
//                    levelCounter++;
//                    level.setText("Level " + levelCounter);
//
//                    playGameLevelThree();
//                }
//                if (count == 9) {
//                    levelCounter++;
//                    level.setText("Level " + levelCounter);
//
//                    playGameLevelFour();
//                }
//                if (count == 10) {
//                    AlertDialog dialog = new AlertDialog.Builder(this).setTitle("YOU WIN!!!!!!!!!!s! Click to restart" +
//                            " the game and select 4 or more regions").setPositiveButton("Restart",
//                            new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog, int id) {
//                                    incorrectCounter = 0;
//                                    Intent intent = new Intent();
//                                    setResult(0, intent);
//                                    finish();
//
//
//                                }
//
//
//                            }).create();
//                    dialog.show();


    public void initializeImages() throws IOException {


        AssetManager assets = getAssets();
        InputStream imageStream;

        // loads all images into the assets list by tag
        for (int i = 0; i < regions.size(); i++) {
            if (Integer.valueOf(regions.get(i)) == 0) {
                Africa = assets.list("Africa");
            }
            if (Integer.valueOf(regions.get(i)) == 1) {
                Asia = assets.list("Asia");
            }
            if (Integer.valueOf(regions.get(i)) == 2) {
                Europe = assets.list("Europe");
            }
            if (Integer.valueOf(regions.get(i)) == 3) {
                North_America = assets.list("North_America");
            }
            if (Integer.valueOf(regions.get(i)) == 4) {
                South_America = assets.list("South_America");
            }


        }

        // add images here

        random = new Random();
        int randomRegion = random.nextInt(regions.size());

        regionsFormats = new ArrayList<>(regions.size());

        while(!regions.contains(randomRegion)) {

            // Pick a correct region
            randomRegion = random.nextInt(regions.size());

        }

        // If we get here, a correct region was selected

        // Set images
        for (int i = 0; i < regions.size(); i++) {

            RegionsFormat regionsFormat = new RegionsFormat();
            String [] regionArray = new String[0];
            String fileName = "";
            ArrayList<String> wrongNames = new ArrayList<>();
            switch (randomRegion) {
                case 0:
                    regionArray = Africa;
                    fileName = "Africa/";
                    correctName = "Africa";
                    wrongNames.add("Asia");
                    wrongNames.add("North_America");
                    wrongNames.add("South_America");
                    wrongNames.add("Europe");
                    break;
                case 1:
                    regionArray = Asia;
                    fileName = "Asia/";
                    correctName = "Asia";
                    wrongNames.add("South_America");
                    wrongNames.add("North_America");
                    wrongNames.add("Africa");
                    wrongNames.add("Europe");
                    break;
                case 2:
                    regionArray = Europe;
                    fileName = "Europe/";
                    correctName = "Europe";
                    wrongNames.add("Asia");
                    wrongNames.add("North_America");
                    wrongNames.add("Africa");
                    wrongNames.add("South_America");
                    break;
                case 3:
                    regionArray = North_America;
                    fileName = "North_America/";
                    correctName = "North_America";
                    wrongNames.add("Asia");
                    wrongNames.add("South_America");
                    wrongNames.add("Africa");
                    wrongNames.add("Europe");
                    break;
                case 4:
                    regionArray = South_America;
                    fileName = "South_America/";
                    correctName = "South_America";
                    wrongNames.add("Asia");
                    wrongNames.add("North_America");
                    wrongNames.add("Africa");
                    wrongNames.add("Europe");
                    break;
                    default:
                        break;

            }
            for (int j = 0; j < 4; j++) { // ALL FLAGS

                ArrayList<Drawable> flags = new ArrayList<>();
            int randomIndex = random.nextInt(regionArray.length);
                imageStream = getAssets().open(fileName + regionArray[randomIndex]);
                theFlag1 = Drawable.createFromStream(imageStream, null);
                flags.add(theFlag1);

                randomIndex = random.nextInt(regionArray.length);
                imageStream = getAssets().open(fileName+ regionArray[randomIndex]);
                theFlag2 = Drawable.createFromStream(imageStream, null);
                flags.add(theFlag2);

                randomIndex = random.nextInt(regionArray.length);
                imageStream = getAssets().open(fileName + regionArray[randomIndex]);
                theFlag3 = Drawable.createFromStream(imageStream, null);
                flags.add(theFlag3);

                randomIndex = random.nextInt(regionArray.length);
                imageStream = getAssets().open(fileName + regionArray[randomIndex]);
                theFlag4 = Drawable.createFromStream(imageStream, null);
                flags.add(theFlag4);

                regionsFormat.setFlags(flags);
            }

            regionsFormat.setCorrectName(correctName);
         regionsFormat.setWrongNames(wrongNames);

         regionsFormats.add(regionsFormat);

//                correctName = "Africa";
//                wrongName1 = "Asia";
//                wrongName2 = "Europe";
//                wrongName3 = "North America";
        }

//        // if the size of regions is 4, randomly pick from the 4 regions selected
//        if (regions.size() == 4) {
//
//            Log.i("regions contents", ""+regions);
//
//
//            Log.i("random numbers", ""+randomRegion);
//
//
//            int randomS_America = -1;
//
//            int randomAfrica = -1;
//            int randomAsia = -1;
//            int randomEurope = -1;
//            int randomN_America = -1;
//            for (int i = 0; i < regions.size(); i++) {
//                if (Integer.valueOf(regions.get(i)) == 0) {
//                    Africa = assets.list("Africa");
//                    randomAfrica = random.nextInt(Africa.length);
//                }
//                if (Integer.valueOf(regions.get(i)) == 1) {
//                    Asia = assets.list("Asia");
//                    randomAsia = random.nextInt(Asia.length);
//                }
//                if (Integer.valueOf(regions.get(i)) == 2) {
//                    Europe = assets.list("Europe");
//                    randomEurope = random.nextInt(Europe.length);
//                }
//                if (Integer.valueOf(regions.get(i)) == 3) {
//                    North_America = assets.list("North_America");
//                    randomN_America = random.nextInt(North_America.length);
//                }
//                if (Integer.valueOf(regions.get(i)) == 4) {
//                    South_America = assets.list("South_America");
//                    randomS_America = random.nextInt(South_America.length);
//
//                }
//
//
//            }
//
//
////Africa
//            if (randomRegion == 0) {
//                imageStream = getAssets().open("Africa/" + Africa[randomAfrica]);
//                theFlag1 = Drawable.createFromStream(imageStream, null);
//                randomAfrica = random.nextInt(Africa.length);
//                imageStream = getAssets().open("Africa/" + Africa[randomAfrica]);
//                theFlag2 = Drawable.createFromStream(imageStream, null);
//                randomAfrica = random.nextInt(Africa.length);
//                imageStream = getAssets().open("Africa/" + Africa[randomAfrica]);
//                theFlag3 = Drawable.createFromStream(imageStream, null);
//                randomAfrica = random.nextInt(Africa.length);
//                imageStream = getAssets().open("Africa/" + Africa[randomAfrica]);
//                theFlag4 = Drawable.createFromStream(imageStream, null);
//
//                correctName = "Africa";
//                wrongName1 = "Asia";
//                wrongName2 = "Europe";
//                wrongName3 = "North America";
//
//
//// ASIA
//            }
//            if (randomRegion == 1) {
//                imageStream = getAssets().open("Asia/" + Asia[randomAsia]);
//                theFlag1 = Drawable.createFromStream(imageStream, null);
//                randomAsia = random.nextInt(Asia.length);
//                imageStream = getAssets().open("Asia/" + Asia[randomAsia]);
//                theFlag2 = Drawable.createFromStream(imageStream, null);
//                randomAsia = random.nextInt(Asia.length);
//                imageStream = getAssets().open("Asia/" + Asia[randomAsia]);
//                theFlag3 = Drawable.createFromStream(imageStream, null);
//                randomAsia = random.nextInt(Asia.length);
//                imageStream = getAssets().open("Asia/" + Asia[randomAsia]);
//                theFlag4 = Drawable.createFromStream(imageStream, null);
//
//                correctName = "Asia";
//                wrongName1 = "Africa";
//                wrongName2 = "Europe";
//                wrongName3 = "North America";
//// EUROPE
//            }
//            if (randomRegion == 2) {
//                imageStream = getAssets().open("Europe/" + Europe[randomEurope]);
//                theFlag1 = Drawable.createFromStream(imageStream, null);
//                randomEurope = random.nextInt(Europe.length);
//                imageStream = getAssets().open("Europe/" + Europe[randomEurope]);
//                theFlag2 = Drawable.createFromStream(imageStream, null);
//                randomEurope = random.nextInt(Europe.length);
//                imageStream = getAssets().open("Europe/" + Europe[randomEurope]);
//                theFlag3 = Drawable.createFromStream(imageStream, null);
//                randomEurope = random.nextInt(Europe.length);
//                imageStream = getAssets().open("Europe/" + Europe[randomEurope]);
//                theFlag4 = Drawable.createFromStream(imageStream, null);
//
//                correctName = "Europe";
//                wrongName1 = "Africa";
//                wrongName2 = "Asia";
//                wrongName3 = "North America";
//// N AMERICA
//            }
//            if (randomRegion == 3) {
//                imageStream = getAssets().open("North_America/" + North_America[randomN_America]);
//                theFlag1 = Drawable.createFromStream(imageStream, null);
//                randomN_America = random.nextInt(North_America.length);
//                imageStream = getAssets().open("North_America/" + North_America[randomN_America]);
//                theFlag2 = Drawable.createFromStream(imageStream, null);
//                randomN_America = random.nextInt(North_America.length);
//                imageStream = getAssets().open("North_America/" + North_America[randomN_America]);
//                theFlag3 = Drawable.createFromStream(imageStream, null);
//                randomN_America = random.nextInt(North_America.length);
//                imageStream = getAssets().open("North_America/" + North_America[randomN_America]);
//                theFlag4 = Drawable.createFromStream(imageStream, null);
//
//                correctName = "North America";
//                wrongName1 = "Africa";
//                wrongName2 = "Asia";
//                wrongName3 = "Europe";
////
//
//                // if 5 regions were picked, randomly pick 4 out of the 5 for the game



//            int randomAfrica = random.nextInt(Africa.length);
//            int randomAsia = random.nextInt(Asia.length);
//            int randomEurope = random.nextInt(Europe.length);
//            int randomN_America = random.nextInt(North_America.length);
//            int randomS_America = random.nextInt(South_America.length);


//Africa
//            if (randomRegion == 0) {
//                imageStream = getAssets().open("Africa/" + Africa[randomAfrica]);
//                theFlag1 = Drawable.createFromStream(imageStream, null);
//                randomAfrica = random.nextInt(Africa.length);
//                imageStream = getAssets().open("Africa/" + Africa[randomAfrica]);
//                theFlag2 = Drawable.createFromStream(imageStream, null);
//                randomAfrica = random.nextInt(Africa.length);
//                imageStream = getAssets().open("Africa/" + Africa[randomAfrica]);
//                theFlag3 = Drawable.createFromStream(imageStream, null);
//                randomAfrica = random.nextInt(Africa.length);
//                imageStream = getAssets().open("Africa/" + Africa[randomAfrica]);
//                theFlag4 = Drawable.createFromStream(imageStream, null);
//
//                correctName = "Africa";
//                wrongName1 = "Asia";
//                wrongName2 = "Europe";
//                wrongName3 = "North America";
//
//
//// ASIA
//            }
//            if (randomRegion == 1) {
//                imageStream = getAssets().open("Asia/" + Asia[randomAsia]);
//                theFlag1 = Drawable.createFromStream(imageStream, null);
//                randomAsia = random.nextInt(Asia.length);
//                imageStream = getAssets().open("Asia/" + Asia[randomAsia]);
//                theFlag2 = Drawable.createFromStream(imageStream, null);
//                randomAsia = random.nextInt(Asia.length);
//                imageStream = getAssets().open("Asia/" + Asia[randomAsia]);
//                theFlag3 = Drawable.createFromStream(imageStream, null);
//                randomAsia = random.nextInt(Asia.length);
//                imageStream = getAssets().open("Asia/" + Asia[randomAsia]);
//                theFlag4 = Drawable.createFromStream(imageStream, null);
//
//                correctName = "Asia";
//                wrongName1 = "Africa";
//                wrongName2 = "Europe";
//                wrongName3 = "North America";
//// EUROPE
//            }
//            if (randomRegion == 2) {
//                imageStream = getAssets().open("Europe/" + Europe[randomEurope]);
//                theFlag1 = Drawable.createFromStream(imageStream, null);
//                randomEurope = random.nextInt(Europe.length);
//                imageStream = getAssets().open("Europe/" + Europe[randomEurope]);
//                theFlag2 = Drawable.createFromStream(imageStream, null);
//                randomEurope = random.nextInt(Europe.length);
//                imageStream = getAssets().open("Europe/" + Europe[randomEurope]);
//                theFlag3 = Drawable.createFromStream(imageStream, null);
//                randomEurope = random.nextInt(Europe.length);
//                imageStream = getAssets().open("Europe/" + Europe[randomEurope]);
//                theFlag4 = Drawable.createFromStream(imageStream, null);
//
//                correctName = "Europe";
//                wrongName1 = "Africa";
//                wrongName2 = "Asia";
//                wrongName3 = "North America";
//// N AMERICA
//            }
//            if (randomRegion == 3) {
//                imageStream = getAssets().open("North_America/" + North_America[randomN_America]);
//                theFlag1 = Drawable.createFromStream(imageStream, null);
//                randomN_America = random.nextInt(North_America.length);
//                imageStream = getAssets().open("North_America/" + North_America[randomN_America]);
//                theFlag2 = Drawable.createFromStream(imageStream, null);
//                randomN_America = random.nextInt(North_America.length);
//                imageStream = getAssets().open("North_America/" + North_America[randomN_America]);
//                theFlag3 = Drawable.createFromStream(imageStream, null);
//                randomN_America = random.nextInt(North_America.length);
//                imageStream = getAssets().open("North_America/" + North_America[randomN_America]);
//                theFlag4 = Drawable.createFromStream(imageStream, null);
//
//                correctName = "North America";
//                wrongName1 = "Africa";
//                wrongName2 = "Asia";
//                wrongName3 = "Europe";
//
//            }
//            if (randomRegion == 4) {
//                imageStream = getAssets().open("South_America/" + South_America[randomS_America]);
//                theFlag1 = Drawable.createFromStream(imageStream, null);
//                randomS_America = random.nextInt(South_America.length);
//                imageStream = getAssets().open("South_America/" + South_America[randomS_America]);
//                theFlag2 = Drawable.createFromStream(imageStream, null);
//                randomS_America = random.nextInt(South_America.length);
//                imageStream = getAssets().open("South_America/" + South_America[randomS_America]);
//                theFlag3 = Drawable.createFromStream(imageStream, null);
//                randomS_America = random.nextInt(South_America.length);
//                imageStream = getAssets().open("South_America/" + South_America[randomS_America]);
//                theFlag4 = Drawable.createFromStream(imageStream, null);
//
//                correctName = "South America";
//                wrongName1 = "Africa";
//                wrongName2 = "Asia";
//                wrongName3 = "North America";
//
//
//            }
//
//        }

    }


    public void onClick(View v) {
        // TODO Auto-generated method stub
        Button btn;
        if (v instanceof Button) {
            btn = (Button) v;


            // if the answer is correct and in round 1, then...
            if (btn.getText().equals(correctName) && count < 4) {
                flagImage1.startAnimation(fade);
                flagImage2.startAnimation(fade);
                flagImage3.startAnimation(fade);
                flagImage4.startAnimation(fade);

                roundCounter++;

                round.setText("- Round " + roundCounter);

                try {
                    initializeImages();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                randomizeButtons();

                flagImage1.setImageDrawable(theFlag1);
                flagImage2.setImageDrawable(theFlag2);
                flagImage3.setImageDrawable(theFlag3);
                flagImage4.setImageDrawable(theFlag4);
                count++;
                Log.i("answer", correctName);
                Log.i("answer", "" + count);
                Log.i("answer", "" + incorrectCounter);


// if incorrect guess and in round 1...
            } else if (!btn.getText().equals(correctName) && count < 4) {
                flagImage1.startAnimation(shake);
                flagImage2.startAnimation(shake);
                flagImage3.startAnimation(shake);
                flagImage4.startAnimation(shake);

                roundCounter++;
                round.setText("- Round " + roundCounter);

                try {
                    initializeImages();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                randomizeButtons();
                flagImage1.setImageDrawable(theFlag1);
                flagImage2.setImageDrawable(theFlag2);
                flagImage3.setImageDrawable(theFlag3);
                flagImage4.setImageDrawable(theFlag4);
                incorrectCounter++;
                Log.i("answer", correctName);

                // start of round two
            } else if (count == 4) {
                flagImage4.setVisibility(View.GONE);
                level.setText("Level 2 ");
                //correct guess in round two
                if (btn.getText().equals(correctName)) {
                    flagImage1.startAnimation(fade);
                    flagImage2.startAnimation(fade);
                    flagImage3.startAnimation(fade);
                    count++;

                    roundCounter++;
                    round.setText("- Round " + roundCounter);
                    Log.i("answer", correctName);

                    try {
                        initializeImages();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    randomizeButtons();
                    flagImage1.setImageDrawable(theFlag1);
                    flagImage2.setImageDrawable(theFlag2);
                    flagImage3.setImageDrawable(theFlag3);

                } else {

                    flagImage1.startAnimation(shake);
                    flagImage2.startAnimation(shake);
                    flagImage3.startAnimation(shake);
                    incorrectCounter++;

                    roundCounter++;
                    round.setText("- Round " + roundCounter);
                    Log.i("answer", correctName);

                    try {
                        initializeImages();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    randomizeButtons();
                    flagImage1.setImageDrawable(theFlag1);
                    flagImage2.setImageDrawable(theFlag2);
                    flagImage3.setImageDrawable(theFlag3);

                }
            } else if (btn.getText().equals(correctName) && count >= 4 && count < 7) {
                flagImage1.startAnimation(fade);
                flagImage2.startAnimation(fade);
                flagImage3.startAnimation(fade);
                count++;

                roundCounter++;
                round.setText("- Round " + roundCounter);
                Log.i("answer", correctName);

                try {
                    initializeImages();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.i("answer", correctName);
                randomizeButtons();
                flagImage1.setImageDrawable(theFlag1);
                flagImage2.setImageDrawable(theFlag2);
                flagImage3.setImageDrawable(theFlag3);
            } else if (!btn.getText().equals(correctName) && count >= 4 && count < 7) {
                flagImage1.startAnimation(shake);
                flagImage2.startAnimation(shake);
                flagImage3.startAnimation(shake);
                incorrectCounter++;

                roundCounter++;
                round.setText("- Round " + roundCounter);
                Log.i("answer", correctName);

                try {
                    initializeImages();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.i("answer", correctName);
                randomizeButtons();
                flagImage1.setImageDrawable(theFlag1);
                flagImage2.setImageDrawable(theFlag2);
                flagImage3.setImageDrawable(theFlag3);

            } else if (count == 7) {
                flagImage4.setVisibility(View.GONE);
                flagImage3.setVisibility(View.GONE);
                level.setText("Level 3 ");
                //correct guess in round two
                if (btn.getText().equals(correctName)) {
                    flagImage1.startAnimation(fade);
                    flagImage2.startAnimation(fade);
                    count++;

                    roundCounter++;
                    round.setText("- Round " + roundCounter);
                    Log.i("answer", correctName);

                    try {
                        initializeImages();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Log.i("answer", correctName);
                    randomizeButtons();
                    flagImage1.setImageDrawable(theFlag1);
                    flagImage2.setImageDrawable(theFlag2);

                } else {

                    flagImage1.startAnimation(shake);
                    flagImage2.startAnimation(shake);
                    incorrectCounter++;

                    roundCounter++;
                    round.setText("- Round " + roundCounter);
                    Log.i("answer", correctName);

                    try {
                        initializeImages();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Log.i("answer", correctName);
                    randomizeButtons();
                    flagImage1.setImageDrawable(theFlag1);
                    flagImage2.setImageDrawable(theFlag2);
                }
            } else if (btn.getText().equals(correctName) && count >= 7 && count < 9) {
                flagImage1.startAnimation(fade);
                flagImage2.startAnimation(fade);
                count++;

                roundCounter++;
                round.setText("- Round " + roundCounter);
                Log.i("answer", correctName);

                try {
                    initializeImages();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.i("answer", correctName);
                randomizeButtons();
                flagImage1.setImageDrawable(theFlag1);
                flagImage2.setImageDrawable(theFlag2);
            } else if (!btn.getText().equals(correctName) && count >= 7 && count < 9) {
                flagImage1.startAnimation(shake);
                flagImage2.startAnimation(shake);
                incorrectCounter++;

                roundCounter++;
                round.setText("- Round " + roundCounter);
                Log.i("answer", correctName);

                try {
                    initializeImages();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.i("answer", correctName);
                randomizeButtons();
                flagImage1.setImageDrawable(theFlag1);
                flagImage2.setImageDrawable(theFlag2);

            } else if (count == 9) {
                flagImage4.setVisibility(View.GONE);
                flagImage3.setVisibility(View.GONE);
                flagImage2.setVisibility(View.GONE);
                level.setText("Level 4 ");
                if (btn.getText().equals(correctName) && count >=9) {
                    flagImage1.startAnimation(fade);
                    count++;

                    roundCounter++;
                    round.setText("- Round " + roundCounter);
                    Log.i("answer", correctName);

                    try {
                        initializeImages();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Log.i("answer", correctName);
                    randomizeButtons();
                    flagImage1.setImageDrawable(theFlag1);

                } else {

                    flagImage1.startAnimation(shake);
                    incorrectCounter++;

                    roundCounter++;
                    round.setText("- Round " + roundCounter);
                    Log.i("answer", correctName);

                    try {
                        initializeImages();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Log.i("answer", correctName);
                    randomizeButtons();
                    flagImage1.setImageDrawable(theFlag1);
                }
            }


            if (incorrectCounter == 3) {


                AlertDialog dialog = new AlertDialog.Builder(this).setTitle("YOU LOST! Click to restart" +
                        " the game and select 4 or more regions").setPositiveButton("Restart",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                incorrectCounter = 0;
                                count = 0;
                                roundCounter = 1;
                                round.setText("- Round " + roundCounter);

                                correctName = "";
                                wrongName1 = "";
                                wrongName2 = "";
                                wrongName3 = "";
                                Intent intent = new Intent();
                                setResult(0, intent);
                                finish();


                            }


                        }).create();
                dialog.show();

            } else
            if (count == 10) {


                AlertDialog dialog = new AlertDialog.Builder(this).setTitle("YOU WON! Click to restart" +
                        " the game and select 4 or more regions").setPositiveButton("Restart",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                incorrectCounter = 0;
                                count = 0;
                                roundCounter = 1;
                                round.setText("- Round " + roundCounter);
                                correctName = "";
                                wrongName1 = "";
                                wrongName2 = "";
                                wrongName3 = "";
                                Intent intent = new Intent();
                                setResult(0, intent);
                                finish();


                            }


                        }).create();
                dialog.show();

            }
        }
    }


//    public void playGameLevelTwo() {
//        level.setText("Level 2");
//        flagImage4.setVisibility(View.INVISIBLE);
//
//
//    }
//
//    public void playGameLevelThree() {
//        level.setText("Level 3");
//        flagImage4.setVisibility(View.INVISIBLE);
//
//
//    }
//
//    public void playGameLevelFour() {
//        level.setText("Level 4");
//        flagImage4.setVisibility(View.INVISIBLE);
//        flagImage3.setVisibility(View.INVISIBLE);
//        flagImage2.setVisibility(View.INVISIBLE);
//
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // super.onActivityResult(requestCode, resultCode, data);
        finish();
    }


}





