package com.example.taruc.loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView textMpayment;
    private TextView textStatus;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textMpayment = (TextView) findViewById(R.id.textView);
        textStatus = (TextView) findViewById(R.id.textView2);

        Intent intent = getIntent();//Asking wh0 call me
        double payment = intent.getDoubleExtra(MainActivity.MONTHLY_PAYMENT,0);
        String status= intent.getStringExtra(MainActivity.LOAN_STATUS);

        textMpayment.setText(payment+"");
        textStatus.setText(status);
    }

    public void closeActivity(View view)
    {
        finish();
    }
}
