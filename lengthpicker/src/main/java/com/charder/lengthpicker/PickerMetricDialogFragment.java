package com.charder.lengthpicker;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.charder.lengthpicker.listener.OnOKClickListener;
import com.charder.lengthpicker.listener.OnValueChangedListener;

import org.jetbrains.annotations.NotNull;

public class PickerMetricDialogFragment extends DialogFragment {

    public static final String TAG = "PickerMetricDialog";

    OnOKClickListener onOKClickListener;
    OnValueChangedListener onValueChangedListener;

    double value = 0;
    String text_ok = "OK";

    LengthMetricNumber lengthMetricNumber = new LengthMetricNumber();

    @NonNull
    @NotNull
    @Override
    public Dialog onCreateDialog(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View customView = getActivity().getLayoutInflater().inflate(R.layout.dialog_picker_metric, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(customView);
        AlertDialog alertDialog = builder.create();
        alertDialog.setCanceledOnTouchOutside(false);

        Window win = alertDialog.getWindow();
        WindowManager.LayoutParams lp = win.getAttributes();
        lp.gravity = Gravity.BOTTOM;
        win.setAttributes(lp);
        NumberPicker number_ft = customView.findViewById(R.id.number_hundred);
        number_ft.setMaxValue(9);
        number_ft.setMinValue(0);
        number_ft.setValue(lengthMetricNumber.getNumber_hundred_value());
        number_ft.setOnValueChangedListener((numberPicker, oldV, newV) -> {
            lengthMetricNumber.setNumber_hundred_value(newV);
            double imperial_value = Calculation.mToIHeight(lengthMetricNumber.getAll_cm_value());
            this.onValueChangedListener.onClick(numberPicker , imperial_value , lengthMetricNumber.getAll_cm_value());
        });

        NumberPicker number_inch = customView.findViewById(R.id.number_ten);
        number_inch.setMaxValue(9);
        number_inch.setMinValue(0);
        number_inch.setValue(lengthMetricNumber.getNumber_ten_value());
        number_inch.setOnValueChangedListener((numberPicker, oldV, newV) -> {
            lengthMetricNumber.setNumber_ten_value(newV);
            double imperial_value = Calculation.mToIHeight(lengthMetricNumber.getAll_cm_value());
            this.onValueChangedListener.onClick(numberPicker , imperial_value , lengthMetricNumber.getAll_cm_value());
        });

        NumberPicker number_one = customView.findViewById(R.id.number_one);
        number_one.setMaxValue(9);
        number_one.setMinValue(0);
        number_one.setValue(lengthMetricNumber.getNumber_one_value());
        number_one.setOnValueChangedListener((numberPicker, oldV, newV) -> {
            lengthMetricNumber.setNumber_one_value(newV);
            double imperial_value = Calculation.mToIHeight(lengthMetricNumber.getAll_cm_value());
            this.onValueChangedListener.onClick(numberPicker , imperial_value , lengthMetricNumber.getAll_cm_value());
        });
        NumberPicker number_decimal = customView.findViewById(R.id.number_decimal);
        number_decimal.setMaxValue(9);
        number_decimal.setMinValue(0);
        number_decimal.setValue(lengthMetricNumber.getNumber_decimal_value());
        number_decimal.setOnValueChangedListener((numberPicker, oldV, newV) -> {
            lengthMetricNumber.setNumber_decimal_value(newV);
            double imperial_value = Calculation.mToIHeight(lengthMetricNumber.getAll_cm_value());
            this.onValueChangedListener.onClick(numberPicker , imperial_value , lengthMetricNumber.getAll_cm_value());
        });
        TextView tv_ok = customView.findViewById(R.id.tv_ok);
        tv_ok.setText(text_ok);
        tv_ok.setOnClickListener( v -> {
            double imperial_value = Calculation.mToIHeight(lengthMetricNumber.getAll_cm_value());
            this.onOKClickListener.onClick(v , imperial_value , lengthMetricNumber.getAll_cm_value());
            alertDialog.dismiss();
        });

        return alertDialog;
    }
    public PickerMetricDialogFragment setOKText(String text) {
        this.text_ok = text;
        return this;
    }
    public PickerMetricDialogFragment setValue(double cmValue){
        lengthMetricNumber = LengthMetricNumber.setCMValue(cmValue);
        return this;
    }
    public PickerMetricDialogFragment setOnOKClickListener(OnOKClickListener onOKClickListener){
        this.onOKClickListener = onOKClickListener;
        return this;
    }
    public PickerMetricDialogFragment setOnValueChangedListener(OnValueChangedListener onValueChangedListener){
        this.onValueChangedListener = onValueChangedListener;
        return this;
    }
}
