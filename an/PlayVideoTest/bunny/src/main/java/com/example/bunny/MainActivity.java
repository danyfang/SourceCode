package com.example.bunny;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout frameLayout = (FrameLayout)findViewById(R.id.my_layout);
        final RabbitView rabbit = new RabbitView(this);

        rabbit.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                rabbit.bitmapX = event.getX();
                rabbit.bitmapY = event.getY();
                rabbit.invalidate();
                return true;
            }
        });
        frameLayout.addView(rabbit);
    }
}
