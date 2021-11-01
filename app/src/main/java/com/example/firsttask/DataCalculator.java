package com.example.firsttask;

import java.util.ArrayList;
import android.os.Parcel;
import android.os.Parcelable;


public class DataCalculator implements Parcelable {
    ArrayList<String> dataLine = new ArrayList<>();
    ArrayList<String> numbers = new ArrayList<>();
    ArrayList<String> signs = new ArrayList<>();

    public DataCalculator(ArrayList<String> dataLine, ArrayList<String> numbers, ArrayList<String> signs) {
        this.dataLine = dataLine;
        this.numbers = numbers;
        this.signs = signs;
    }

    public DataCalculator() {
    }

    protected DataCalculator(Parcel in) {
        dataLine = in.createStringArrayList();
        numbers = in.createStringArrayList();
        signs = in.createStringArrayList();
    }

    public static final Creator<DataCalculator> CREATOR = new Creator<DataCalculator>() {
        @Override
        public DataCalculator createFromParcel(Parcel in) {
            return new DataCalculator(in);
        }

        @Override
        public DataCalculator[] newArray(int size) {
            return new DataCalculator[size];
        }
    };

    public ArrayList<String> getDataLine() {
        return dataLine;
    }

    public void setDataLine(ArrayList<String> dataLine) {
        this.dataLine = dataLine;
    }

    public ArrayList<String> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<String> numbers) {
        this.numbers = numbers;
    }

    public ArrayList<String> getSigns() {
        return signs;
    }

    public void setSigns(ArrayList<String> signs) {
        this.signs = signs;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(dataLine);
        dest.writeStringList(numbers);
        dest.writeStringList(signs);
    }
}
