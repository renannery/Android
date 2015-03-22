package com.origamitecnologia.animations;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Point;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
    private Button btn1, btn2;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        view = findViewById(R.id.view);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        ObjectAnimator oa = ObjectAnimator.ofFloat(btn2, "translationX", 0, -width/2);
        ObjectAnimator oa2 = ObjectAnimator.ofFloat(btn1, "translationX", 0, width/2);
        ObjectAnimator translationY = ObjectAnimator.ofFloat(btn1, "translationY", 0, height/2);
        ObjectAnimator translationY2 = ObjectAnimator.ofFloat(btn2, "translationY", 0, -height/2);
        ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(view, "scaleX", 0, 1);
        ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(view, "scaleY", 0, 1);
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSet animatorSet2 = new AnimatorSet();

        animatorSet.play(oa).with(oa2).before(animatorSet2);
        animatorSet2.play(translationY).with(translationY2).with(scaleDownX).with(scaleDownY);

        animatorSet.setDuration(1000);
        animatorSet.start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
