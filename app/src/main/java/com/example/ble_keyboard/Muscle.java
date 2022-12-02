package com.example.ble_keyboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
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
            int bpercentage = percentage(values[i], values[i + 1], values[i + 2]);
            int tpercentage = percentage(values[i + 1], values[i], values[i + 2]);
            int fpercentage = percentage(values[i + 2], values[i], values[i + 1]);
            bicep.setText(bpercentage);
            bicep.setTextColor(perc2color(bpercentage));
            triceps.setText(tpercentage);
            triceps.setTextColor(perc2color(tpercentage));
            forearm.setText(fpercentage);
            forearm.setTextColor(perc2color(fpercentage));
        }
    }

    private int percentage(int value1, int value2, int value3) {
        int percentage = (value1/(value1 + value2 + value3)) * 100;
        return percentage;
    }

    private int perc2color(int percentage) {
        if(percentage > 80) {
            // red
            return Color.parseColor("#FFCC0000");
        }
        else if(percentage < 40 && percentage > 20) {
            // light green
            return Color.parseColor("#FF99CC00");
        }
        else if(percentage < 60 && percentage > 40) {
            // light orange
            return Color.parseColor("#FFFFBB33");
        }
        else if(percentage < 80 && percentage > 60) {
            // dark orange
            return Color.parseColor("#FFFF8800");
        }
        else {
            // dark green
            return Color.parseColor("#FF669900");
        }
    }
    // Green, light Green, yellow, orange, red
    // 0-20%, 20%- 40%, 40-60%, 60-80%, 80%-100%
}