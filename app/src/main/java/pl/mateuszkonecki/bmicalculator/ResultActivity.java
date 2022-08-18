package pl.mateuszkonecki.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.opengl.Visibility;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.divider.MaterialDivider;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {

    private String height, weight, age, gender;
    private TextView userIndex, shortInfo, descInfo, resultTV;
    private Button goBackButton;
    private LinearLayout linearLayout;
    private MaterialDivider materialDivider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        height = getIntent().getStringExtra(HomeActivity.HEIGHT_KEY);
        weight = getIntent().getStringExtra(HomeActivity.WEIGHT_KEY);
        age = getIntent().getStringExtra(HomeActivity.AGE_KEY);
        gender = getIntent().getStringExtra(HomeActivity.GENDER_KEY);

        userIndex = findViewById(R.id.userIndex);
        shortInfo = findViewById(R.id.shortInfo);
        descInfo = findViewById(R.id.info_description);
        goBackButton = findViewById(R.id.goBackButton);
        linearLayout = findViewById(R.id.resultLinearLayout);
        materialDivider = findViewById(R.id.materialDivider);
        resultTV = findViewById(R.id.textView3);

        double heightDouble = Double.parseDouble(height);
        double weightDouble = Double.parseDouble(weight);
        int ageInt = Integer.parseInt(age);
        double heightInMeter = heightDouble / 100;
        double heightToPow = Math.pow(heightInMeter, 2);
        double userBmiIndex = weightDouble / heightToPow;

        userIndex.setText(decimalFormat.format(userBmiIndex));

        if(gender.equals(getResources().getString(R.string.RadioMaleText))) {
            if(ageInt < 18) {
                descInfo.setText(R.string.age_alert_toast);
                descInfo.setTextColor(Color.rgb(215, 61, 61));
                linearLayout.setVisibility(View.GONE);
                userIndex.setVisibility(View.GONE);
                materialDivider.setVisibility(View.GONE);
                resultTV.setVisibility(View.GONE);
                goBackButton.setVisibility(View.GONE);
            }
            if(ageInt <= 24 && ageInt >= 18) {
                if(userBmiIndex < 20.0) {
                    shortInfo.setText(getResources().getString(R.string.underweight));
                    descInfo.setText(getResources().getString(R.string.underweight_desc));
                }
                if(userBmiIndex >= 20.0 && userBmiIndex < 25.0) {
                    shortInfo.setText(getResources().getString(R.string.normal_weight));
                    descInfo.setText(getResources().getString(R.string.normal_weight_desc));
                }
                if(userBmiIndex >= 25.0 && userBmiIndex < 30.0) {
                    shortInfo.setText(getResources().getString(R.string.overweight));
                    descInfo.setText(getResources().getString(R.string.overweight_desc));
                }
                if(userBmiIndex >= 30.0 && userBmiIndex <= 40.0) {
                    shortInfo.setText(getResources().getString(R.string.adiposity));
                    descInfo.setText(getResources().getString(R.string.adiposity_desc));
                }
                if(userBmiIndex > 40.0) {
                    shortInfo.setText(getResources().getString(R.string.severe_adiposity));
                    descInfo.setText(getResources().getString(R.string.severe_adiposity_desc));
                }
            }

            if(ageInt >= 25 && ageInt <=34) {
                if(userBmiIndex < 21.0) {
                    shortInfo.setText(getResources().getString(R.string.underweight));
                    descInfo.setText(getResources().getString(R.string.underweight_desc));
                }
                if(userBmiIndex >= 21.0 && userBmiIndex < 26.0) {
                    shortInfo.setText(getResources().getString(R.string.normal_weight));
                    descInfo.setText(getResources().getString(R.string.normal_weight_desc));
                }
                if(userBmiIndex >= 26.0 && userBmiIndex < 31.0) {
                    shortInfo.setText(getResources().getString(R.string.overweight));
                    descInfo.setText(getResources().getString(R.string.overweight_desc));
                }
                if(userBmiIndex >= 31.0 && userBmiIndex <= 41.0) {
                    shortInfo.setText(getResources().getString(R.string.adiposity));
                    descInfo.setText(getResources().getString(R.string.adiposity_desc));
                }
                if(userBmiIndex > 41.0) {
                    shortInfo.setText(getResources().getString(R.string.severe_adiposity));
                    descInfo.setText(getResources().getString(R.string.severe_adiposity_desc));
                }
            }

            if(ageInt >= 35 && ageInt <=44) {
                if(userBmiIndex < 22.0) {
                    shortInfo.setText(getResources().getString(R.string.underweight));
                    descInfo.setText(getResources().getString(R.string.underweight_desc));
                }
                if(userBmiIndex >= 22.0 && userBmiIndex < 27.0) {
                    shortInfo.setText(getResources().getString(R.string.normal_weight));
                    descInfo.setText(getResources().getString(R.string.normal_weight_desc));
                }
                if(userBmiIndex >= 27.0 && userBmiIndex < 32.0) {
                    shortInfo.setText(getResources().getString(R.string.overweight));
                    descInfo.setText(getResources().getString(R.string.overweight_desc));
                }
                if(userBmiIndex >= 32.0 && userBmiIndex <= 42.0) {
                    shortInfo.setText(getResources().getString(R.string.adiposity));
                    descInfo.setText(getResources().getString(R.string.adiposity_desc));
                }
                if(userBmiIndex > 42.0) {
                    shortInfo.setText(getResources().getString(R.string.severe_adiposity));
                    descInfo.setText(getResources().getString(R.string.severe_adiposity_desc));
                }
            }

            if(ageInt >= 45 && ageInt <=54) {
                if(userBmiIndex < 23.0) {
                    shortInfo.setText(getResources().getString(R.string.underweight));
                    descInfo.setText(getResources().getString(R.string.underweight_desc));
                }
                if(userBmiIndex >= 23.0 && userBmiIndex < 28.0) {
                    shortInfo.setText(getResources().getString(R.string.normal_weight));
                    descInfo.setText(getResources().getString(R.string.normal_weight_desc));
                }
                if(userBmiIndex >= 28.0 && userBmiIndex < 33.0) {
                    shortInfo.setText(getResources().getString(R.string.overweight));
                    descInfo.setText(getResources().getString(R.string.overweight_desc));
                }
                if(userBmiIndex >= 33.0 && userBmiIndex <= 43.0) {
                    shortInfo.setText(getResources().getString(R.string.adiposity));
                    descInfo.setText(getResources().getString(R.string.adiposity_desc));
                }
                if(userBmiIndex > 43.0) {
                    shortInfo.setText(getResources().getString(R.string.severe_adiposity));
                    descInfo.setText(getResources().getString(R.string.severe_adiposity_desc));
                }
            }

            if(ageInt >= 55 && ageInt <= 64) {
                if(userBmiIndex < 24.0) {
                    shortInfo.setText(getResources().getString(R.string.underweight));
                    descInfo.setText(getResources().getString(R.string.underweight_desc));
                }
                if(userBmiIndex >= 24.0 && userBmiIndex < 29.0) {
                    shortInfo.setText(getResources().getString(R.string.normal_weight));
                    descInfo.setText(getResources().getString(R.string.normal_weight_desc));
                }
                if(userBmiIndex >= 29.0 && userBmiIndex < 34.0) {
                    shortInfo.setText(getResources().getString(R.string.overweight));
                    descInfo.setText(getResources().getString(R.string.overweight_desc));
                }
                if(userBmiIndex >= 34.0 && userBmiIndex <= 44.0) {
                    shortInfo.setText(getResources().getString(R.string.adiposity));
                    descInfo.setText(getResources().getString(R.string.adiposity_desc));
                }
                if(userBmiIndex > 44.0) {
                    shortInfo.setText(getResources().getString(R.string.severe_adiposity));
                    descInfo.setText(getResources().getString(R.string.severe_adiposity_desc));
                }
            }

            if(ageInt > 65) {
                if(userBmiIndex < 25.0) {
                    shortInfo.setText(getResources().getString(R.string.underweight));
                    descInfo.setText(getResources().getString(R.string.underweight_desc));
                }
                if(userBmiIndex >= 25.0 && userBmiIndex < 30.0) {
                    shortInfo.setText(getResources().getString(R.string.normal_weight));
                    descInfo.setText(getResources().getString(R.string.normal_weight_desc));
                }
                if(userBmiIndex >= 30.0 && userBmiIndex < 35.0) {
                    shortInfo.setText(getResources().getString(R.string.overweight));
                    descInfo.setText(getResources().getString(R.string.overweight_desc));
                }
                if(userBmiIndex >= 35.0 && userBmiIndex <= 45.0) {
                    shortInfo.setText(getResources().getString(R.string.adiposity));
                    descInfo.setText(getResources().getString(R.string.adiposity_desc));
                }
                if(userBmiIndex > 45.0) {
                    shortInfo.setText(getResources().getString(R.string.severe_adiposity));
                    descInfo.setText(getResources().getString(R.string.severe_adiposity_desc));
                }
            }
        }

        if(gender.equals(getResources().getString(R.string.RadioFemaleText))) {
            if(ageInt < 18) {
                descInfo.setText(R.string.age_alert_toast);
                descInfo.setTextColor(Color.rgb(215, 61, 61));
                linearLayout.setVisibility(View.GONE);
                userIndex.setVisibility(View.GONE);
                materialDivider.setVisibility(View.GONE);
                resultTV.setVisibility(View.GONE);
                goBackButton.setVisibility(View.GONE);
            }
            if(ageInt <= 24 && ageInt >= 18) {
                if(userBmiIndex < 19.0) {
                    shortInfo.setText(getResources().getString(R.string.underweight));
                    descInfo.setText(getResources().getString(R.string.underweight_desc));
                }
                if(userBmiIndex >= 19.0 && userBmiIndex < 24.0) {
                    shortInfo.setText(getResources().getString(R.string.normal_weight));
                    descInfo.setText(getResources().getString(R.string.normal_weight_desc_woman));
                }
                if(userBmiIndex >= 24.0 && userBmiIndex < 29.0) {
                    shortInfo.setText(getResources().getString(R.string.overweight));
                    descInfo.setText(getResources().getString(R.string.overweight_desc));
                }
                if(userBmiIndex >= 29.0 && userBmiIndex <= 39.0) {
                    shortInfo.setText(getResources().getString(R.string.adiposity));
                    descInfo.setText(getResources().getString(R.string.adiposity_desc));
                }
                if(userBmiIndex > 39.0) {
                    shortInfo.setText(getResources().getString(R.string.severe_adiposity));
                    descInfo.setText(getResources().getString(R.string.severe_adiposity_desc));
                }
            }

            if(ageInt >= 25 && ageInt <=34) {
                if(userBmiIndex < 20.0) {
                    shortInfo.setText(getResources().getString(R.string.underweight));
                    descInfo.setText(getResources().getString(R.string.underweight_desc));
                }
                if(userBmiIndex >= 20.0 && userBmiIndex < 25.0) {
                    shortInfo.setText(getResources().getString(R.string.normal_weight));
                    descInfo.setText(getResources().getString(R.string.normal_weight_desc_woman));
                }
                if(userBmiIndex >= 25.0 && userBmiIndex < 30.0) {
                    shortInfo.setText(getResources().getString(R.string.overweight));
                    descInfo.setText(getResources().getString(R.string.overweight_desc));
                }
                if(userBmiIndex >= 30.0 && userBmiIndex <= 40.0) {
                    shortInfo.setText(getResources().getString(R.string.adiposity));
                    descInfo.setText(getResources().getString(R.string.adiposity_desc));
                }
                if(userBmiIndex > 40.0) {
                    shortInfo.setText(getResources().getString(R.string.severe_adiposity));
                    descInfo.setText(getResources().getString(R.string.severe_adiposity_desc));
                }
            }

            if(ageInt >= 35 && ageInt <=44) {
                if(userBmiIndex < 21.0) {
                    shortInfo.setText(getResources().getString(R.string.underweight));
                    descInfo.setText(getResources().getString(R.string.underweight_desc));
                }
                if(userBmiIndex >= 21.0 && userBmiIndex < 26.0) {
                    shortInfo.setText(getResources().getString(R.string.normal_weight));
                    descInfo.setText(getResources().getString(R.string.normal_weight_desc_woman));
                }
                if(userBmiIndex >= 26.0 && userBmiIndex < 31.0) {
                    shortInfo.setText(getResources().getString(R.string.overweight));
                    descInfo.setText(getResources().getString(R.string.overweight_desc));
                }
                if(userBmiIndex >= 31.0 && userBmiIndex <= 41.0) {
                    shortInfo.setText(getResources().getString(R.string.adiposity));
                    descInfo.setText(getResources().getString(R.string.adiposity_desc));
                }
                if(userBmiIndex > 41.0) {
                    shortInfo.setText(getResources().getString(R.string.severe_adiposity));
                    descInfo.setText(getResources().getString(R.string.severe_adiposity_desc));
                }
            }

            if(ageInt >= 45 && ageInt <=54) {
                if(userBmiIndex < 22.0) {
                    shortInfo.setText(getResources().getString(R.string.underweight));
                    descInfo.setText(getResources().getString(R.string.underweight_desc));
                }
                if(userBmiIndex >= 22.0 && userBmiIndex < 27.0) {
                    shortInfo.setText(getResources().getString(R.string.normal_weight));
                    descInfo.setText(getResources().getString(R.string.normal_weight_desc_woman));
                }
                if(userBmiIndex >= 27.0 && userBmiIndex < 32.0) {
                    shortInfo.setText(getResources().getString(R.string.overweight));
                    descInfo.setText(getResources().getString(R.string.overweight_desc));
                }
                if(userBmiIndex >= 32.0 && userBmiIndex <= 42.0) {
                    shortInfo.setText(getResources().getString(R.string.adiposity));
                    descInfo.setText(getResources().getString(R.string.adiposity_desc));
                }
                if(userBmiIndex > 42) {
                    shortInfo.setText(getResources().getString(R.string.severe_adiposity));
                    descInfo.setText(getResources().getString(R.string.severe_adiposity_desc));
                }
            }

            if(ageInt >= 55 && ageInt <= 64) {
                if(userBmiIndex < 23.0) {
                    shortInfo.setText(getResources().getString(R.string.underweight));
                    descInfo.setText(getResources().getString(R.string.underweight_desc));
                }
                if(userBmiIndex >= 23.0 && userBmiIndex < 28.0) {
                    shortInfo.setText(getResources().getString(R.string.normal_weight));
                    descInfo.setText(getResources().getString(R.string.normal_weight_desc_woman));
                }
                if(userBmiIndex >= 28.0 && userBmiIndex < 33.0) {
                    shortInfo.setText(getResources().getString(R.string.overweight));
                    descInfo.setText(getResources().getString(R.string.overweight_desc));
                }
                if(userBmiIndex >= 33.0 && userBmiIndex <= 43.0) {
                    shortInfo.setText(getResources().getString(R.string.adiposity));
                    descInfo.setText(getResources().getString(R.string.adiposity_desc));
                }
                if(userBmiIndex > 43) {
                    shortInfo.setText(getResources().getString(R.string.severe_adiposity));
                    descInfo.setText(getResources().getString(R.string.severe_adiposity_desc));
                }
            }

            if(ageInt > 65) {
                if(userBmiIndex < 24.0) {
                    shortInfo.setText(getResources().getString(R.string.underweight));
                    descInfo.setText(getResources().getString(R.string.underweight_desc));
                }
                if(userBmiIndex >= 24.0 && userBmiIndex < 29.0) {
                    shortInfo.setText(getResources().getString(R.string.normal_weight));
                    descInfo.setText(getResources().getString(R.string.normal_weight_desc_woman));
                }
                if(userBmiIndex >= 29.0 && userBmiIndex < 34.0) {
                    shortInfo.setText(getResources().getString(R.string.overweight));
                    descInfo.setText(getResources().getString(R.string.overweight_desc));
                }
                if(userBmiIndex >= 34.0 && userBmiIndex <= 44.0) {
                    shortInfo.setText(getResources().getString(R.string.adiposity));
                    descInfo.setText(getResources().getString(R.string.adiposity_desc));
                }
                if(userBmiIndex > 44) {
                    shortInfo.setText(getResources().getString(R.string.severe_adiposity));
                    descInfo.setText(getResources().getString(R.string.severe_adiposity_desc));
                }
            }
        }

        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}