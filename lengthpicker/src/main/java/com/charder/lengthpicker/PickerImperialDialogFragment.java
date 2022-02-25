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

public class PickerImperialDialogFragment extends DialogFragment {

    public static final String TAG = "PickerImperialDialog";

    OnOKClickListener onOKClickListener;
    OnValueChangedListener onValueChangedListener;

    LengthImperialNumber lengthImperialNumber = new LengthImperialNumber();

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public Dialog onCreateDialog(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View customView = getActivity().getLayoutInflater().inflate(R.layout.dialog_picker_imperial, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(customView);
        AlertDialog alertDialog = builder.create();
        alertDialog.setCanceledOnTouchOutside(false);

        Window win = alertDialog.getWindow();
        WindowManager.LayoutParams lp = win.getAttributes();
        lp.gravity = Gravity.BOTTOM;
        win.setAttributes(lp);
        NumberPicker number_ft = customView.findViewById(R.id.number_ft);
        number_ft.setMaxValue(9);
        number_ft.setMinValue(0);
        number_ft.setValue(lengthImperialNumber.getNumber_ft_value());
        number_ft.setOnValueChangedListener((numberPicker, oldV, newV) -> {
            lengthImperialNumber.setNumber_ft_value(newV);
            double metric_value = Calculation.iToMHeight(lengthImperialNumber.getAll_in_value());
            this.onValueChangedListener.onClick(numberPicker , lengthImperialNumber.getAll_in_value() , metric_value);
        });

        NumberPicker number_inch = customView.findViewById(R.id.number_inch);
        number_inch.setMaxValue(11);
        number_inch.setMinValue(0);
        number_inch.setValue(lengthImperialNumber.getNumber_in_value());
        number_inch.setOnValueChangedListener((numberPicker, oldV, newV) -> {
            lengthImperialNumber.setNumber_in_value(newV);
            double metric_value = Calculation.iToMHeight(lengthImperialNumber.getAll_in_value());
            this.onValueChangedListener.onClick(numberPicker , lengthImperialNumber.getAll_in_value() , metric_value);
        });

        NumberPicker number_decimal = customView.findViewById(R.id.number_decimal);
        number_decimal.setMaxValue(9);
        number_decimal.setMinValue(0);
        number_decimal.setValue(lengthImperialNumber.getNumber_decimal_value());
        number_decimal.setOnValueChangedListener((numberPicker, oldV, newV) -> {
            lengthImperialNumber.setNumber_decimal_value(newV);
            double metric_value = Calculation.iToMHeight(lengthImperialNumber.getAll_in_value());
            this.onValueChangedListener.onClick(numberPicker , lengthImperialNumber.getAll_in_value() , metric_value);
        });
        TextView tv_ok = customView.findViewById(R.id.tv_ok);
        tv_ok.setOnClickListener( v -> {
            double metric_value = Calculation.iToMHeight(lengthImperialNumber.getAll_in_value());
            this.onOKClickListener.onClick(v , lengthImperialNumber.getAll_in_value() , metric_value);
            alertDialog.dismiss();
        });

        return alertDialog;
    }
    public PickerImperialDialogFragment setValue(double inchValue){
        lengthImperialNumber = LengthImperialNumber.setInchValue(inchValue);
        return this;
    }

    public PickerImperialDialogFragment setOnOKClickListener(OnOKClickListener onOKClickListener){
        this.onOKClickListener = onOKClickListener;
        return this;
    }
    public PickerImperialDialogFragment setOnValueChangedListener(OnValueChangedListener onValueChangedListener){
        this.onValueChangedListener = onValueChangedListener;
        return this;
    }





}
