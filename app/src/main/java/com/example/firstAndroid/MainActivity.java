package com.example.firstAndroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private int value;
    private TextView entryFieldCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_layout_calculator);

        entryFieldCalc = findViewById(R.id.entryFieldCalc);

        initButton1();
        initButton2();
        initButtonClean();

    }

    protected void initButton1() {
        Button button1 = findViewById(R.id.button_1);
        button1.setOnClickListener(v -> {
            String tmpValue = Integer.toString(value);
            value = Integer.parseInt(tmpValue + "1");

            //установить текст на TextView
            entryFieldCalc.setText(String.format(Locale.getDefault(), "%d", value));
        });
    }

    protected void initButton2() {
        Button button2 = findViewById(R.id.button_2);
        button2.setOnClickListener(v -> {
            String tmpValue = Integer.toString(value);
            value = Integer.parseInt(tmpValue + "2");

            //установить текст на TextView
            entryFieldCalc.setText(String.format(Locale.getDefault(), "%d", value));
        });
    }

    protected void initButtonClean() {
        Button buttonClean = findViewById(R.id.button_clean);
        buttonClean.setOnClickListener(v -> {
            value = 0;
            //установить текст на TextView
            entryFieldCalc.setText(String.format(Locale.getDefault(), "%d", value));
        });
    }
}