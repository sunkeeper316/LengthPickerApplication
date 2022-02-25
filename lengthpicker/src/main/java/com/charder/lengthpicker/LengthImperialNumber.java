package com.charder.lengthpicker;

public class LengthImperialNumber {
    int number_ft_value = 0;
    int number_in_value = 0;
    int number_decimal_value = 0;

    public static LengthImperialNumber setInchValue(double all_in_value){
        LengthImperialNumber lengthImperialNumber = new LengthImperialNumber();

        lengthImperialNumber.number_ft_value = (int) (all_in_value / 12);
        lengthImperialNumber.number_in_value = (int) (all_in_value % 12);
        lengthImperialNumber.number_decimal_value = (int) (((all_in_value - lengthImperialNumber.number_ft_value) * 10) % 10 );
        return lengthImperialNumber;
    }

    public void setNumber_ft_value(int number_ft_value) {
        this.number_ft_value = number_ft_value;
    }

    public void setNumber_in_value(int number_in_value) {
        this.number_in_value = number_in_value;
    }

    public void setNumber_decimal_value(int number_decimal_value) {
        this.number_decimal_value = number_decimal_value;
    }

    public int getNumber_ft_value() {
        return number_ft_value;
    }

    public int getNumber_in_value() {
        return number_in_value;
    }

    public int getNumber_decimal_value() {
        return number_decimal_value;
    }
    public double get_in_addDecimal_value() {

        return number_in_value + ((double) number_decimal_value / 10 );
    }

    public double getAll_in_value() {
        return number_ft_value * 12 + number_in_value + ((double) number_decimal_value / 10 );
    }
}
