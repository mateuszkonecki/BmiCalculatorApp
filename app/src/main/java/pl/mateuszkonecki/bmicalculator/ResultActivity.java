package pl.mateuszkonecki.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private String height, weight, age, gender;
    private TextView one, two, three, four;
    ConstraintLayout resultConstraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        height = getIntent().getStringExtra(HomeActivity.HEIGHT_KEY);
        weight = getIntent().getStringExtra(HomeActivity.WEIGHT_KEY);
        age = getIntent().getStringExtra(HomeActivity.AGE_KEY);
        gender = getIntent().getStringExtra(HomeActivity.GENDER_KEY);

    }
}