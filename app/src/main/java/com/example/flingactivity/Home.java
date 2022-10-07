package com.example.flingactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class Home extends AppCompatActivity {
    GestureDetectorCompat gestureDetectorCompat;
    Intent north;
    Intent south;
    Intent west;
    Intent east;
    String DEBUG_TAG = "hi";
    float firstX_point, firstY_point;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        north = new Intent(this, North.class);
        south = new Intent(this, South.class);
        west = new Intent(this, West.class);
        east = new Intent(this, East.class);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                firstX_point = event.getRawX();
                firstY_point = event.getRawY();
                break;

            case MotionEvent.ACTION_UP:

                float finalX = event.getRawX();
                float finalY = event.getRawY();

                int distanceX = (int) (finalX - firstX_point);
                int distanceY = (int) (finalY - firstY_point);

                if (Math.abs(distanceX) > Math.abs(distanceY)) {
                    if ((firstX_point < finalX)) {
                        Log.d("Test", "Left to Right swipe performed");
                        startActivity(east);
                    } else {
                        Log.d("Test", "Right to Left swipe performed");
                        startActivity(west);
                    }
                }else{
                    if ((firstY_point < finalY)) {
                        Log.d("Test", "Up to Down swipe performed");
                        startActivity(south);
                    } else {
                        Log.d("Test", "Down to Up swipe performed");
                        startActivity(north);
                    }
                }


                break;
        }

        return true;
    }
}

