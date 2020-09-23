package com.example.testtipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText checkAmountValue;
    EditText partySizeValue;
    Button buttonCompute;
    EditText fifteenPercentTipValue;
    EditText twentyPercentTipValue;
    EditText twentyfivePercentTipValue;
    EditText fifteenPercentTotalValue;
    EditText twentyPercentTotalValue;
    EditText twentyfivePercentTotalValue;

    double checkAmount;
    int partySize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize our view objects
        checkAmountValue = (EditText) findViewById(R.id.checkAmountValue);
        partySizeValue = (EditText) findViewById(R.id.partySizeValue);
        buttonCompute = (Button) findViewById(R.id.buttonCompute);
        fifteenPercentTipValue = (EditText) findViewById(R.id.fifteenPercentTipValue);
        twentyPercentTipValue = (EditText) findViewById(R.id.twentyPercentTipValue);
        twentyfivePercentTipValue = (EditText) findViewById(R.id.twentyfivePercentTipValue);
        fifteenPercentTotalValue = (EditText) findViewById(R.id.fifteenPercentTotalValue);
        twentyPercentTotalValue = (EditText) findViewById(R.id.twentyPercentTotalValue);
        twentyfivePercentTotalValue = (EditText) findViewById(R.id.twentyfivePercentTotalValue);

        //allows our button to be clickable
        buttonCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAmount = Double.parseDouble(checkAmountValue.getText().toString());
                partySize = Integer.parseInt(partySizeValue.getText().toString());

                //if any of the fields are empty, display a toast message
                if (checkAmountValue.getText().toString().isEmpty() ||
                        partySizeValue.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Empty or Incorrect Value(s)!", Toast.LENGTH_SHORT).show();
                }
                else {
                    fifteenPercentTipValue.setText((int) Math.round((checkAmount * 0.15) / partySize));
                    twentyPercentTipValue.setText((int) Math.round((checkAmount * 0.20) / partySize));
                    twentyfivePercentTipValue.setText((int) Math.round((checkAmount * 0.25) / partySize));

                    fifteenPercentTotalValue.setText((int) Math.round((checkAmount * 1.15) / partySize));
                    twentyPercentTotalValue.setText((int) Math.round((checkAmount * 1.20) / partySize));
                    twentyfivePercentTotalValue.setText((int) Math.round((checkAmount * 1.25) / partySize));
                }
            }
        });
    }
}