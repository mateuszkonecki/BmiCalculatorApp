package pl.mateuszkonecki.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private Button calculateButton;
    private EditText heightET, weightET, ageET;
    private RadioGroup radioGroup;
    RadioButton selectedGender;

    public static final String HEIGHT_KEY = "height";
    public static final String WEIGHT_KEY = "weight";
    public static final String AGE_KEY = "age";
    public static final String GENDER_KEY = "gender";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        calculateButton = findViewById(R.id.calculateButton);
        heightET = findViewById(R.id.heightET);
        weightET = findViewById(R.id.weightET);
        ageET = findViewById(R.id.ageET);
        radioGroup = findViewById(R.id.radioGroup);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String height = heightET.getText().toString();
                String weight = weightET.getText().toString();
                String age = ageET.getText().toString();

                if(height.isEmpty() || weight.isEmpty() || age.isEmpty()) {
                    Toast.makeText(HomeActivity.this, getResources().getString(R.string.toast_alert), Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(HomeActivity.this, ResultActivity.class);

                    int selectedRadioId = radioGroup.getCheckedRadioButtonId();
                    selectedGender = findViewById(selectedRadioId);

                    if(selectedRadioId == -1) {
                        Toast.makeText(HomeActivity.this, getResources().getString(R.string.toast_alert), Toast.LENGTH_LONG).show();
                    } else {
                        intent.putExtra(HEIGHT_KEY, height);
                        intent.putExtra(WEIGHT_KEY, weight);
                        intent.putExtra(AGE_KEY, age);
                        intent.putExtra(GENDER_KEY, selectedGender.getText().toString());
                        startActivity(intent);
                    }
                }
            }
        });
    }
}