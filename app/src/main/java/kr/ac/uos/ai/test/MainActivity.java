package kr.ac.uos.ai.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

public class MainActivity extends Activity {

    private ImageButton b;
    private Animation ani;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (ImageButton) findViewById(R.id.calculator);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation(v);
            }
        });
    }

    private void startAnimation(View v) {
        ani = AnimationUtils.loadAnimation(MainActivity.this, R.anim.animation_buttonclick);
        b.startAnimation(ani);
        ani.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startNextActivity();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void startNextActivity() {
        Intent i = new Intent(MainActivity.this, CalculatorActivity.class);
        startActivity(i);
    }

}