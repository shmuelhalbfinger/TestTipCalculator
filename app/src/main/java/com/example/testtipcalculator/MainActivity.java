package com.example.testtipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText checkAmountValue;
    EditText partySizeValue;
    Button buttonCompute;
    TextView fifteenPercentTipValue;
    TextView twentyPercentTipValue;
    TextView twentyfivePercentTipValue;
    TextView fifteenPercentTotalValue;
    TextView twentyPercentTotalValue;
    TextView twentyfivePercentTotalValue;

    Double checkAmount;
    Integer partySize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize our view objects
        this.checkAmountValue = (EditText) findViewById(R.id.checkAmountValue);
        this.partySizeValue = (EditText) findViewById(R.id.partySizeValue);
        this.buttonCompute = (Button) findViewById(R.id.buttonCompute);
        this.fifteenPercentTipValue = (TextView) findViewById(R.id.fifteenPercentTipValue);
        this.twentyPercentTipValue = (TextView) findViewById(R.id.twentyPercentTipValue);
        this.twentyfivePercentTipValue = (TextView) findViewById(R.id.twentyfivePercentTipValue);
        this.fifteenPercentTotalValue = (TextView) findViewById(R.id.fifteenPercentTotalValue);
        this.twentyPercentTotalValue = (TextView) findViewById(R.id.twentyPercentTotalValue);
        this.twentyfivePercentTotalValue = (TextView) findViewById(R.id.twentyfivePercentTotalValue);

        //allows our button to be clickable
        buttonCompute.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        //if any of the fields are empty, display a toast message
        if (checkAmountValue.getText().toString().isEmpty() ||
                partySizeValue.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Empty or Incorrect Value(s)!", Toast.LENGTH_SHORT).show();
            return;
        }

        this.checkAmount = Double.parseDouble(checkAmountValue.getText().toString());
        this.partySize = Integer.parseInt(partySizeValue.getText().toString());

        fifteenPercentTipValue.setText((int) Math.round((checkAmount * 0.15) / partySize));
        twentyPercentTipValue.setText((int) Math.round((checkAmount * 0.20) / partySize));
        twentyfivePercentTipValue.setText((int) Math.round((checkAmount * 0.25) / partySize));

        fifteenPercentTotalValue.setText((int) Math.round((checkAmount * 1.15) / partySize));
        twentyPercentTotalValue.setText((int) Math.round((checkAmount * 1.20) / partySize));
        twentyfivePercentTotalValue.setText((int) Math.round((checkAmount * 1.25) / partySize));
    }
}