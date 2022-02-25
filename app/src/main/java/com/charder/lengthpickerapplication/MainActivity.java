package com.charder.lengthpickerapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.charder.lengthpickerapplication.lib.LengthImperialNumber;
import com.charder.lengthpickerapplication.lib.LengthMetricNumber;
import com.charder.lengthpickerapplication.lib.PickerImperialDialogFragment;
import com.charder.lengthpickerapplication.lib.PickerMetricDialogFragment;

public class MainActivity extends AppCompatActivity {

    EditText length_edit;
    TextView tv_show;

    RadioGroup radioGroup ;

    double i_value = 0;
    double m_value = 0;

    int unit = 0;  // 0 == metric
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener((radioGroup, id) -> {
            switch (id) {
                case R.id.rb_imperial:
                    unit = 1;
                    LengthImperialNumber i_number = LengthImperialNumber.setInchValue(i_value);
                    length_edit.setText(i_number.getNumber_ft_value() +" ft "   + i_number.get_in_addDecimal_value() + " inch");
                    break;
                case  R.id.rb_metric:
                    unit = 0;
                    LengthMetricNumber m_number = LengthMetricNumber.setCMValue(m_value);
                    length_edit.setText(m_number.getAll_cm_value() + " cm");
                    break;
            }
        });
//        double test = 133.6;
//        LengthMetricNumber lengthMetricNumber = LengthMetricNumber.setCMValue(test);
//        LengthImperialNumber l_v = LengthImperialNumber.setValue(test);
//        Log.e("test", "d:" + lengthMetricNumber.getNumber_hundred_value());
//        Log.e("test", "ten:" + lengthMetricNumber.getNumber_ten_value());
//        Log.e("test", "one:" + lengthMetricNumber.getNumber_one_value());
//        Log.e("test", "decimal:" + lengthMetricNumber.getNumber_decimal_value());
        tv_show = findViewById(R.id.tv_show);

        length_edit = findViewById(R.id.length_edit);
        length_edit.setInputType(InputType.TYPE_NULL);
        length_edit.setFocusable(false);
        length_edit.setOnClickListener( v -> {
            if (unit == 0){
                new PickerMetricDialogFragment()
                        .setValue(m_value)
                        .setOnValueChangedListener( (view , i_value , m_value) -> {
                            this.i_value = i_value;
                            this.m_value = m_value;
                            LengthMetricNumber m_number = LengthMetricNumber.setCMValue(m_value);
                            length_edit.setText(m_number.getAll_cm_value()+ " cm");
                        }).setOnOKClickListener((view, i_value, m_value) -> {
                            this.i_value = i_value;
                            this.m_value = m_value;
                            LengthMetricNumber m_number = LengthMetricNumber.setCMValue(m_value);
                            length_edit.setText(m_number.getAll_cm_value()+ " cm"); })
                        .show(getSupportFragmentManager(),PickerMetricDialogFragment.TAG);
            }else {
                new PickerImperialDialogFragment()
                        .setValue(i_value)
                        .setOnValueChangedListener( (view , i_value , m_value) -> {
                            this.i_value = i_value;
                            this.m_value = m_value;
                            LengthImperialNumber i_number = LengthImperialNumber.setInchValue(i_value);
                            length_edit.setText(i_number.getNumber_ft_value() +" ft "   + i_number.get_in_addDecimal_value()+ " inch"); })
                        .setOnOKClickListener((view, i_value, m_value) -> {
                            this.i_value = i_value;
                            this.m_value = m_value;
                            LengthImperialNumber i_number = LengthImperialNumber.setInchValue(i_value);
                            length_edit.setText(i_number.getNumber_ft_value() +" ft "   + i_number.get_in_addDecimal_value() + " inch"); })
                        .show(getSupportFragmentManager(),PickerImperialDialogFragment.TAG);
            }
        });
    }


}