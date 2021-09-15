package com.example.mortgagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static Mortgage mortgage;
    private Button modifyDataButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mortgage = new Mortgage();
        setContentView(R.layout.activity_main);

        modifyDataButton = findViewById(R.id.modify_data);
    }
    public void onStart() {
        super.onStart();
        updateView();
    }

    public void updateView() {
        TextView amountTV = (TextView) findViewById(R.id.amount);
        amountTV.setText( mortgage.getFormattedAmount() );
        TextView yearsTV = ( TextView ) findViewById( R.id.years );
        yearsTV.setText("" + mortgage.getYears() );
        TextView interestTV = (TextView) findViewById(R.id.rate );
        interestTV.setText("" + (mortgage.getRate() * 100) + "%" );
    }

    public void modifyData(View v) {
        Intent myIntent = new Intent(this, DataActivity.class);
        this.startActivity(myIntent);

    }
}