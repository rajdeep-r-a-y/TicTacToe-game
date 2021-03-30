package com.example.tic_tac_toe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity<ref> extends AppCompatActivity {

    //player representations
    //        0- x
//        1- O





    int activePlayer = 0;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    boolean gameActive = true;
    int flag = 0;
    //game state meanings
    //0 - x
    //1 - o
    //2 - empty
    int[][] winpositions ={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void playerTap(View view){
        ImageView img= (ImageView) view;
        int tappedImage= Integer.parseInt(img.getTag().toString());
        if(!gameActive){
            gameReset(view);

        }

        if(gameState[tappedImage]==2){
            flag++;
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer==0){
                img.setImageResource(R.drawable.x);
                activePlayer=1;
                TextView status = findViewById(R.id.status);
                status.setText("O's turn");
            }
            else{
                img.setImageResource(R.drawable.o);
                activePlayer=0;
                TextView status = findViewById(R.id.status);
                status.setText("X's turn");
            }

        img.animate().translationYBy(1000f).setDuration(300);
        }

        String winnerStr;
        for(int[] winposition: winpositions){


            if(gameState[winposition[0]] == gameState[winposition[1]] &&
                    gameState[winposition[1]] == gameState[winposition[2]] &&
            gameState[winposition[0]]!=2 ){
                gameActive = false;
                ((ImageView) findViewById(R.id.imageView0)).setClickable(false);
                ((ImageView) findViewById(R.id.imageView1)).setClickable(false);
                ((ImageView) findViewById(R.id.imageView2)).setClickable(false);
                ((ImageView) findViewById(R.id.imageView3)).setClickable(false);
                ((ImageView) findViewById(R.id.imageView4)).setClickable(false);
                ((ImageView) findViewById(R.id.imageView5)).setClickable(false);
                ((ImageView) findViewById(R.id.imageView6)).setClickable(false);
                ((ImageView) findViewById(R.id.imageView7)).setClickable(false);
                ((ImageView) findViewById(R.id.imageView8)).setClickable(false);

                if(gameState[winposition[0]] == 0) {
                    winnerStr="X has won.";
                }
                else {
                    winnerStr="O has won. ";
                }
                ((Button)findViewById(R.id.playAgainButton)).setVisibility(View.VISIBLE);
                TextView status = findViewById(R.id.status);
                status.setText(winnerStr);
            }
        }
             if(flag== 9){
                 ((ImageView) findViewById(R.id.imageView0)).setClickable(false);
                 ((ImageView) findViewById(R.id.imageView1)).setClickable(false);
                 ((ImageView) findViewById(R.id.imageView2)).setClickable(false);
                 ((ImageView) findViewById(R.id.imageView3)).setClickable(false);
                 ((ImageView) findViewById(R.id.imageView4)).setClickable(false);
                 ((ImageView) findViewById(R.id.imageView5)).setClickable(false);
                 ((ImageView) findViewById(R.id.imageView6)).setClickable(false);
                 ((ImageView) findViewById(R.id.imageView7)).setClickable(false);
                 ((ImageView) findViewById(R.id.imageView8)).setClickable(false);
            winnerStr="Game is drawn !!";
                 ((Button)findViewById(R.id.playAgainButton)).setVisibility(View.VISIBLE);

                 TextView status = findViewById(R.id.status);
            status.setText(winnerStr);
                 gameActive = false;
        }

    }
    public void gameReset(View view){
            gameActive=true;

            flag = 0;
            activePlayer=0;
            for(int i = 0;i < gameState.length; i++){
                gameState[i] = 2;
            }
            ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        TextView status = findViewById(R.id.status);
        status.setText("X's turn");
        ((Button)findViewById(R.id.playAgainButton)).setVisibility(View.INVISIBLE);

        ((ImageView) findViewById(R.id.imageView0)).setClickable(true);
        ((ImageView) findViewById(R.id.imageView1)).setClickable(true);
        ((ImageView) findViewById(R.id.imageView2)).setClickable(true);
        ((ImageView) findViewById(R.id.imageView3)).setClickable(true);
        ((ImageView) findViewById(R.id.imageView4)).setClickable(true);
        ((ImageView) findViewById(R.id.imageView5)).setClickable(true);
        ((ImageView) findViewById(R.id.imageView6)).setClickable(true);
        ((ImageView) findViewById(R.id.imageView7)).setClickable(true);
        ((ImageView) findViewById(R.id.imageView8)).setClickable(true);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}