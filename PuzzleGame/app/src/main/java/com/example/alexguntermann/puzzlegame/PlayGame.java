package com.example.alexguntermann.puzzlegame;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.Random;

/**
 * Created by alexguntermann on 3/18/18.
 */

public class PlayGame extends AppCompatActivity implements View.OnTouchListener {


    // each piece needs an imageView
    private ImageView im1, im2, im3, im4, im5, im6, im7, im8, im9, im10, im11, im12, im13, im14,
            im15, im16, im17, im18, im19, im20, background, ubsymbol;

    private int width;
    private int height;
    // button to restart the game
    private Button restartButton;
    // keep track of the number of pieces correctly placed
    private int correctGuesses;


    private int numberOfTouches;
    private boolean wrongGuess = false;

    FrameLayout.LayoutParams pic20 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));


    // we have to put each image from the XML into an
    private View img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12, img13, img14,
            img15, img16, img17, img18, img19, img20;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_game);


        DisplayMetrics dimensions = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(dimensions);

        width = dimensions.widthPixels;
        height = dimensions.heightPixels;

        restartButton = findViewById(R.id.restrtButton);
        restartButton.setVisibility(View.INVISIBLE);
        FrameLayout.LayoutParams buttonLocation = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
        buttonLocation.setMargins((int) (width * .41), (int) (height * .75), 0, 0);
        restartButton.setLayoutParams(buttonLocation);


        addAllImages();


    }

    void addAllImages() {

        // initialize all the pieces as imageViews

        im1 = findViewById(R.id.img1);
        im2 = findViewById(R.id.img2);
        im3 = findViewById(R.id.img3);
        im4 = findViewById(R.id.img4);
        im5 = findViewById(R.id.img5);
        im6 = findViewById(R.id.img6);
        im7 = findViewById(R.id.img7);
        im8 = findViewById(R.id.img8);
        im9 = findViewById(R.id.img9);
        im10 = findViewById(R.id.img10);
        im11 = findViewById(R.id.img11);
        im12 = findViewById(R.id.img12);
        im13 = findViewById(R.id.img13);
        im14 = findViewById(R.id.img14);
        im15 = findViewById(R.id.img15);
        im16 = findViewById(R.id.img16);
        im17 = findViewById(R.id.img17);
        im18 = findViewById(R.id.img18);
        im19 = findViewById(R.id.img19);
        im20 = findViewById(R.id.img20);

        // we need to add the background board and the full logo, but hide it.

        background = findViewById(R.id.backG);

        ubsymbol = findViewById(R.id.ubLogo);

        //initialize the UBsymbol but hide it
        ubsymbol.setVisibility(View.INVISIBLE);


        // once images are loaded, the sizes need to be initialized (don't you love FrameLayout?)
        initializeImageSize();


    }

    void initializeImageSize() {


        // set background grid size
        FrameLayout.LayoutParams gameBoard = new FrameLayout.LayoutParams((width), (width));
        background.setLayoutParams(gameBoard);

        // set size of the UB logo
        FrameLayout.LayoutParams fullUBPic = new FrameLayout.LayoutParams((width), (width));
        ubsymbol.setLayoutParams(fullUBPic);

        // all pieces below are set the same dimensions to look uniform
        FrameLayout.LayoutParams pic1 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
        pic1.setMargins((int) (width * .41), (int) (height * .75), 0, 0);
        im1.setLayoutParams(pic1);

        FrameLayout.LayoutParams pic2 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
        pic2.setMargins((int) (width * .42), (int) (height * .75), 0, 0);
        im2.setLayoutParams(pic2);

        FrameLayout.LayoutParams pic3 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
        pic3.setMargins((int) (width * .43), (int) (height * .75), 0, 0);
        im3.setLayoutParams(pic3);

        FrameLayout.LayoutParams pic4 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
        pic4.setMargins((int) (width * .44), (int) (height * .75), 0, 0);
        im4.setLayoutParams(pic4);

        FrameLayout.LayoutParams pic5 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
        pic5.setMargins((int) (width * .45), (int) (height * .75), 0, 0);
        im5.setLayoutParams(pic5);

        FrameLayout.LayoutParams pic6 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
        pic6.setMargins((int) (width * .46), (int) (height * .75), 0, 0);
        im6.setLayoutParams(pic6);

        FrameLayout.LayoutParams pic7 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
        pic7.setMargins((int) (width * .47), (int) (height * .75), 0, 0);
        im7.setLayoutParams(pic7);

        FrameLayout.LayoutParams pic8 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
        pic8.setMargins((int) (width * .48), (int) (height * .75), 0, 0);
        im8.setLayoutParams(pic8);

        FrameLayout.LayoutParams pic9 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
        pic9.setMargins((int) (width * .49), (int) (height * .75), 0, 0);
        im9.setLayoutParams(pic9);

        FrameLayout.LayoutParams pic10 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
        pic10.setMargins((int) (width * .50), (int) (height * .75), 0, 0);
        im10.setLayoutParams(pic10);

        FrameLayout.LayoutParams pic11 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
        pic11.setMargins((int) (width * .39), (int) (height * .75), 0, 0);
        im11.setLayoutParams(pic11);

        FrameLayout.LayoutParams pic12 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
        pic12.setMargins((int) (width * .38), (int) (height * .75), 0, 0);
        im12.setLayoutParams(pic12);

        FrameLayout.LayoutParams pic13 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
        pic13.setMargins((int) (width * .37), (int) (height * .75), 0, 0);
        im13.setLayoutParams(pic13);

        FrameLayout.LayoutParams pic14 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
        pic14.setMargins((int) (width * .36), (int) (height * .75), 0, 0);
        im14.setLayoutParams(pic14);

        FrameLayout.LayoutParams pic15 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
        pic15.setMargins((int) (width * .35), (int) (height * .75), 0, 0);
        im15.setLayoutParams(pic15);

        FrameLayout.LayoutParams pic16 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
        pic16.setMargins((int) (width * .34), (int) (height * .75), 0, 0);
        im16.setLayoutParams(pic16);

        FrameLayout.LayoutParams pic17 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
        pic17.setMargins((int) (width * .33), (int) (height * .75), 0, 0);
        im17.setLayoutParams(pic17);

        FrameLayout.LayoutParams pic18 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
        pic18.setMargins((int) (width * .32), (int) (height * .75), 0, 0);
        im18.setLayoutParams(pic18);

        FrameLayout.LayoutParams pic19 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
        pic19.setMargins((int) (width * .31), (int) (height * .75), 0, 0);
        im19.setLayoutParams(pic19);

        FrameLayout.LayoutParams pic20 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
        pic20.setMargins((int) (width * .30), (int) (height * .75), 0, 0);
        im20.setLayoutParams(pic20);


        whenTouchedMethod();
        // each image when its touched needs to call a method to check if its current
        // location matches the correct location
    }

    void whenTouchedMethod() {


        // create View instances and initialize each one as a piece of the puzzle
        // then check if the image is in the right position
        img1 = findViewById(R.id.img1);
        checkImages(img1);

        img2 = findViewById(R.id.img2);
        checkImages(img2);

        img3 = findViewById(R.id.img3);
        checkImages(img3);

        img4 = findViewById(R.id.img4);

        checkImages(img4);
        img5 = findViewById(R.id.img5);
        checkImages(img5);

        img6 = findViewById(R.id.img6);
        checkImages(img6);

        img7 = findViewById(R.id.img7);
        checkImages(img7);

        img8 = findViewById(R.id.img8);
        checkImages(img8);

        img9 = findViewById(R.id.img9);
        checkImages(img9);

        img10 = findViewById(R.id.img10);
        checkImages(img10);

        img11 = findViewById(R.id.img11);
        checkImages(img11);

        img12 = findViewById(R.id.img12);
        checkImages(img12);

        img13 = findViewById(R.id.img13);
        checkImages(img13);

        img14 = findViewById(R.id.img14);
        checkImages(img14);

        img15 = findViewById(R.id.img15);
        checkImages(img15);

        img16 = findViewById(R.id.img16);
        checkImages(img16);

        img17 = findViewById(R.id.img17);
        checkImages(img17);

        img18 = findViewById(R.id.img18);
        checkImages(img18);

        img19 = findViewById(R.id.img19);
        checkImages(img19);

        img20 = findViewById(R.id.img20);
        checkImages(img20);


    }


    // handles the logic for checking whether the current placement of the image matches the
    // correct location on the grid. I broke the 4x5 rectangle into pieces where each x coordinate is an increment of the width, x = .20
    // while each y value coordinate is an increment of .25 of the width
    // these numbers are generated by taking a percentage of the total width for the X and also a percentage of the height
    // for the Y value


    // the first block starts at 0,0 and the last block on the bottom right hand side is (.80 , 75)
    void checkImages(View v) {


        // blocks are ordered from 1 - 20 from right to left.

        // 4 x 5 grid
        // 0 , 0.0 | .20 , 0.0 | .40 , 0.0 | .60 , 0.0 | .80 , 0.0
        // 0 , .25 | .20 , .25 | .40 , .25 | .60 , .25 | .80 , .25
        // 0 , .50 | .20 , .50 | .40 , .50 | .60 , .50 | .80 , .50
        // 0 , .75 | .20 , .75 | .40 , .75 | .60 , .75 | .80 , .75


        // checks if the current view is the ImageView
        im1.setOnTouchListener(this);
        if (v == im1) {


                // check if the current location is within 10% of the desired, correct location. If so, place it in proper position
                // and disable the touchlistener

                if ((Math.abs((int) im1.getX() - (int) width * 0f) < width * 0.1) && (Math.abs((int) im1.getY() - width * 0f) < width * 0.1)) {

                    im1.setOnTouchListener(null);
                    // 0 , 0
                    im1.setY(width * 0f);
                    im1.setX(width * 0f);
                    correctGuesses++;
                } else {
                    // make the view touchable, and return it to the bottom of the screen if its wrong
                    im1.setOnTouchListener(this);

//                    im1.setX(im1currentX);
//                    im1.setY(im1currentY);
//                    im1.setX(174);
//                    im1.setY(1300);
//                    FrameLayout.LayoutParams pic1 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
//                    pic1.setMargins((int) (width * .41), (int) (height * .75), 0, 0);
//                    im1.setLayoutParams(pic1);

                }

        } else if (v == im2) {
//            int im2currentX = (int)im2.getX();
//            int im2currentY = (int)im2.getY();

            if ((Math.abs((int) im2.getX() - (int) width * .20f) < width * 0.1) && (Math.abs((int) im2.getY() - width * 0f) < width * 0.1)) {
                im2.setOnTouchListener(null);
                // 20 , 0
                im2.setY(width * 0f);
                im2.setX(width * 0.20f);
                correctGuesses++;
            } else {
//                im2.setX(174);
//                im2.setY(1300);
                im2.setOnTouchListener(this);
//                im2.setX(im2currentX);
//                im2.setY(im2currentY);
//                FrameLayout.LayoutParams pic2 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
//                pic2.setMargins((int) (width * .42), (int) (height * .75), 0, 0);
//                im2.setLayoutParams(pic2);


            }
        }
        // x = .40 y = 0
        else if (v == im3) {
//            int im3currentX = (int)im3.getX();
//            int im3currentY = (int)im3.getY();
            if ((Math.abs((int) im3.getX() - (int) width * 0.40) < width * 0.1) && (Math.abs((int) im3.getY() - width * 0) < width * 0.1)) {
                im3.setOnTouchListener(null);
                // 40 , 0
                im3.setY(width * 0f);
                im3.setX(width * 0.40f);
                correctGuesses++;
            } else {
//                im3.setX(174);
//                im3.setY(1300);
                im3.setOnTouchListener(this);
//                im3.setY(im3currentY);
//                im3.setX(im3currentX);
//                FrameLayout.LayoutParams pic3 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
//                pic3.setMargins((int) (width * .43), (int) (height * .75), 0, 0);
//                im3.setLayoutParams(pic3);
            }
        }
        // x = .60 y = 0
        else if (v == im4) {
            if ((Math.abs((int) im4.getX() - (int) width * 0.60f) < width * 0.1) && (Math.abs((int) im4.getY() - width * 0f) < width * 0.1)) {
                im4.setOnTouchListener(null);
                // 60 , 0
                im4.setY(width * 0);
                im4.setX(width * 0.60f);
                correctGuesses++;
            } else {
//                im4.setX(174);
//                im4.setY(1300);
                im4.setOnTouchListener(this);
//                FrameLayout.LayoutParams pic4 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
//                pic4.setMargins((int) (width * .44), (int) (height * .75), 0, 0);
//                im4.setLayoutParams(pic4);
            }
        } else if (v == im5) {
            if ((Math.abs((int) im5.getX() - (int) width * 0.80f) < width * 0.1) && (Math.abs((int) im5.getY() - width * 0f) < width * 0.1)) {
                im5.setOnTouchListener(null);
                // 80 , 0
                im5.setY(width * 0f);
                im5.setX(width * 0.80f);
                correctGuesses++;
            } else {
//                im5.setX(174);
//                im5.setY(1300);
                im5.setOnTouchListener(this);
//                FrameLayout.LayoutParams pic5 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
//                pic5.setMargins((int) (width * .45), (int) (height * .75), 0, 0);
//                im5.setLayoutParams(pic5);
            }
        } else if (v == im6) {
            if ((Math.abs((int) im6.getX() - (int) width * 0f) < width * 0.1) && (Math.abs((int) im6.getY() - width * 0.25f) < width * 0.1)) {
                im6.setOnTouchListener(null);
                // 0 , 25
                im6.setY(width * 0.25f);
                im6.setX(width * 0f);
                correctGuesses++;
            } else {
//                im6.setX(174);
//                im6.setY(1300);
                im6.setOnTouchListener(this);
//                FrameLayout.LayoutParams pic6 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
//                pic6.setMargins((int) (width * .46), (int) (height * .75), 0, 0);
//                im6.setLayoutParams(pic6);
            }
        } else if (v == im7) {
            if ((Math.abs((int) im7.getX() - (int) width * 0.20f) < width * 0.1) && (Math.abs((int) im7.getY() - width * 0.25f) < width * 0.1)) {
                im7.setOnTouchListener(null);
                // 20 , 25
                im7.setY(width * 0.25f);
                im7.setX(width * 0.20f);
                correctGuesses++;
            } else {
//                im7.setX(174);
//                im7.setY(1300);
                im7.setOnTouchListener(this);
//                FrameLayout.LayoutParams pic7 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
//                pic7.setMargins((int) (width * .47), (int) (height * .75), 0, 0);
//                im7.setLayoutParams(pic7);
            }
        } else if (v == im8) {
            if ((Math.abs((int) im8.getX() - (int) width * 0.40f) < width * 0.1) && (Math.abs((int) im8.getY() - width * 0.25f) < width * 0.1)) {
                im8.setOnTouchListener(null);
                // 40 , 25
                im8.setY(width * 0.25f);
                im8.setX(width * 0.40f);
                correctGuesses++;
            } else {
//                im8.setX(174);
//                im8.setY(1300);
                im8.setOnTouchListener(this);
//                FrameLayout.LayoutParams pic8 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
//                pic8.setMargins((int) (width * .48), (int) (height * .75), 0, 0);
//                im8.setLayoutParams(pic8);
            }
        } else if (v == im9) {
            if ((Math.abs((int) im9.getX() - (int) width * 0.60f) < width * 0.1) && (Math.abs((int) im9.getY() - width * 0.25f) < width * 0.1)) {
                im9.setOnTouchListener(null);
                // 60 , 25
                im9.setY(width * 0.25f);
                im9.setX(width * 0.60f);
                correctGuesses++;
            } else {
//                im9.setX(174);
//                im9.setY(1300);
                im9.setOnTouchListener(this);
//                FrameLayout.LayoutParams pic9 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
//                pic9.setMargins((int) (width * .49), (int) (height * .75), 0, 0);
//                im9.setLayoutParams(pic9);
            }
        } else if (v == im10) {
            if ((Math.abs((int) im10.getX() - (int) width * 0.80f) < width * 0.1) && (Math.abs((int) im10.getY() - width * 0.25f) < width * 0.1)) {
                im10.setOnTouchListener(null);
                // 80 , 25
                im10.setY(width * 0.25f);
                im10.setX(width * 0.80f);
                correctGuesses++;
            } else {
//                im10.setX(174);
//                im10.setY(1300);
                im10.setOnTouchListener(this);
//                FrameLayout.LayoutParams pic10 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
//                pic10.setMargins((int) (width * .50), (int) (height * .75), 0, 0);
//                im10.setLayoutParams(pic10);
            }
        } else if (v == im11) {
            if ((Math.abs((int) im11.getX() - (int) width * 0f) < width * 0.1) && (Math.abs((int) im11.getY() - width * 0.50f) < width * 0.1)) {
                im11.setOnTouchListener(null);
                // 0 , 50
                im11.setY(width * 0.50f);
                im11.setX(width * 0.0f);
                correctGuesses++;
            } else {
//                im11.setX(174);
//                im11.setY(1300);
                im11.setOnTouchListener(this);
//                FrameLayout.LayoutParams pic11 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
//                pic11.setMargins((int) (width * .39), (int) (height * .75), 0, 0);
//                im11.setLayoutParams(pic11);
            }
        } else if (v == im12) {
            if ((Math.abs((int) im12.getX() - (int) width * 0.20f) < width * 0.1) && (Math.abs((int) im12.getY() - width * 0.50f) < width * 0.1)) {
                im12.setOnTouchListener(null);
                // 20 , 50
                im12.setY(width * 0.50f);
                im12.setX(width * 0.20f);
                correctGuesses++;
            } else {
//                im12.setX(174);
//                im12.setY(1300);
                im12.setOnTouchListener(this);
//                FrameLayout.LayoutParams pic12 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
//                pic12.setMargins((int) (width * .38), (int) (height * .75), 0, 0);
//                im12.setLayoutParams(pic12);
            }
        } else if (v == im13) {
            if ((Math.abs((int) im13.getX() - (int) width * 0.40f) < width * 0.1) && (Math.abs((int) im13.getY() - width * 0.50f) < width * 0.1)) {
                im13.setOnTouchListener(null);
                // 40 , 50
                im13.setY(width * 0.50f);
                im13.setX(width * 0.40f);
                correctGuesses++;
            } else {
//                im13.setX(174);
//                im13.setY(1300);
                im13.setOnTouchListener(this);
//                FrameLayout.LayoutParams pic13 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
//                pic13.setMargins((int) (width * .37), (int) (height * .75), 0, 0);
//                im13.setLayoutParams(pic13);
            }
        } else if (v == im14) {
            if ((Math.abs((int) im14.getX() - (int) width * 0.60f) < width * 0.1) && (Math.abs((int) im14.getY() - width * 0.50f) < width * 0.1)) {
                im14.setOnTouchListener(null);
                // 60 , 50
                im14.setY(width * 0.50f);
                im14.setX(width * 0.60f);
                correctGuesses++;
            } else {
                im14.setOnTouchListener(this);
//                im14.setX(174);
//                im14.setY(1300);
//                FrameLayout.LayoutParams pic14 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
//                pic14.setMargins((int) (width * .36), (int) (height * .75), 0, 0);
//                im14.setLayoutParams(pic14);
            }
        } else if (v == im15) {
            if ((Math.abs((int) im15.getX() - (int) width * 0.80f) < width * 0.1) && (Math.abs((int) im15.getY() - width * 0.50f) < width * 0.1)) {
                im15.setOnTouchListener(null);
                // 80 , 50
                im15.setY(width * 0.50f);
                im15.setX(width * 0.80f);
                correctGuesses++;
            } else {
                im15.setOnTouchListener(this);
//                im15.setX(174);
//                im15.setY(1300);
//                FrameLayout.LayoutParams pic15 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
//                pic15.setMargins((int) (width * .35), (int) (height * .75), 0, 0);
//                im15.setLayoutParams(pic15);
            }
        } else if (v == im16) {
            if ((Math.abs((int) im16.getX() - (int) width * 0.0f) < width * 0.1) && (Math.abs((int) im16.getY() - width * 0.75f) < width * 0.1)) {
                im16.setOnTouchListener(null);
                // 0 , 75
                im16.setY(width * 0.75f);
                im16.setX(width * 0.0f);
                correctGuesses++;
            } else {
                im16.setOnTouchListener(this);
//                im16.setX(174);
//                im16.setY(1300);
//                FrameLayout.LayoutParams pic16 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
//                pic16.setMargins((int) (width * .34), (int) (height * .75), 0, 0);
//                im16.setLayoutParams(pic16);
            }
        } else if (v == im17) {
            if ((Math.abs((int) im17.getX() - (int) width * 0.20f) < width * 0.1) && (Math.abs((int) im17.getY() - width * 0.75f) < width * 0.1)) {
                im17.setOnTouchListener(null);
                // 20 , 75
                im17.setY(width * 0.75f);
                im17.setX(width * 0.20f);
                correctGuesses++;
            } else {
//                im17.setX(174);
//                im17.setY(1300);
                im17.setOnTouchListener(this);
//                FrameLayout.LayoutParams pic17 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
//                pic17.setMargins((int) (width * .33), (int) (height * .75), 0, 0);
//                im17.setLayoutParams(pic17);
            }
        } else if (v == im18) {
            if ((Math.abs((int) im18.getX() - (int) width * 0.40f) < width * 0.1) && (Math.abs((int) im18.getY() - width * 0.75f) < width * 0.1)) {
                im18.setOnTouchListener(null);
                // 40, 75
                im18.setY(width * 0.75f);
                im18.setX(width * 0.40f);
                correctGuesses++;
            } else {
                im18.setOnTouchListener(this);
//                im18.setX(174);
//                im18.setY(1300);
//                FrameLayout.LayoutParams pic18 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
//                pic18.setMargins((int) (width * .32), (int) (height * .75), 0, 0);
//                im18.setLayoutParams(pic18);
            }
        } else if (v == im19) {
            if ((Math.abs((int) im19.getX() - (int) width * 0.60f) < width * 0.1) && (Math.abs((int) im19.getY() - width * 0.75f) < width * 0.1)) {
                im19.setOnTouchListener(null);
                // 60, 75
                im19.setY(width * 0.75f);
                im19.setX(width * 0.60f);
                correctGuesses++;
            } else {
//                im19.setX(174);
//                im19.setY(1300);
                im19.setOnTouchListener(this);
//                FrameLayout.LayoutParams pic19 = new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
//                pic19.setMargins((int) (width * 31), (int) (height * .75), 0, 0);
//                im19.setLayoutParams(pic19);
            }
        } else if (v == im20) {



            if ((Math.abs((int) im20.getX() - (int) width * 0.80f) < width * 0.1) && (Math.abs((int) im20.getY() - width * 0.75) < width * 0.1)) {
                im20.setOnTouchListener(null);

                // 80 , 75
                im20.setY(width * 0.75f);
                im20.setX(width * 0.80f);
                correctGuesses++;
            } else {

                im20.setOnTouchListener(this);


//                FrameLayout.LayoutParams picx2 = (FrameLayout.LayoutParams)im20.getLayoutParams();// new FrameLayout.LayoutParams((int) (width * 0.20), (int) (width * 0.25));
//                Log.i("margs",picx2.leftMargin+", "+picx2.topMargin+" new:"+ (width*.3)+ ","+ (height*.75));
//                picx2.setMargins((int) (width * .30), (int) (height * .75), 0, 0);
//                im20.setLayoutParams(picx2);



            }



        }


    }


    void displayWinningMessage() {


        // display a dialog when the game is over (all images matched) - choose an option to either show the UB logo or restart
        // the game
        AlertDialog.Builder gameOverAlert = new AlertDialog.Builder(PlayGame.this);
        gameOverAlert.setCancelable(false);
        gameOverAlert.setTitle("Game Over");
        gameOverAlert.setMessage("You placed all the pieces in the correct spot!" + '\n' + "" +
                "Press ''Show Full UB Image'' to see UB logo. Press ''Restart'' to start the game over");
        gameOverAlert.setPositiveButton("Restart", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(PlayGame.this, MainActivity.class);
                startActivity(intent);
            }
        });
        gameOverAlert.setNegativeButton("Show Full UB Image", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                ubsymbol.setVisibility(View.VISIBLE);
                ubsymbol.bringToFront();

                restartButton.setVisibility(View.VISIBLE);
                restartButton.setText("Restart");
                restartButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(PlayGame.this, MainActivity.class);
                        startActivity(intent);
                    }
                });


            }
        });
        AlertDialog done = gameOverAlert.create();
        done.show();
    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        float imageX = 0, inputX = 0, inputY = 0, imageY = 0, xcoord = (view.getLeft()), ycoord = (view.getTop());


        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                inputX = motionEvent.getRawX();
                inputY = motionEvent.getRawY();
                imageX = view.getLeft();
                imageY = view.getTop();
                view.bringToFront();
                break;

            case MotionEvent.ACTION_UP:
                xcoord = motionEvent.getRawX() - inputX + imageX - width * 0.2f;
                ycoord = motionEvent.getRawY() - inputY + imageY - width * 0.2f;
                checkImages(view);
                view.performClick();
                if (correctGuesses == 21) {
                    gameFinished();
                }
                break;

            case MotionEvent.ACTION_MOVE:
                xcoord = motionEvent.getRawX() - inputX + imageX - width * 0.2f;
                ycoord = motionEvent.getRawY() - inputY + imageY - width * 0.2f;

                break;

        }

        FrameLayout.LayoutParams currentLocationOfView = (FrameLayout.LayoutParams) view.getLayoutParams();
        currentLocationOfView.setMargins((int) xcoord, (int) ycoord, 0, 0);
        view.setLayoutParams(currentLocationOfView);
        Log.d("screen touched at", xcoord + "," + ycoord);
        return true;
    }

    void gameFinished() {
        displayWinningMessage();
    }


}

