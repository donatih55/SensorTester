package com.henriquedonati.sensortester;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SensorClass  implements SensorEventListener {

    private SensorManager sensorManager;
    private List<Sensor> sensors;
    private List<TextView> values;

    public SensorClass(Context context, TextView U, TextView R, TextView D, TextView L){
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        sensors = sensorManager.getSensorList(-1);
        values = new ArrayList<TextView>();
        values.add(U);
        values.add(R);
        values.add(D);
        values.add(L);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        values.get(0).setText(""+event.values[0]);
        /*values.get(1).setText(""+event.values[1]);
        values.get(2).setText(""+event.values[2]);
        values.get(3).setText(""+event.values[3]);*/
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void register(){
        for (int i = 0; i < sensors.size(); i++) {
            sensorManager.registerListener(this, sensors.get(i), sensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    public void unregister(){
        sensorManager.unregisterListener(this);
    }
}
