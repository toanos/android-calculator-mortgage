package com.example.mortgagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button modifyDataButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        modifyDataButton = findViewById(R.id.modify_data);
    }

    public void modifyData(View v) {
        Intent myIntent = new Intent(this, DataActivity.class);
        this.startActivity(myIntent);

    }
}