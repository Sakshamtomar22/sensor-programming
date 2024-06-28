package com.example.sensor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    TextView ax, ay, az, gx, gy, gz, mx, my, mz;
    Sensor ac;
    Sensor gyr;
    Sensor meg;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ax = findViewById(R.id.ax);
        ay = findViewById(R.id.ay);
        az = findViewById(R.id.az);
        gx = findViewById(R.id.gx);
        gy = findViewById(R.id.gy);
        gz = findViewById(R.id.gz);
        mx = findViewById(R.id.mx);
        my = findViewById(R.id.my);
        mz = findViewById(R.id.mz);

        SensorManager sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        ac = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (ac != null) {
            sm.registerListener((SensorEventListener) MainActivity.this, ac, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            ax.setText("Accelerometer is not supported");
            ay.setText("Accelerometer is not supported");
            az.setText("Accelerometer is not supported");

        }
        gyr = sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        if (gyr != null) {
            sm.registerListener((SensorEventListener) MainActivity.this, gyr, SensorManager.SENSOR_DELAY_NORMAL);

        } else {
            gx.setText("Gyroscope is not supported");
            gy.setText("Gyroscope is not supported");
            gz.setText("Gyroscope is not supported");
        }
        meg = sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        if (meg != null) {
            sm.registerListener((SensorEventListener) MainActivity.this, meg, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            mx.setText("Magnetometer is not supported");
            my.setText("Magnetometer is not supported");
            mz.setText("Magnetometer is not supported");
        }


    }


}











