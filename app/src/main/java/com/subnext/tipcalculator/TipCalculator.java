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
            double billAmount = Double.parseDouble(editTextBill.getText().toString());
            EditText editTextPercent = (EditText) findViewById(R.id.editText2);
            double tipPercent = Double.parseDouble(editTextPercent.getText().toString());
            double tipAmount = billAmount * tipPercent / 100;
            double totalAmount =  tipAmount + billAmount;
            textViewResult.setText("Tip: "+round(tipAmount)+", Total:"+round(totalAmount));
        }
        catch (Exception e){
            textViewResult.setText("Error : Please enter the Bill amount and percentage correctly.");
        }
    }

    private double round(double num){
        return Math.round(num*100.0)/100.0;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        /*int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        */
        return super.onOptionsItemSelected(item);

    }
}
