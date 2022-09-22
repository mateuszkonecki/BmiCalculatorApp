package pl.mateuszkonecki.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class HomeActivity extends AppCompatActivity {

    private Button calculateButton;
    private ImageView exitView;
    private EditText heightET, weightET, ageET;
    private RadioGroup radioGroup;
    RadioButton selectedGender;
    TextInputLayout textLayoutFirst, textLayout2, textLayout3;

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
        textLayoutFirst = findViewById(R.id.textLayoutFirst);
        textLayout2 = findViewById(R.id.textInputLayout2);
        textLayout3 = findViewById(R.id.textInputLayout3);
        exitView = findViewById(R.id.exit);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String height = heightET.getText().toString();
                String weight = weightET.getText().toString();
                String age = ageET.getText().toString();

                if(height.isEmpty()) {
                    heightET.setError(getResources().getString(R.string.toast_alert));
                } else if(weight.isEmpty()) {
                    weightET.setError(getResources().getString(R.string.toast_alert));
                } else if(age.isEmpty()) {
                    ageET.setError(getResources().getString(R.string.toast_alert));
                } else if(height.contains(".")) {
                    heightET.setError(getResources().getString(R.string.dot_alert_toast));
                } else if(weight.contains(".")) {
                    weightET.setError(getResources().getString(R.string.dot_alert_toast));
                } else if(age.contains(".")) {
                    ageET.setError(getResources().getString(R.string.dot_alert_toast));
                } else {
                    int ageInt = Integer.parseInt(age);
                    if(ageInt < 1) {
                        ageET.setError(getResources().getString(R.string.age_alert_toast));
                    } else {
                        Intent intent = new Intent(HomeActivity.this, ResultActivity.class);

                        int selectedRadioId = radioGroup.getCheckedRadioButtonId();
                        selectedGender = findViewById(selectedRadioId);

                        if(selectedRadioId == -1) {
                            Toast.makeText(HomeActivity.this, getResources().getString(R.string.toast_select_alert), Toast.LENGTH_SHORT).show();
                        } else {
                            intent.putExtra(HEIGHT_KEY, height);
                            intent.putExtra(WEIGHT_KEY, weight);
                            intent.putExtra(AGE_KEY, age);
                            intent.putExtra(GENDER_KEY, selectedGender.getText().toString());
                            startActivity(intent);
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        }
                    }
                }
            }
        });

        exitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(HomeActivity.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle(getResources().getString(R.string.questTitle))
                        .setMessage(getResources().getString(R.string.questMsg))
                        .setPositiveButton(getResources().getString(R.string.exitYes), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        })

                        .setNegativeButton(getResources().getString(R.string.exitNo), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .show();
            }
        });
    }
}