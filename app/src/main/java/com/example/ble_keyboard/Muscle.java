package com.example.ble_keyboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.number.LocalizedNumberRangeFormatter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Muscle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muscle);
        int [] values = {100, 100, 100, 100, 100, 100, 110, 200, 300, 110, 200, 300, 110, 200, 300, 110, 200, 300};


        Button recalibrate = (Button)findViewById(R.id.Recalibrate);
        recalibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Muscle.this, Calibration.class));
            }
        });
        TextView bicep = findViewById(R.id.Bicep);
        TextView triceps = findViewById(R.id.Tricep);
        TextView forearm = findViewById(R.id.Forearm);
        for(int i = 0; i < values.length - 4; i+=3) {
            bicep.setText(values[i]);
            triceps.setText(values[i+1]);
            forearm.setText(values[i+2]);
        }
    }
}