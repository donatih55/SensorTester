package com.henriquedonati.sensortester;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class MainScreen extends Activity {

    private SensorClass sens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        sens = new SensorClass(this.getApplicationContext(), (TextView) findViewById(R.id.ValueU), (TextView) findViewById(R.id.ValueR), (TextView) findViewById(R.id.ValueD), (TextView) findViewById(R.id.ValueL));
    }

    @Override
    protected void onResume() {
        super.onResume();
        sens.register();
    }

    @Override
    protected void onPause() {
        super.onPause();
        sens.unregister();
    }

}
