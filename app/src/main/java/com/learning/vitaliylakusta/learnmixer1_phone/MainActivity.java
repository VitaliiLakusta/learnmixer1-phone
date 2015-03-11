package com.learning.vitaliylakusta.learnmixer1_phone;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private Spinner subjectSpinner;
    private String[] subjects = {"Choose subject", "Lanugage and Literature", "Foreign Languages", "Mathematics",
        "Natural Sciences", "Physics" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set up spinner
        subjectSpinner = (Spinner) findViewById(R.id.spinnerSubject);
        ArrayAdapter<String> subjectAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, subjects);

        subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subjectSpinner.setAdapter(subjectAdapter);


        // set up range bar for age group

        RangeSeekBar<Integer> seekBar = new RangeSeekBar<Integer>(0, 90, getApplicationContext());
        seekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
                // handle changed range values
                TextView rangeGroupText = (TextView) findViewById(R.id.rangeGroupText);
                rangeGroupText.setText("Age group: " + minValue + "-" + maxValue);
            }
        });

        ViewGroup layout = (ViewGroup) findViewById(R.id.linearRange);
        layout.addView(seekBar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
