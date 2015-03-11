package com.learning.vitaliylakusta.learnmixer1_phone;

import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private Spinner subjectSpinner;
    private Spinner licenseSpinner;
    private Spinner tagSpinner1;
    private ArrayAdapter<String> tagAdapter;
    private String[] subjects = {"Choose subject", "Lanugage and Literature", "Foreign Languages", "Mathematics",
        "Natural Sciences", "Physics" };
    private String[] licenses = { "All rights reserved", "Attribution alone", "Attribution + NoDerivatives",
        "Attribution + ShareAlike", "Attribution + Noncommercial", "Attribution + Noncommercial + NoDerivatives", };
    private String[] tags = { "tag1", "tag2", "tag3", "tag4" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set up spinner for subjects
        subjectSpinner = (Spinner) findViewById(R.id.spinnerSubject);
        ArrayAdapter<String> subjectAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, subjects);
        subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subjectSpinner.setAdapter(subjectAdapter);

        // set up spinner for licenses
        licenseSpinner = (Spinner) findViewById(R.id.spinnerLicense);
        ArrayAdapter<String> licenseAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, licenses);
        licenseAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        licenseSpinner.setAdapter(licenseAdapter);

        // set up spinners for tags
        tagSpinner1 = (Spinner) findViewById(R.id.spinnerTag1);
        tagAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, tags);
        tagAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tagSpinner1.setAdapter(tagAdapter);

//        RelativeLayout rl = (RelativeLayout) findViewById(R.id.mainLayout);
//        Spinner[] spinners = new Spinner[3];
//        for (int i = 0; i < 3; i++) {
//            spinners[i] = new Spinner(getApplicationContext());
//            spinners[i].setLayoutParams(new Spinner.LayoutParams(Spinner.LayoutParams.WRAP_CONTENT,
//                    Spinner.LayoutParams.WRAP_CONTENT));
//            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) spinners[i].getLayoutParams();
//            params.addRule(RelativeLayout.ABOVE, R.id.textTagTitle);
//            spinners[i].setLayoutParams(params);
//
//            spinners[i].setAdapter(tagAdapter);
//            rl.addView(spinners[i]);
//        }

        // set up range bar for age group
        RangeSeekBar<Integer> seekBar = new RangeSeekBar<Integer>(0, 90, getApplicationContext());
        TextView rangeGroupText = (TextView) findViewById(R.id.rangeGroupText);
        rangeGroupText.setText("Age group: " + seekBar.getSelectedMinValue() + "-" + seekBar.getSelectedMaxValue());
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

    public void onClickAddTag(View view) {
        LinearLayout ll = (LinearLayout) findViewById(R.id.linearLayout);
        Spinner spinner = new Spinner(getApplicationContext());
        spinner.setLayoutParams(tagSpinner1.getLayoutParams());
        spinner.setAdapter(tagAdapter);
        spinner.setPopupBackgroundDrawable(tagSpinner1.getPopupBackground());

        ll.addView(spinner, ll.getChildCount() - 1);
    }

    public void onClickWatchVideo(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=9XFeW9dgyIs&list=UUAuUUnT6oDeKwE6v1NGQxug")));
    }
}
