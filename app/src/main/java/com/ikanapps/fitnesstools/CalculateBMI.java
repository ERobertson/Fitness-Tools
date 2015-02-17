package com.ikanapps.fitnesstools;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class CalculateBMI extends ActionBarActivity {
    private Button btnCalculate;
    private EditText txtFeet;
    private EditText txtInches;
    private EditText txtWeight;
    private TextView lblResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_bmi);
        setCalculateOnClick();
    }

    private void setCalculateOnClick() {
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float bmi;
                float inches;
                float weight;
                txtInches = (EditText) findViewById(R.id.txtInches);
                txtFeet = (EditText) findViewById(R.id.txtFeet);
                txtWeight = (EditText) findViewById(R.id.txtWeight);
                lblResult = (TextView) findViewById(R.id.lblResult);

                weight = Float.valueOf(txtWeight.getText().toString());
                inches = Float.valueOf(txtFeet.getText().toString()) * 12 + Float.valueOf(txtInches.getText().toString());
                bmi = (weight / (inches * inches)) * 703;
                lblResult.setText(R.string.bmiResult + String.valueOf(bmi));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculate_bmi, menu);
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
