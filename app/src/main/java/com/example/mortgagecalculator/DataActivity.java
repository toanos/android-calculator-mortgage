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
        updateView();
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

        EditText amountEditText = (EditText) findViewById(R.id.data_amount);
        amountEditText.setText("" + mortgage.getAmount());
        EditText rateEditText = (EditText) findViewById(R.id.data_rate);
        rateEditText.setText("" + mortgage.getRate());
    }

    public void updateMortgageObject() {
        Mortgage mortgage = MainActivity.mortgage;
        RadioButton radioButton10 = (RadioButton) findViewById(R.id.ten);
        RadioButton radioButton15 = (RadioButton) findViewById(R.id.fifteen);
        int years = 30;
        if (radioButton10.isChecked()) {
            years = 10;
        } else if (radioButton15.isChecked()) {
            years = 15;
        }
        mortgage.setYears(years);
        EditText amountEditText = (EditText) findViewById(R.id.data_amount);
        String amountString = amountEditText.getText().toString();
        EditText rateEditText = (EditText) findViewById(R.id.data_rate);
        String rateString = rateEditText.getText().toString();
        try {
            float amount = Float.parseFloat(amountString);
            mortgage.setAmount(amount);
            float rate = Float.parseFloat(rateString);
            mortgage.setRate(rate);
            mortgage.setPreferences(this);
        } catch (NumberFormatException nfe) {
            mortgage.setAmount(100000.00f);
            mortgage.setRate(.035f);
        }
    }

    public void goBack(View V){
        updateMortgageObject();
        this.finish();
        overridePendingTransition(R.anim.fade_in_and_scale, 0);
    }

}
