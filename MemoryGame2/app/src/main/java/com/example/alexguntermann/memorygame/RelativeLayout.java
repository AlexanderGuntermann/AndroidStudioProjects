package com.example.alexguntermann.memorygame;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

/**
 * created by alexguntermann
 */

public class RelativeLayout extends AppCompatActivity {
    // initialize all fruits by location in drawable folder in array
    private int[] fruitArray = {R.drawable.apple, R.drawable.banana, R.drawable.cherries, R.drawable.grapes, R.drawable.watermelon,
            R.drawable.strawberry, R.drawable.pineapple, R.drawable.starfruit, R.drawable.papaya, R.drawable.orange,
            R.drawable.mango, R.drawable.kiwi};
    private int timesClicked = 0;
    private int selection1, selection2;
    private Spinner gameSelection;
    ArrayList<Integer> list;
    private View pressed1, pressed2;
    private int guessed = 0;
    private ImageView im1, im2, im3, im4, im5, im6, im7, im8, im9, im10, im11, im12, im13, im14, im15, im16, im17, im18, im19, im20, im21, im22, im23, im24;//contains imageViews from layout
    private int rep1, rep2, rep3, rep4, rep5, rep6, rep7,
            rep8, rep9, rep10, rep11, rep12, rep13, rep14, rep15, rep16, rep17, rep18, rep19, rep20, rep21, rep22, rep23, rep24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_game_relative);

        newGame();

    }

    ;

    public void newGame() {
        loadFruitsIntoImgView();
        initializeSpinner();
    }

    public void initializeSpinner() {
        gameSelection = (Spinner) findViewById(R.id.spinner);
        gameSelection.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        gameSelection.setEnabled(false);
                        gameSelection.setClickable(false);
                        gameWith4();


                        break;
                    case 2:
                        gameSelection.setEnabled(false);
                        gameSelection.setClickable(false);

                        gameWith6();
                        if (guessed == 12) {
                            gameOverToast();
                            gameSelection.setEnabled(true);
                            gameSelection.setClickable(true);

                        }

                        break;
                    case 3:
                        gameSelection.setEnabled(false);
                        gameSelection.setClickable(false);


                        gameWith12();
                        if (guessed == 24){
                            gameOverToast();
                            gameSelection.setEnabled(true);
                            gameSelection.setClickable(true);
                        }

                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });
    }
    public void loadFruitsIntoImgView() {

        im1 = (ImageView) findViewById(R.id.apple1);
        im2 = (ImageView) findViewById(R.id.banana1);

        im3 = (ImageView) findViewById(R.id.cherry1);
        im4 = (ImageView) findViewById(R.id.grapes1);

        im5 = (ImageView) findViewById(R.id.kiwi1);
        im6 = (ImageView) findViewById(R.id.mango1);

        im7 = (ImageView) findViewById(R.id.orange2);
        im8 = (ImageView) findViewById(R.id.papaya1);

        im9 = (ImageView) findViewById(R.id.pineapple1);
        im10 = (ImageView) findViewById(R.id.starfruit2);

        im11 = (ImageView) findViewById(R.id.strawberry1);
        im12 = (ImageView) findViewById(R.id.watermelon2);

        im13 = (ImageView) findViewById(R.id.apple2);
        im14 = (ImageView) findViewById(R.id.banana2);

        im15 = (ImageView) findViewById(R.id.cherry2);
        im16 = (ImageView) findViewById(R.id.grapes2);

        im17 = (ImageView) findViewById(R.id.kiwi2);
        im18 = (ImageView) findViewById(R.id.mango2);


        im19 = (ImageView) findViewById(R.id.orange1);
        im20 = (ImageView) findViewById(R.id.papaya2);

        im21 = (ImageView) findViewById(R.id.pineapple2);
        im22 = (ImageView) findViewById(R.id.strawberry2);

        im23 = (ImageView) findViewById(R.id.watermelon1);
        im24 = (ImageView) findViewById(R.id.starfruit1);






    }


    public void gameWith4() {

        im1.setVisibility(View.VISIBLE);
        im2.setVisibility(View.VISIBLE);
        im3.setVisibility(View.VISIBLE);
        im4.setVisibility(View.VISIBLE);
        im5.setVisibility(View.VISIBLE);
        im6.setVisibility(View.VISIBLE);
        im7.setVisibility(View.VISIBLE);
        im8.setVisibility(View.VISIBLE);




        final int[] gameWith4Cards = {fruitArray[0], fruitArray[1], fruitArray[2], fruitArray[3], fruitArray[0], fruitArray[1], fruitArray[2], fruitArray[3]};
        list = new ArrayList<Integer>();

        for (int i = 0; i < gameWith4Cards.length; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
        rep1 = list.get(0);
        rep2 = list.get(1);
        rep3 = list.get(2);
        rep4 = list.get(3);
        rep5 = list.get(4);
        rep6 = list.get(5);
        rep7 = list.get(6);
        rep8 = list.get(7);


        im1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {


                Drawable myIm = getResources().getDrawable(gameWith4Cards[rep1]);
                im1.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith4Cards[rep1], im1);


                timesClickedChecked(im1);
                isGameOver(4);
            }


        });
        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith4Cards[rep2]);
                im2.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith4Cards[rep2], im2);
                timesClickedChecked(im2);
                isGameOver(4);


            }
        });
        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith4Cards[rep3]);
                im3.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith4Cards[rep3], im3);
                timesClickedChecked(im3);
                isGameOver(4);

            }
        });


        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith4Cards[rep4]);
                im4.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith4Cards[rep4], im4);
                timesClickedChecked(im4);
                isGameOver(4);
            }


        });
        im5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith4Cards[rep5]);
                im5.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith4Cards[rep5], im5);
                timesClickedChecked(im5);
                isGameOver(4);
            }
        });
        im6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith4Cards[rep6]);
                im6.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith4Cards[rep6], im6);
                timesClickedChecked(im6);
                isGameOver(4);


            }


        });
        im7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith4Cards[rep7]);
                im7.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith4Cards[rep7], im7);
                timesClickedChecked(im7);
                isGameOver(4);


            }


        });
        im8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith4Cards[rep8]);
                im8.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith4Cards[rep8], im8);
                timesClickedChecked(im8);
                isGameOver(4);


            }


        });

    }


    public void gameWith6() {
        im1.setVisibility(View.VISIBLE);
        im2.setVisibility(View.VISIBLE);
        im3.setVisibility(View.VISIBLE);
        im4.setVisibility(View.VISIBLE);
        im5.setVisibility(View.VISIBLE);
        im6.setVisibility(View.VISIBLE);
        im7.setVisibility(View.VISIBLE);
        im8.setVisibility(View.VISIBLE);
        im9.setVisibility(View.VISIBLE);
        im10.setVisibility(View.VISIBLE);
        im11.setVisibility(View.VISIBLE);
        im12.setVisibility(View.VISIBLE);

        final int[] gameWith6Cards = {fruitArray[5], fruitArray[6], fruitArray[7], fruitArray[8], fruitArray[9],
                fruitArray[10], fruitArray[5], fruitArray[6], fruitArray[7], fruitArray[8], fruitArray[9],
                fruitArray[10]};
        list = new ArrayList<Integer>();
        for (int i = 0; i < gameWith6Cards
                .length; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
        rep1 = list.get(0);
        rep2 = list.get(1);
        rep3 = list.get(2);
        rep4 = list.get(3);
        rep5 = list.get(4);
        rep6 = list.get(5);
        rep7 = list.get(6);
        rep8 = list.get(7);
        rep9 = list.get(8);
        rep10 = list.get(9);
        rep11 = list.get(10);
        rep12 = list.get(11);

        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith6Cards
                        [rep1]);
                im1.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith6Cards
                        [rep1], im1);
                timesClickedChecked(im1);
                isGameOver(6);
            }


        });
        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith6Cards
                        [rep2]);
                im2.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith6Cards
                        [rep2], im2);
                timesClickedChecked(im2);
                isGameOver(6);
            }
        });
        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith6Cards
                        [rep3]);
                im3.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith6Cards
                        [rep3], im3);
                timesClickedChecked(im3);
                isGameOver(6);
            }
        });

        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith6Cards
                        [rep4]);
                im4.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith6Cards
                        [rep4], im4);
                timesClickedChecked(im4);
                isGameOver(6);
            }


        });
        im5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith6Cards
                        [rep5]);
                im5.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith6Cards
                        [rep5], im5);
                timesClickedChecked(im5);
                isGameOver(6);
            }
        });
        im6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith6Cards
                        [rep6]);
                im6.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith6Cards
                        [rep6], im6);
                timesClickedChecked(im6);
                isGameOver(6);
            }
        });


        im7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith6Cards
                        [rep7]);
                im7.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith6Cards
                        [rep7], im7);
                timesClickedChecked(im7);
                isGameOver(6);
            }


        });
        im8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith6Cards
                        [rep8]);
                im8.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith6Cards
                        [rep8], im8);
                timesClickedChecked(im8);
                isGameOver(6);

            }
        });
        im9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith6Cards
                        [rep9]);
                im9.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith6Cards
                        [rep9], im9);
                timesClickedChecked(im9);
                isGameOver(6);

            }


        });
        im10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith6Cards
                        [rep10]);
                im10.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith6Cards
                        [rep10], im10);
                timesClickedChecked(im10);
                isGameOver(6);
            }


        });
        im11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith6Cards
                        [rep11]);
                im11.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith6Cards
                        [rep11], im11);
                timesClickedChecked(im11);
                isGameOver(6);

            }
        });
        im12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith6Cards
                        [rep12]);
                im12.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith6Cards
                        [rep12], im12);
                timesClickedChecked(im12);

                isGameOver(6);
            }


        });

    }

    public void gameWith12() {
        im1.setVisibility(View.VISIBLE);
        im2.setVisibility(View.VISIBLE);
        im3.setVisibility(View.VISIBLE);
        im4.setVisibility(View.VISIBLE);
        im5.setVisibility(View.VISIBLE);
        im6.setVisibility(View.VISIBLE);
        im7.setVisibility(View.VISIBLE);
        im8.setVisibility(View.VISIBLE);
        im9.setVisibility(View.VISIBLE);
        im10.setVisibility(View.VISIBLE);
        im11.setVisibility(View.VISIBLE);
        im12.setVisibility(View.VISIBLE);
        im13.setVisibility(View.VISIBLE);
        im14.setVisibility(View.VISIBLE);
        im15.setVisibility(View.VISIBLE);
        im16.setVisibility(View.VISIBLE);
        im17.setVisibility(View.VISIBLE);
        im18.setVisibility(View.VISIBLE);
        im19.setVisibility(View.VISIBLE);
        im20.setVisibility(View.VISIBLE);
        im21.setVisibility(View.VISIBLE);
        im22.setVisibility(View.VISIBLE);
        im23.setVisibility(View.VISIBLE);
        im24.setVisibility(View.VISIBLE);


        final int[] gameWith12Cards = {fruitArray[0],fruitArray[1], fruitArray[3], fruitArray[4], fruitArray[5], fruitArray[7],
                fruitArray[11], fruitArray[2], fruitArray[6],fruitArray[8],fruitArray[9], fruitArray[10],fruitArray[0],fruitArray[1],
                fruitArray[2], fruitArray[3], fruitArray[4], fruitArray[5],
                fruitArray[6], fruitArray[7], fruitArray[8], fruitArray[9], fruitArray[10], fruitArray[11],};
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < gameWith12Cards
                .length; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
        rep1 = list.get(0);
        rep2 = list.get(1);
        rep3 = list.get(2);
        rep4 = list.get(3);
        rep5 = list.get(4);
        rep6 = list.get(5);
        rep7 = list.get(6);
        rep8 = list.get(7);
        rep9 = list.get(8);
        rep10 = list.get(9);
        rep11 = list.get(10);
        rep12 = list.get(11);
        rep13 = list.get(12);
        rep14 = list.get(13);
        rep15 = list.get(14);
        rep16 = list.get(15);
        rep17 = list.get(16);
        rep18 = list.get(17);
        rep19 = list.get(18);
        rep20 = list.get(19);
        rep21 = list.get(20);
        rep22 = list.get(21);
        rep23 = list.get(22);
        rep24 = list.get(23);





        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith12Cards
                        [rep1]);
                im1.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith12Cards
                        [rep1], im1);
                timesClickedChecked(im1);
                isGameOver(12);
            }


        });
        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith12Cards
                        [rep2]);
                im2.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith12Cards
                        [rep2], im2);
                timesClickedChecked(im2);
                isGameOver(12);
            }


        });
        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith12Cards
                        [rep3]);
                im3.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith12Cards
                        [rep3], im3);
                timesClickedChecked(im3);
                isGameOver(12);
            }
        });
        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith12Cards
                        [rep4]);
                im4.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith12Cards
                        [rep4], im4);
                timesClickedChecked(im4);
                isGameOver(12);
            }
        });
        im5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith12Cards
                        [rep5]);
                im5.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith12Cards
                        [rep5], im5);
                timesClickedChecked(im5);
                isGameOver(12);
            }


        });
        im6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith12Cards
                        [rep6]);
                im6.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith12Cards
                        [rep6], im6);
                timesClickedChecked(im6);
                isGameOver(12);
            }


        });

        im7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith12Cards
                        [rep7]);
                im7.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith12Cards
                        [rep7], im7);
                timesClickedChecked(im7);
                isGameOver(12);
            }


        });
        im8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith12Cards
                        [rep8]);
                im8.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith12Cards
                        [rep8], im8);
                timesClickedChecked(im8);
                isGameOver(12);
            }
        });
        im9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith12Cards
                        [rep9]);
                im9.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith12Cards
                        [rep9], im9);
                timesClickedChecked(im9);
                isGameOver(12);
            }
        });
        im10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith12Cards
                        [rep10]);
                im10.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith12Cards
                        [rep10], im10);
                timesClickedChecked(im10);
                isGameOver(12);
            }


        });


        im11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith12Cards
                        [rep11]);
                im11.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith12Cards
                        [rep11], im11);
                timesClickedChecked(im11);
                isGameOver(12);
            }


        });
        im12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith12Cards
                        [rep12]);
                im12.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith12Cards
                        [rep12], im12);
                timesClickedChecked(im12);
                isGameOver(12);
            }


        });
        im13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith12Cards
                        [rep13]);
                im13.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith12Cards
                        [rep13], im13);
                timesClickedChecked(im13);
                isGameOver(12);

            }
        });
        im14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith12Cards
                        [rep14]);
                im14.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith12Cards
                        [rep14], im14);
                timesClickedChecked(im14);
                isGameOver(12);
            }


        });
        im15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith12Cards
                        [rep15]);
                im15.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith12Cards
                        [rep15], im15);
                timesClickedChecked(im15);
                isGameOver(12);

            }


        });
        im16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith12Cards
                        [rep16]);
                im16.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith12Cards
                        [rep16], im16);
                timesClickedChecked(im16);
                isGameOver(12);

            }


        });
        im17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith12Cards
                        [rep17]);
                im17.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith12Cards
                        [rep17], im17);
                timesClickedChecked(im17);
                isGameOver(12);
            }


        });
        im18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith12Cards
                        [rep18]);
                im18.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith12Cards
                        [rep18], im18);
                timesClickedChecked(im18);
                isGameOver(12);

            }
        });
        im19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith12Cards
                        [rep19]);
                im19.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith12Cards
                        [rep19], im19);
                timesClickedChecked(im19);
                isGameOver(12);

            }


        });
        im20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith12Cards
                        [rep20]);
                im20.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith12Cards
                        [rep20], im20);
                timesClickedChecked(im20);
                isGameOver(12);

            }


        });
        im21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith12Cards
                        [rep21]);
                im21.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith12Cards
                        [rep21], im21);
                timesClickedChecked(im21);
                isGameOver(12);

            }


        });
        im22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith12Cards
                        [rep22]);
                im22.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith12Cards
                        [rep22], im22);
                timesClickedChecked(im22);
                isGameOver(12);

            }


        });
        im23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith12Cards
                        [rep23]);
                im23.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith12Cards
                        [rep23], im23);
                timesClickedChecked(im23);
                isGameOver(12);

            }


        });
        im24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable myIm = getResources().getDrawable(gameWith12Cards
                        [rep24]);
                im24.setImageDrawable(myIm);
                timesClicked++;
                checker(gameWith12Cards
                        [rep24], im24);
                timesClickedChecked(im24);
                isGameOver(12);

            }


        });

    }


    public void backToFront(ImageView clicked) {
        Drawable myIm = getResources().getDrawable(R.drawable.front);
        timesClicked = 1;
        if (clicked == im1 || im1.getAlpha() == 0.5) {
        } else {
            im1.setImageDrawable(myIm);
        }
        if (clicked == im2 || im2.getAlpha() == 0.5) {
        } else {

            im2.setImageDrawable(myIm);
        }

        if (clicked == im3 || im3.getAlpha() == 0.5) {
        } else {

            im3.setImageDrawable(myIm);
        }

        if (clicked == im4 || im4.getAlpha() == 0.5) {
        } else {

            im4.setImageDrawable(myIm);
        }

        if (clicked == im5 || im5.getAlpha() == 0.5) {
        } else {
            im5.setImageDrawable(myIm);
        }
        if (clicked == im6 || im6.getAlpha() == 0.5) {
        } else {
            im6.setImageDrawable(myIm);
        }
        if (clicked == im7 || im7.getAlpha() == 0.5) {
        } else {
            im7.setImageDrawable(myIm);
        }

        if (clicked == im8 || im8.getAlpha() == 0.5) {
        } else {
            im8.setImageDrawable(myIm);
        }

        if (clicked == im9 || im9.getAlpha() == 0.5) {
        } else {
            im9.setImageDrawable(myIm);
        }


        if (clicked == im10 || im10.getAlpha() == 0.5) {
        } else {
            im10.setImageDrawable(myIm);
        }

        if (clicked == im11 || im11.getAlpha() == 0.5) {
        } else {
            im11.setImageDrawable(myIm);
        }
        if (clicked == im12 || im12.getAlpha() == 0.5) {
        } else {
            im12.setImageDrawable(myIm);
        }

        if (clicked == im13 || im13.getAlpha() == 0.5) {
        } else {
            im13.setImageDrawable(myIm);
        }

        if (clicked == im14 || im14.getAlpha() == 0.5) {
        } else {
            im14.setImageDrawable(myIm);
        }
        if (clicked == im15 || im15.getAlpha() == 0.5) {
        } else {
            im15.setImageDrawable(myIm);
        }
        if (clicked == im16 || im16.getAlpha() == 0.5) {
        } else {
            im16.setImageDrawable(myIm);
        }
        if (clicked == im17 || im17.getAlpha() == 0.5) {
        } else {
            im17.setImageDrawable(myIm);
        }
        if (clicked == im18 || im18.getAlpha() == 0.5) {
        } else {
            im18.setImageDrawable(myIm);
        }
        if (clicked == im19 || im19.getAlpha() == 0.5) {
        } else {
            im19.setImageDrawable(myIm);
        }
        if (clicked == im20 || im20.getAlpha() == 0.5) {
        } else {
            im20.setImageDrawable(myIm);
        }
        if (clicked == im21|| im21.getAlpha() == 0.5) {
        } else {
            im21.setImageDrawable(myIm);
        }
        if (clicked == im22 || im22.getAlpha() == 0.5) {
        } else {
            im22.setImageDrawable(myIm);
        }
        if (clicked == im23 || im23.getAlpha() == 0.5) {
        } else {
            im23.setImageDrawable(myIm);
        }
        if (clicked == im24 || im24.getAlpha() == 0.5) {
        } else {
            im24.setImageDrawable(myIm);
        }


    }

    public void allDefault() {
        Drawable myIm = getResources().getDrawable(R.drawable.front);
        im1.setImageDrawable(myIm);
        im2.setImageDrawable(myIm);
        im3.setImageDrawable(myIm);
        im4.setImageDrawable(myIm);
        im5.setImageDrawable(myIm);
        im6.setImageDrawable(myIm);
        im7.setImageDrawable(myIm);
        im8.setImageDrawable(myIm);
        im9.setImageDrawable(myIm);
        im10.setImageDrawable(myIm);
        im11.setImageDrawable(myIm);
        im12.setImageDrawable(myIm);
        im13.setImageDrawable(myIm);
        im14.setImageDrawable(myIm);
        im15.setImageDrawable(myIm);
        im16.setImageDrawable(myIm);
        im17.setImageDrawable(myIm);
        im18.setImageDrawable(myIm);
        im19.setImageDrawable(myIm);
        im20.setImageDrawable(myIm);
        im21.setImageDrawable(myIm);
        im22.setImageDrawable(myIm);
        im23.setImageDrawable(myIm);
        im24.setImageDrawable(myIm);


        selection1 = 0;
        selection2 = 0;
        timesClicked = 0;
        guessed = 0;


    }


    public void checker(int f, View x) {

        if (timesClicked == 1 || timesClicked == 3) {
            selection1 = f;
            pressed1 = x;
        } else if (timesClicked == 2) {
            selection2 = f;
            pressed2 = x;

            if (selection1 == selection2 && pressed2 != pressed1) {
                guessed++;
                doRotation(pressed1);
                doRotation(pressed2);
                pressed1.setAlpha(0.5f);
                pressed2.setAlpha(0.5f);
            } else if (selection1 == selection2 && pressed2 != pressed1) {

                timesClicked = 1;
            } else {
                doShake(pressed1);
                doShake(pressed2);

            }

        }
    }


    public void gameOverToast() {
        RelativeLayout thisO = this;
        int longDuration = Toast.LENGTH_LONG;
        Toast myToast = Toast.makeText(thisO, "Game Over! Click the button to play again!",
                longDuration);
        int xSet = 0;
        int ySet = 0;
        myToast.setGravity(Gravity.CENTER | Gravity.CENTER, xSet, ySet);
        myToast.show();
        Intent intent = new Intent();
        setResult(0, intent);
        finish();
    }


    public void doShake(View img) {
        Animation shake = AnimationUtils.loadAnimation(RelativeLayout.this, R.anim.shake);
        shake.setAnimationListener(shakeListener);

        img.startAnimation(shake);
    }

    public void doRotation(View img) {
        Animation rotation = AnimationUtils.loadAnimation(RelativeLayout.this, R.anim.rotation);
        rotation.setAnimationListener(rotationListener);

        img.startAnimation(rotation);

    }

    Animation.AnimationListener shakeListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };
    Animation.AnimationListener rotationListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };

    public void isGameOver(int total) {
        if (total == guessed) {
            gameOverToast();
            gameSelection.setEnabled(true);
            gameSelection.setClickable(true);
            allDefault();
            backToFront(null);
            newGame();
        } else {

        }

    }

    public void timesClickedChecked(ImageView clicked) {

        if (timesClicked == 3) {
            backToFront(clicked);
        }
    }
}








//    public void loadImages () {
//
//        coverPhoto[0] = getResources().getDrawable(R.drawable.front);
//
//        all_images[0] = getResources().getDrawable(R.drawable.apple);
//        all_images[1] = getResources().getDrawable(R.drawable.orange);
//        all_images[2] = getResources().getDrawable(R.drawable.grapes);
//        all_images[3] = getResources().getDrawable(R.drawable.kiwi);
//        all_images[4] = getResources().getDrawable(R.drawable.mango);
//        all_images[5] = getResources().getDrawable(R.drawable.papaya);
//        all_images[6] = getResources().getDrawable(R.drawable.strawberry);
//        all_images[7] = getResources().getDrawable(R.drawable.starfruit);
//        all_images[8] = getResources().getDrawable(R.drawable.watermelon);
//        all_images[9] = getResources().getDrawable(R.drawable.cherries);
//        all_images[10] = getResources().getDrawable(R.drawable.banana);
//        all_images[11] = getResources().getDrawable(R.drawable.pineapple);
//        all_images[12] = getResources().getDrawable(R.drawable.apple);
//        all_images[13] = getResources().getDrawable(R.drawable.orange);
//        all_images[14] = getResources().getDrawable(R.drawable.grapes);
//        all_images[15] = getResources().getDrawable(R.drawable.kiwi);
//        all_images[16] = getResources().getDrawable(R.drawable.mango);
//        all_images[17] = getResources().getDrawable(R.drawable.papaya);
//        all_images[18] = getResources().getDrawable(R.drawable.strawberry);
//        all_images[19] = getResources().getDrawable(R.drawable.starfruit);
//        all_images[20] = getResources().getDrawable(R.drawable.watermelon);
//        all_images[21] = getResources().getDrawable(R.drawable.cherries);
//        all_images[22] = getResources().getDrawable(R.drawable.banana);
//        all_images[23] = getResources().getDrawable(R.drawable.pineapple);
//
//
//
//        images.add((ImageView) findViewById(R.id.apple1));
//        images.add((ImageView) findViewById(R.id.apple2));
//
//        images.add((ImageView) findViewById(R.id.banana1));
//        images.add((ImageView) findViewById(R.id.banana2));
//
//        images.add((ImageView) findViewById(R.id.cherry1));
//        images.add((ImageView) findViewById(R.id.cherry2));
//
//        images.add((ImageView) findViewById(R.id.grapes1));
//        images.add((ImageView) findViewById(R.id.grapes2));
//
//        images.add((ImageView) findViewById(R.id.kiwi1));
//        images.add((ImageView) findViewById(R.id.kiwi2));
//
//        images.add((ImageView) findViewById(R.id.mango1));
//        images.add((ImageView) findViewById(R.id.mango2));
//
//        images.add((ImageView) findViewById(R.id.orange1));
//        images.add((ImageView) findViewById(R.id.orange2));
//
//        images.add((ImageView) findViewById(R.id.papaya1));
//        images.add((ImageView) findViewById(R.id.papaya2));
//
//        images.add((ImageView) findViewById(R.id.pineapple1));
//        images.add((ImageView) findViewById(R.id.pineapple2));
//
//        images.add((ImageView) findViewById(R.id.watermelon1));
//        images.add((ImageView) findViewById(R.id.watermelon2));
//
//        images.add((ImageView) findViewById(R.id.starfruit1));
//        images.add((ImageView) findViewById(R.id.starfruit2));
//
//        images.add((ImageView) findViewById(R.id.strawberry1));
//        images.add((ImageView) findViewById(R.id.strawberry2));



