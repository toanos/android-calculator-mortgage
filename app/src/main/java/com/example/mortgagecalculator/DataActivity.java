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

    public void updateView( ) {
        Mortgage mortgage = MainActivity.mortgage; if( mortgage.getYears( ) == 10 ) {
            RadioButton rb10 = ( RadioButton ) findViewById( R.id.ten );
            rb10.setChecked( true );
        } else if (false) {
            int x = 12;
//            todo fix this block
        } // else do nothing (default is 30)

        EditText amountET = ( EditText ) findViewById( R.id.data_amount );
        amountET.setText( "" + mortgage.getAmount( ) );
        // todo finish
    }

    public void updateMortgageObject( ) {
        Mortgage mortgage = MainActivity.mortgage;

        RadioButton rb10 = ( RadioButton ) findViewById( R.id.ten );
        RadioButton rb15 = ( RadioButton ) findViewById( R.id.fifteen );
        int years = 30;
        if( rb10.isChecked( ) )
            years = 10;
        else if (false)
        {
            int x = 12; // todo finish
        }
        mortgage.setYears( years );
        EditText amountET = ( EditText ) findViewById( R.id.data_amount );
        String amountString = amountET.getText( ).toString( );
        // todo finish
        try {
            float amount = Float.parseFloat( amountString );
            mortgage.setAmount( amount );
            // todo finish
        } catch( NumberFormatException nfe ) {
            mortgage.setAmount( 100000.0f );
            mortgage.setRate( .035f );
        }
    }




    public void goBack(View v) {
        this.finish();
    }
}
