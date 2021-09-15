package com.example.mortgagecalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class DataActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
    }

    public void onStart() {
        super.onStart();
        updateView();
    }

    public void updateView( ) {
        Mortgage mortgage = MainActivity.mortgage;
        if( mortgage.getYears( ) == 10 ) {
            RadioButton rb10 = ( RadioButton ) findViewById( R.id.ten );
            rb10.setChecked( true );
        } else if ( mortgage.getYears( ) == 15 ) {
            RadioButton rb15 = ( RadioButton ) findViewById( R.id.fifteen );
            rb15.setChecked( true );
        } // else do nothing (default is 30)

        EditText amountET = ( EditText ) findViewById( R.id.data_amount );
        amountET.setText( "" + mortgage.getAmount( ) );
        EditText interestET = ( EditText ) findViewById( R.id.data_rate );
        interestET.setText( "" + mortgage.getRate( ) );
    }

    public void updateMortgageObject( ) {
        Mortgage mortgage = MainActivity.mortgage;
        // update years
        RadioButton rb10 = ( RadioButton ) findViewById( R.id.ten );
        RadioButton rb15 = ( RadioButton ) findViewById( R.id.fifteen );
        int years = 30; // default
        if( rb10.isChecked( ) )
            years = 10;
        else if ( rb15.isChecked( ) )
        {
            years = 15;
        }
        mortgage.setYears( years );
        // update amount and rate
        EditText amountET = ( EditText ) findViewById( R.id.data_amount );
        String amountString = amountET.getText( ).toString( );
        EditText interestET = ( EditText ) findViewById( R.id.data_rate );
        String interestString = interestET.getText().toString( );
        try {
            float amount = Float.parseFloat( amountString );
            mortgage.setAmount( amount );
            float interest = Float.parseFloat( interestString );
            mortgage.setRate( interest );
        } catch( NumberFormatException nfe ) {
            // If error set default rates and amounts
            mortgage.setAmount( 100000.0f );
            mortgage.setRate( .035f );
        }
    }




    public void goBack(View v) {
        this.updateMortgageObject();
        this.finish();
    }
}
