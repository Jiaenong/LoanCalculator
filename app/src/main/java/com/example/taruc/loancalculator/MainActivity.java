package com.example.taruc.loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.example.taruc.loancalculator.R.string.monthly_payment;
import static com.example.taruc.loancalculator.R.string.status;

public class MainActivity extends AppCompatActivity {

    public static final String MONTHLY_PAYMENT = "payment";
    public static final String LOAN_STATUS = "status";
    private EditText textvPrice;
    private EditText textDownpayment;
    private EditText textRepayment;
    private EditText textInterestRate;
    private EditText textSalary;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textvPrice = (EditText)findViewById(R.id.editTextPrice);
        textDownpayment = (EditText)findViewById(R.id.editTextDPayment);
        textRepayment = (EditText)findViewById(R.id.editTextRpayment);
        textInterestRate = (EditText)findViewById(R.id.editTextRate);
        textSalary = (EditText)findViewById(R.id.editTextSalary);
    }

    public void calculateLoan(View view)
    {
        double totalInterest;
        double tsalary;
        double TotalLoan;
        double mPayment;
        String status;
        double price = Double.parseDouble(textvPrice.getText().toString());
        double dpayment = Double.parseDouble(textDownpayment.getText().toString());
        double rpayment = Double.parseDouble(textRepayment.getText().toString());
        double rate = Double.parseDouble(textInterestRate.getText().toString());
        double salary = Double.parseDouble(textSalary.getText().toString());
        totalInterest = (price - dpayment)*rate*(rpayment/12);
        TotalLoan = (price - dpayment)+totalInterest;
        mPayment = TotalLoan/rpayment;
        tsalary = salary*(30/100);

        if(mPayment > tsalary)
        {
            status = getString(R.string.reject);
        }
        else
            status = getString(R.string.approve);
        //create an Explicit intent
        Intent intent = new Intent(this, ResultActivity.class);
        //TODO: passing data by putExtra method
        intent.putExtra(MONTHLY_PAYMENT, mPayment);
        intent.putExtra(LOAN_STATUS, status);
        startActivity(intent);
    }
}
