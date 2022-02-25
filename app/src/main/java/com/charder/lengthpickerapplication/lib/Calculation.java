package com.charder.lengthpickerapplication.lib;

public class Calculation {
    public static double mToIHeight(double height) { // 單位轉換 公制轉英制
        return height / 2.54;
    }
    public static double iToMHeight(double height) { // 單位轉換 英制轉公制
        return height * 2.54;
    }
}
