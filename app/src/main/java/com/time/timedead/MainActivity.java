package com.time.timedead;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int allSum;

    int sum1 = 0;
    int sum2 = 0;
    int sum3 = 0;

    EditText username;
    EditText yy;
    EditText dd;
    EditText mm;
    EditText height;
    EditText weight;

    Button go;
    Button clear;

    CheckBox male;
    CheckBox female;
    CheckBox asia;
    CheckBox australia;
    CheckBox afrika;
    CheckBox europe;
    CheckBox north_america;
    CheckBox sourth_america;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        go = findViewById(R.id.go);
        clear = findViewById(R.id.clear);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        asia = findViewById(R.id.asia);
        australia = findViewById(R.id.australia);
        afrika = findViewById(R.id.afrika);
        europe = findViewById(R.id.europe);
        north_america = findViewById(R.id.north_america);
        sourth_america = findViewById(R.id.sourth_america);
        yy = findViewById(R.id.yy);
        dd = findViewById(R.id.dd);
        mm = findViewById(R.id.mm);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                push();
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
            }
        });

    }

    private void clear() {
        username.setText("");
        height.setText("");
        weight.setText("");
        mm.setText("");
        dd.setText("");
        yy.setText("");
    }


    private void push() {

                if (username.length() > 2 && username.length() < 13 &&
                yy.length() > 3 && yy.length() < 5 &&
                dd.length() > 0 && dd.length() < 3 &&
                mm.length() > 0 && mm.length() < 3 &&
                weight.length() > 1 && weight.length() < 4 &&
                height.length() > 2 && height.length() < 4) {
            Intent intent = new Intent(MainActivity.this, Dead.class);
            intent.putExtra("username", username.getText().toString());
            startActivity(intent);
        } else {
            Toast.makeText(this, "Oh oh something went wrong", Toast.LENGTH_SHORT).show();
        }

        String string_yy = yy.getText().toString();
        String string_mm = mm.getText().toString();
        String string_dd = dd.getText().toString();

        char[] yyToArray = string_yy.toCharArray();
        char[] mmToArray = string_mm.toCharArray();
        char[] ddToArray = string_dd.toCharArray();

        int[] numYY = new int[string_yy.length()];
        int[] numMM = new int[string_mm.length()];
        int[] numDD = new int[string_dd.length()];


        for(int i = 0; i < string_yy.length() ; i++){
            numYY[i] = Integer.parseInt(String.valueOf(yyToArray[i]));
        }
        for(int i = 0; i < string_mm.length(); i++){
            numMM[i] = Integer.parseInt(String.valueOf(mmToArray[i]));
        }
        for(int i = 0; i < string_dd.length(); i++){
            numDD[i] = Integer.parseInt(String.valueOf(ddToArray[i]));
        }

        for (int i = 0; i < numYY.length; i++){
            sum1=sum1+numYY[i];
        }
        for (int i = 0; i < numMM.length; i++){
            sum2=sum2+numMM[i];
        }
        for (int i = 0; i < numDD.length; i++){
            sum3=sum3+numDD[i];
        }

        allSum = (sum1 + sum2 + sum3) + sum2 + (sum2 * 2);

        Dead.Dead(allSum);
    }

    public void onCheckboxClicked(View view) {
        CheckBox gender = (CheckBox) view;
        boolean checked = gender.isChecked();
        switch (view.getId()) {
            case R.id.male:
                if (checked) {
                    Toast.makeText(this, "Male", Toast.LENGTH_SHORT).show();
                    female.setEnabled(false);
                } else {
                    female.setEnabled(true);
                }
                break;
            case R.id.female:
                if (checked) {
                    Toast.makeText(this, "Female", Toast.LENGTH_SHORT).show();
                    male.setEnabled(false);
                } else {
                    male.setEnabled(true);
                }

                break;
        }
    }

    public void onCheckboxClicked2(View view) {
        CheckBox continent = (CheckBox) view;
        boolean checked = continent.isChecked();
        switch (view.getId()) {
            case R.id.asia:
                if (checked) {
                    Toast.makeText(this, "Asia", Toast.LENGTH_SHORT).show();
                    afrika.setEnabled(false);
                    australia.setEnabled(false);
                    europe.setEnabled(false);
                    north_america.setEnabled(false);
                    sourth_america.setEnabled(false);
                } else {
                    afrika.setEnabled(true);
                    australia.setEnabled(true);
                    europe.setEnabled(true);
                    north_america.setEnabled(true);
                    sourth_america.setEnabled(true);
                }
                break;
            case R.id.afrika:
                if (checked) {
                    Toast.makeText(this, "Afrika", Toast.LENGTH_SHORT).show();
                    asia.setEnabled(false);
                    australia.setEnabled(false);
                    europe.setEnabled(false);
                    north_america.setEnabled(false);
                    sourth_america.setEnabled(false);
                } else {
                    asia.setEnabled(true);
                    australia.setEnabled(true);
                    europe.setEnabled(true);
                    north_america.setEnabled(true);
                    sourth_america.setEnabled(true);
                }
                break;
            case R.id.australia:
                if (checked) {
                    Toast.makeText(this, "Australia", Toast.LENGTH_SHORT).show();
                    afrika.setEnabled(false);
                    asia.setEnabled(false);
                    europe.setEnabled(false);
                    north_america.setEnabled(false);
                    sourth_america.setEnabled(false);
                } else {
                    afrika.setEnabled(true);
                    asia.setEnabled(true);
                    europe.setEnabled(true);
                    north_america.setEnabled(true);
                    sourth_america.setEnabled(true);
                }
                break;
            case R.id.europe:
                if (checked) {
                    Toast.makeText(this, "Europe", Toast.LENGTH_SHORT).show();
                    afrika.setEnabled(false);
                    australia.setEnabled(false);
                    asia.setEnabled(false);
                    north_america.setEnabled(false);
                    sourth_america.setEnabled(false);
                } else {
                    afrika.setEnabled(true);
                    australia.setEnabled(true);
                    asia.setEnabled(true);
                    north_america.setEnabled(true);
                    sourth_america.setEnabled(true);
                }
                break;
            case R.id.north_america:
                if (checked) {
                    Toast.makeText(this, "North America", Toast.LENGTH_SHORT).show();
                    afrika.setEnabled(false);
                    australia.setEnabled(false);
                    europe.setEnabled(false);
                    asia.setEnabled(false);
                    sourth_america.setEnabled(false);
                } else {
                    afrika.setEnabled(true);
                    australia.setEnabled(true);
                    europe.setEnabled(true);
                    asia.setEnabled(true);
                    sourth_america.setEnabled(true);
                }
                break;
            case R.id.sourth_america:
                if (checked) {
                    Toast.makeText(this, "Sourth America", Toast.LENGTH_SHORT).show();
                    afrika.setEnabled(false);
                    australia.setEnabled(false);
                    europe.setEnabled(false);
                    north_america.setEnabled(false);
                    asia.setEnabled(false);
                } else {
                    afrika.setEnabled(true);
                    australia.setEnabled(true);
                    europe.setEnabled(true);
                    north_america.setEnabled(true);
                    asia.setEnabled(true);
                }
                break;
        }
    }

}