package pl.mateuszkonecki.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class LaunchActivity extends AppCompatActivity {

    Animation topAnim, bottomAnim;
    TextView logoText, loadingText;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        logoText = findViewById(R.id.logoText);
        loadingText = findViewById(R.id.loadingText);
        logo = findViewById(R.id.logo);

        logo.setAnimation(topAnim);
        logoText.setAnimation(bottomAnim);

        for (int i=0; i<2; i++) {
            Animation anim = new AlphaAnimation(0.0f, 1.0f);
            anim.setDuration(1500);
            anim.setStartOffset(20);
            anim.setRepeatMode(Animation.REVERSE);
            anim.setRepeatCount(Animation.INFINITE);
            loadingText.startAnimation(anim);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LaunchActivity.this, HomeActivity.class);

                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(logo, "logoTransition");
                pairs[1] = new Pair<View, String>(logoText, "logoTextTransition");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LaunchActivity.this, pairs);
                startActivity(intent, options.toBundle());
            }
        }, 5000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 6000);
    }
}