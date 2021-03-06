package com.example.firsttask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView entryFieldCalc;
    ArrayList<String> dataLine = new ArrayList<>();
    ArrayList<String> numbers = new ArrayList<>();
    ArrayList<String> signs = new ArrayList<>();

    private DataCalculator dataCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.constraint_layout_calculator);

        entryFieldCalc = findViewById(R.id.entryFieldCalc);

        if (savedInstanceState == null){
            dataCalculator = new DataCalculator();
        }

        initButtons();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        /*outState.putStringArrayList("dataLine", dataLine);
        outState.putStringArrayList("numbers", numbers);
        outState.putStringArrayList("signs", signs);*/
        dataCalculator.setDataLine(dataLine);
        dataCalculator.setNumbers(numbers);
        dataCalculator.setSigns(signs);
        outState.putParcelable("dataCalculator", dataCalculator);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        dataCalculator = (DataCalculator) savedInstanceState.getParcelable("dataCalculator");
        dataLine = dataCalculator.getDataLine();
        numbers = dataCalculator.getNumbers();
        signs = dataCalculator.getSigns();
        updateView();
    }

    private void initButtons() {
        Button button0 = findViewById(R.id.button_0);
        button0.setOnClickListener(this);
        Button button1 = findViewById(R.id.button_1);
        button1.setOnClickListener(this);
        Button button2 = findViewById(R.id.button_2);
        button2.setOnClickListener(this);
        Button button3 = findViewById(R.id.button_3);
        button3.setOnClickListener(this);
        Button button4 = findViewById(R.id.button_4);
        button4.setOnClickListener(this);
        Button button5 = findViewById(R.id.button_5);
        button5.setOnClickListener(this);
        Button button6 = findViewById(R.id.button_6);
        button6.setOnClickListener(this);
        Button button7 = findViewById(R.id.button_7);
        button7.setOnClickListener(this);
        Button button8 = findViewById(R.id.button_8);
        button8.setOnClickListener(this);
        Button button9 = findViewById(R.id.button_9);
        button9.setOnClickListener(this);
        Button button_backspace = findViewById(R.id.button_backspace);
        button_backspace.setOnClickListener(this);
        Button button_delete = findViewById(R.id.button_delete);
        button_delete.setOnClickListener(this);
        Button button_square_root = findViewById(R.id.button_square_root);
        button_square_root.setOnClickListener(this);
        Button button_square = findViewById(R.id.button_square);
        button_square.setOnClickListener(this);
        Button button_point = findViewById(R.id.button_point);
        button_point.setOnClickListener(this);
        Button button_plus = findViewById(R.id.button_plus);
        button_plus.setOnClickListener(this);
        Button button_multiply = findViewById(R.id.button_multiply);
        button_multiply.setOnClickListener(this);
        Button button_minus = findViewById(R.id.button_minus);
        button_minus.setOnClickListener(this);
        Button button_equal = findViewById(R.id.button_equal);
        button_equal.setOnClickListener(this);
        Button button_div = findViewById(R.id.button_div);
        button_div.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_0){
            if (!dataLine.isEmpty()){
                if (!dataLine.get(dataLine.size() - 1).equals("0")){
                    dataLine.add("0");
                    updateView();
                }
            }
        }
        if (view.getId() == R.id.button_1){
            dataLine.add("1");
            updateView();
        }
        if (view.getId() == R.id.button_2){
            dataLine.add("2");
            updateView();
        }
        if (view.getId() == R.id.button_3){
            dataLine.add("3");
            updateView();
        }
        if (view.getId() == R.id.button_4){
            dataLine.add("4");
            updateView();
        }
        if (view.getId() == R.id.button_5){
            dataLine.add("5");
            updateView();
        }
        if (view.getId() == R.id.button_6){
            dataLine.add("6");
            updateView();
        }
        if (view.getId() == R.id.button_7){
            dataLine.add("7");
            updateView();
        }
        if (view.getId() == R.id.button_8){
            dataLine.add("8");
            updateView();
        }
        if (view.getId() == R.id.button_9){
            dataLine.add("9");
            updateView();
        }
        if (view.getId() == R.id.button_point){
            if (dataLine.isEmpty() || isOperator(dataLine.get(dataLine.size() - 1))){
                dataLine.add("0");
                dataLine.add(".");
            }
            if (!dataLine.get(dataLine.size() - 1).equals(".")){
                dataLine.add(".");
            }
            updateView();
        }
        if (view.getId() == R.id.button_delete){
            dataLine.clear();
            updateView();
        }
        if (view.getId() == R.id.button_backspace){
            if (!dataLine.isEmpty()){
                dataLine.remove(dataLine.size() - 1);
                updateView();
            }
        }
        if (view.getId() == R.id.button_plus){
            if (!dataLine.isEmpty()){
                if (isOperator(dataLine.get(dataLine.size() - 1))){
                    if (!dataLine.get(dataLine.size() - 1).equals("+")){
                        dataLine.remove(dataLine.size() - 1);
                        dataLine.add("+");
                    }
                } else {
                    dataLine.add("+");
                }
                updateView();
            }
        }
        if (view.getId() == R.id.button_minus){
            if (!dataLine.isEmpty()){
                if (isOperator(dataLine.get(dataLine.size() - 1))){
                    if (!dataLine.get(dataLine.size() - 1).equals("-")){
                        dataLine.remove(dataLine.size() - 1);
                        dataLine.add("-");
                    }
                } else {
                    dataLine.add("-");
                }
                updateView();
            }
        }
        if (view.getId() == R.id.button_multiply){
            if (!dataLine.isEmpty()){
                if (isOperator(dataLine.get(dataLine.size() - 1))){
                    if (!dataLine.get(dataLine.size() - 1).equals("*")){
                        dataLine.remove(dataLine.size() - 1);
                        dataLine.add("*");
                    }
                } else {
                    dataLine.add("*");
                }
                updateView();
            }
        }
        if (view.getId() == R.id.button_div){
            if (!dataLine.isEmpty()){
                if (isOperator(dataLine.get(dataLine.size() - 1))){
                    if (!dataLine.get(dataLine.size() - 1).equals("/")){
                        dataLine.remove(dataLine.size() - 1);
                        dataLine.add("/");
                    }
                } else {
                    dataLine.add("/");
                }
                updateView();
            }
        }
        if (view.getId() == R.id.button_square){
            boolean contentOperator = false;
            if (!dataLine.isEmpty()){
                for (String s: dataLine) {
                    if (isOperator(s)) {
                        contentOperator = true;
                        break;
                    }
                }
            }
            if (!dataLine.isEmpty() && !contentOperator) {
                long number = Long.parseLong(entryFieldCalc.getText().toString());
                number *= number;
                String res = String.valueOf(number);
                entryFieldCalc.setText(res);
                dataLine.clear();
                dataLine.add(res);
            }
        }
        if (view.getId() == R.id.button_square_root){
            boolean contentOperator = false;
            if (!dataLine.isEmpty()){
                for (String s: dataLine) {
                    if (isOperator(s)) {
                        contentOperator = true;
                        break;
                    }
                }
            }
            if (!dataLine.isEmpty() && !contentOperator) {
                long number = Long.parseLong(entryFieldCalc.getText().toString());
                double temp = Math.sqrt(number);
                String res;
                if (temp % 1 == 0){
                    res = String.format("%d", (long)Math.sqrt(number));

                } else {
                    res = String.format("%.3f", Math.sqrt(number));
                }
                entryFieldCalc.setText(res);
                dataLine.clear();
                dataLine.add(res);
            }
        }
        if (view.getId() == R.id.button_equal){
            String temp1 = "";
            int j = 0;
            for (String s: dataLine) {
                j++;
                if (!isOperator(s)){
                    if (signs.isEmpty()){
                        signs.add("+");
                    }
                    temp1 += s;
                    if (dataLine.size() == j){
                        numbers.add(temp1);
                    }
                } else {
                    signs.add(s);
                    numbers.add(temp1);
                    temp1 = "";
                }
            }
            String res = calculate(numbers, signs);
            entryFieldCalc.setText(res);
            dataLine.clear();
            dataLine.add(res);
            numbers.clear();
            signs.clear();
        }
    }

    private String calculate(ArrayList<String> numbers, ArrayList<String> signs) {
        double result = 0;
        for (int i = 0; i < signs.size(); i++) {
            if (signs.get(i).equals("+")){
                result += Double.parseDouble(numbers.get(i));
            }
            if (signs.get(i).equals("-")){
                result -= Double.parseDouble(numbers.get(i));
            }
            if (signs.get(i).equals("*")){
                result *= Double.parseDouble(numbers.get(i));
            }
            if (signs.get(i).equals("/")){
                result /= Double.parseDouble(numbers.get(i));
            }
        }
        if (result % 1 == 0) {
            return String.valueOf((long) result);
        }
        return String.valueOf(result);
    }

    private boolean isOperator(String symbol) {
        if (symbol.equals("+") || symbol.equals("-") || symbol.equals("*") || symbol.equals("/")){
            return true;
        }
        return false;
    }

    private void updateView() {
        if (dataLine.isEmpty()){
            entryFieldCalc.setText("0");
        } else {
            String dataInString = TextUtils.join("", dataLine);
            entryFieldCalc.setText(dataInString);
        }
    }
}