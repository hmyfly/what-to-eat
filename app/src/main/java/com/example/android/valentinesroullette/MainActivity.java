package com.example.android.valentinesroullette;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView fImageView;
    Button fButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fImageView = findViewById(R.id.iv_heart);
        fButton = findViewById(R.id.spin_btn);

        fButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Declare the variable final so that it can be accessed from another class
                final int spinDegrees;
                //Random spin degrees
                Random random = new Random();
                //Bound the spinning to 3600 degrees
                spinDegrees = random.nextInt(3600);
                //The rotate animation
                RotateAnimation rotateHeart = new RotateAnimation(0, spinDegrees,
                        Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                //Time the animation takes
                rotateHeart.setDuration(2000);
                //Makes the heart stay put after the animation is done
                rotateHeart.setFillAfter(true);
                //Start the animation
                fImageView.startAnimation(rotateHeart );
                //Showing the toast when the animation ends
                rotateHeart.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        if (spinDegrees % 360 > 0 && spinDegrees % 360 <= 60){
                            //Black Bean Soup
                            Toast.makeText(MainActivity.this, "Black Bean Soup", Toast.LENGTH_SHORT).show();
                            String message = "https://www.twopeasandtheirpod.com/easy-black-bean-soup/";
                            startDetailActivity(message);
                        } else if (spinDegrees%360 > 60 && spinDegrees%360 <= 120 ){
                            //Broccoli Salad
                            Toast.makeText(MainActivity.this, "Broccoli Salad", Toast.LENGTH_SHORT).show();
                            String message = "https://themodernproper.com/broccoli-salad";
                            startDetailActivity(message);
                        } else if (spinDegrees%360 > 120 && spinDegrees%360 <= 180){
                            //Sushi
                            Toast.makeText(MainActivity.this, "Sushi", Toast.LENGTH_SHORT).show();
                            String message = "https://www.iloveminato.com/";
                            startDetailActivity(message);
                        } else if (spinDegrees%360 > 180 && spinDegrees%360 <= 240){
                            //Supreme Burrito
                            Toast.makeText(MainActivity.this, "Supreme Burrito", Toast.LENGTH_SHORT).show();
                            String message = "http://www.3amigosonline.com/";
                            startDetailActivity(message);
                        } else if (spinDegrees%360 > 240 && spinDegrees%360 <= 300){
                            //Spicy Chicken Sandwich
                            Toast.makeText(MainActivity.this, "Spicy Chicken Sandwich", Toast.LENGTH_SHORT).show();
                            String message = "https://storage.googleapis.com/files_android/spicy%20chicken%20sandwich.jpg";
                            startDetailActivity(message);
                        } else{
                            //Raspberry Ricotta Toast
                            Toast.makeText(MainActivity.this, "Raspberry Ricotta Toast", Toast.LENGTH_SHORT).show();
                            String message = "https://storage.googleapis.com/files_android/Raspberry%20Ricotta%20Toast.jpg";
                            startDetailActivity(message);
                        }

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });

    }

    private void startDetailActivity(String message) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("Message", message);
        startActivity(intent);
    }
}
