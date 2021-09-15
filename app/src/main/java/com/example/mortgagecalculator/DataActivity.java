package com.example.mortgagecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class DataActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
    }

    public void updateView() {
        Mortgage mortgage = MainActivity.mortgage;
        if (mortgage.getYears() == 10) {
            RadioButton radioButton10 = (RadioButton) findViewById(R.id.ten);
            radioButton10.setChecked(true);
        } else if (mortgage.getYears() == 15) {
            RadioButton radioButton15 = (RadioButton) findViewById(R.id.fifteen);
            radioButton15.setChecked(true);
        } // 30 years is checked by default

//        EditText amountEditText = (EditText) findViewById(R.id.amount);
    }

    public void goBack(View V){
        this.finish();
    }

}
