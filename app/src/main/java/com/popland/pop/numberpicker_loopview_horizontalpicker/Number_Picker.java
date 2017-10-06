package com.popland.pop.numberpicker_loopview_horizontalpicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;

public class Number_Picker extends AppCompatActivity {
TextView tvShow;
    NumberPicker numberPicker;
    String[] values = {"a","b","c","d","e"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number__picker);
        tvShow = (TextView)findViewById(R.id.TVshow);
        numberPicker = (NumberPicker)findViewById(R.id.numberPicker);
        numberPicker.setMinValue(0);//>=0
        numberPicker.setMaxValue(values.length-1);
        numberPicker.setDisplayedValues(values);
        numberPicker.setWrapSelectorWheel(false);// loop or not
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                tvShow.setText(values[newVal]);
            }
        });
    }
}
