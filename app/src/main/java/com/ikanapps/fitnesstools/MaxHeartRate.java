package com.ikanapps.fitnesstools;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MaxHeartRate extends ActionBarActivity {
    private Button btnCalculate;
    private TextView lblResult;
    private EditText txtAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_max_heart_rate);

        setCalculateOnClick();
    }

    private void setCalculateOnClick(){
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        txtAge = (EditText) findViewById(R.id.txtAge);
        lblResult = (TextView) findViewById(R.id.lblResult);

        btnCalculate.setOnClickListener(new View.OnClickListener(){
            @Override
        public void onClick(View v){
                Integer maxRate;
                maxRate = 220 - Integer.valueOf(txtAge.getText().toString());
                lblResult.setText(R.string.mhrResult + String.valueOf(maxRate));
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_max_heart_rate, menu);
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
