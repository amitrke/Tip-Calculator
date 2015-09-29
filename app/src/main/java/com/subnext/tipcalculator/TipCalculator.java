package com.subnext.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tip_calculator, menu);
        return true;
    }

    public void calculate(View view){
        TextView textViewResult = (TextView) findViewById(R.id.textView3);
        try {
            EditText editTextBill = (EditText) findViewById(R.id.editText);
            float billAmount = Float.parseFloat(editTextBill.getText().toString());
            EditText editTextPercent = (EditText) findViewById(R.id.editText2);
            float tipPercent = Float.parseFloat(editTextPercent.getText().toString());
            float tipAmount = Math.round((billAmount * tipPercent / 100)*100)/100;
            float totalAmount =  Math.round((tipAmount + billAmount)*100)/100;
            textViewResult.setText("Tip: "+tipAmount+", Total:"+totalAmount);
        }
        catch (Exception e){
            textViewResult.setText("Error : Please enter the Bill amount and percentage correctly.");
        }
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
