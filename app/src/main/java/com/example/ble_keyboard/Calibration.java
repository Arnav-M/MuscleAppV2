package com.example.ble_keyboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.number.LocalizedNumberRangeFormatter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Calibration extends AppCompatActivity {

    private int [] values = {100, 100, 100, 100, 100, 100, 110, 200, 300, 110, 200, 300, 110, 200, 300, 110, 200, 300};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calibration);
        nextPage();
    }
    // Pseudo code for reading the array and then allowing the user to go to next page
    private void nextPage() {
        Button btn = (Button)findViewById(R.id.Next);
        for(int i = 0; i < values.length; i+=3) {
            if((values[i] + values[i + 1] + values[i + 2])/3 > 100) {
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(Calibration.this, Muscle.class));
                    }
                });
                Toast.makeText(Calibration.this, "Calibrated.", Toast.LENGTH_LONG).show();
            }
            else {
                btn = null;
            }
        }
    }

    public int[] getValues() {
        return values;
    }

    public void setValues() {
        this.values = values;
    }
}