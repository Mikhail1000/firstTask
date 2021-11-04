package com.example.firsttask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTheme(loadAppTheme());
        setContentView(R.layout.activity_main2);
        loadElementsTheme(findViewById(R.id.textView2), findViewById(R.id.switch_theme));

        SwitchMaterial switchMaterial = findViewById(R.id.switch_theme);
        setCurrentSwitchPosition(switchMaterial);

        switchMaterial.setOnClickListener(v -> {
            boolean checked = switchMaterial.isChecked();
            if (checked) {
                saveAppTheme("night");
            } else {
                saveAppTheme("day");
            }
            recreate();
        });

        findViewById(R.id.button_return).setOnClickListener(v -> {
            Intent data = new Intent();
            setResult(RESULT_OK, data);
            finish();
        });
    }

    private void setCurrentSwitchPosition(SwitchMaterial switchMaterial) {
        String theme = getSharedPreferences(MainActivity.PREFERENCES_THEME, MODE_PRIVATE)
                .getString(MainActivity.THEME_NAME, "day");
        if (theme.equals("night")) {
            switchMaterial.setChecked(true);
        } else {
            switchMaterial.setChecked(false);
        }
    }

    private void loadElementsTheme(TextView textview, SwitchMaterial switchview) {
        String theme = getSharedPreferences(MainActivity.PREFERENCES_THEME, MODE_PRIVATE)
                .getString(MainActivity.THEME_NAME, "day");
        if (theme.equals("day")) {
            textview.setBackgroundResource(R.color.purple_500);
            switchview.setBackgroundResource(R.color.purple_500);
        } else {
            textview.setBackgroundResource(R.color.gray);
            switchview.setBackgroundResource(R.color.gray);
            textview.setTextColor(Color.BLACK);
            switchview.setTextColor(Color.BLACK);
        }
    }

    private int loadAppTheme() {
        String theme = getSharedPreferences(MainActivity.PREFERENCES_THEME, MODE_PRIVATE)
                .getString(MainActivity.THEME_NAME, "day");
        if (theme.equals("day")) {
            return R.style.MyStyleLight;
        } else if (theme.equals("night")) {
            return R.style.MyStyleDark;
        } else {
            return R.style.Theme_FirstTask;
        }
    }

    private void saveAppTheme(String nameTheme) {
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.PREFERENCES_THEME, MODE_PRIVATE);
        sharedPreferences.edit()
                .putString(MainActivity.THEME_NAME, nameTheme)
                .apply();
    }
}