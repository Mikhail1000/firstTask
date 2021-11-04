package com.example.firsttask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity2 extends AppCompatActivity {

    boolean checkedNight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        checkedNight = getIntent().getBooleanExtra(MainActivity.CHECK_NIGHT, false);



        setTheme(loadAppTheme());

        setContentView(R.layout.activity_main2);
        SwitchMaterial switchMaterial = findViewById(R.id.switch_theme);

        String theme = getSharedPreferences(MainActivity.PREFERENCES_THEME,MODE_PRIVATE)
                .getString(MainActivity.THEME_NAME, "day");
        if (theme.equals("day")) {
            switchMaterial.setChecked(false);
        } else if (theme.equals("night")) {
            switchMaterial.setChecked(true);
        } else {
            switchMaterial.setChecked(false);
        }


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
            checkedNight = switchMaterial.isChecked();

            Intent data = new Intent();
            data.putExtra(MainActivity.CHECK_NIGHT, checkedNight);

            setResult(RESULT_OK, data);

            finish();
        });



    }


    private int loadAppTheme(){
        String theme = getSharedPreferences(MainActivity.PREFERENCES_THEME,MODE_PRIVATE)
                .getString(MainActivity.THEME_NAME, "day");
        if (theme.equals("day")) {
            return R.style.MyStyleLight;
        } else if (theme.equals("night")){
            return R.style.MyStyleDark;
        } else {
            return R.style.Theme_FirstTask;
        }
    }

    private void saveAppTheme(String nameTheme) {
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.PREFERENCES_THEME,MODE_PRIVATE);
        sharedPreferences.edit()
                .putString(MainActivity.THEME_NAME, nameTheme)
                .apply();
    }
}