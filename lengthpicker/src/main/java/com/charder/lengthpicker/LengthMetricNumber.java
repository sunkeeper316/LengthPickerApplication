package com.charder.lengthpicker;

public class LengthMetricNumber {
    int number_hundred_value = 0;
    int number_ten_value = 0;
    int number_one_value = 0;
    int number_decimal_value = 0;

    public static LengthMetricNumber setCMValue(double cm_value){
        LengthMetricNumber lengthMetricNumber = new LengthMetricNumber();

        lengthMetricNumber.number_hundred_value = (int) ((cm_value%1000)/ 100);
        lengthMetricNumber.number_ten_value = (int) ((cm_value%100)/ 10);
        lengthMetricNumber.number_one_value = (int) ((cm_value%10));
        lengthMetricNumber.number_decimal_value = (int) ((cm_value * 10) % 10 );
        return lengthMetricNumber;
    }

    public double getAll_cm_value() {
        return (double)number_hundred_value * 100 + (double)number_ten_value * 10 + (double) number_one_value + ((double) number_decimal_value / 10 );
    }

    public int getNumber_hundred_value() {
        return number_hundred_value;
    }

    public void setNumber_hundred_value(int number_hundred_value) {
        this.number_hundred_value = number_hundred_value;
    }

    public int getNumber_ten_value() {
        return number_ten_value;
    }

    public void setNumber_ten_value(int number_ten_value) {
        this.number_ten_value = number_ten_value;
    }

    public int getNumber_one_value() {
        return number_one_value;
    }

    public void setNumber_one_value(int number_one_value) {
        this.number_one_value = number_one_value;
    }

    public int getNumber_decimal_value() {
        return number_decimal_value;
    }

    public void setNumber_decimal_value(int number_decimal_value) {
        this.number_decimal_value = number_decimal_value;
    }
}
