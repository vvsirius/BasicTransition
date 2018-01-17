package com.example.android.basictransition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void startAnimation(View view) {
        Button button = (Button)findViewById(R.id.button);
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(button, "rotationX", 90);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(button, "rotationX", 0);
        anim1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Toast.makeText(Main2Activity.this, "Anim1 finished", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        //anim1.setInterpolator(new BounceInterpolator());
        //anim1.start()
        anim1.setDuration(1500);
        anim2.setDuration(1500);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(anim1, anim2);
        animatorSet.start();
    }
}
