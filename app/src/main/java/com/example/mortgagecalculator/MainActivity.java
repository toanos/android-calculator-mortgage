package com.example.mortgagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static Mortgage mortgage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mortgage = new Mortgage();
        setContentView(R.layout.activity_main);
    }

    public void onStart() {
        super.onStart();
        updateView();
    }

    public void updateView() {
        TextView amountTextView = (TextView) findViewById(R.id.amount);
        amountTextView.setText(mortgage.getFormattedAmount());
        TextView yearsTextView = (TextView) findViewById(R.id.years);
        yearsTextView.setText("" + mortgage.getYears());
        TextView rateTextView = (TextView) findViewById(R.id.rate);
        rateTextView.setText("" + mortgage.getRate());
    }

    public void modifyData(View v) {
        Intent activityDataView = new Intent(this, DataActivity.class);
        this.startActivity(activityDataView);
    }

}