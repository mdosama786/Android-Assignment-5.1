package com.example.osamaansar.blinkingeffect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {

    TextView textView;
    Button button;
    Animation animFadein, animFadeout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView)findViewById(R.id.textView);
        button=(Button)findViewById(R.id.button);
        animFadeout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);

        //load the animation
        animFadein=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        //set animation listener
        animFadein.setAnimationListener(this);

        //button click event
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setVisibility(View.VISIBLE);



                //start the animation
                textView.startAnimation(animFadein);
            }
        });
    }

    @Override
    public void onAnimationStart(Animation animation) {
        //Toast.makeText(MainActivity.this, "Animation Started", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onAnimationEnd(Animation animation) {

        if(animFadein==animFadein){
//            Toast.makeText(getApplicationContext(),"Animation End",
//                    Toast.LENGTH_SHORT).show();
            textView.startAnimation(animFadeout);
            animFadeout.start();
        }

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}