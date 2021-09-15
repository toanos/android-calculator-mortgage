package com.example.Lab2;

import android.os.Bundle;
import android.support.app.AppCompatActivity;
import android.view.View;

import com.example.Lab2.R;

public class DataActivity extends AppCompatActivity {
    public void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.activity_data);
    }

    public void goBack(View view) {
        view.finish();
    }
}
