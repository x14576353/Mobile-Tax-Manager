package com.example.omnissiah.minimanager;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Stock extends AppCompatActivity implements View.OnClickListener{
    //
    private Button Calculate_Btn;
    private TextView tx_StockCalculator,tx_Input01,tx_Input02,tx_Input03,tx_Input04,tv_result, textView2;
    private EditText editText1,editText2,editText3,editText4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);
        init();

        editText1 = (EditText) findViewById(R.id.editText1);
        Intent i = getIntent();
        String total = i.getStringExtra("total");
        textView2.setText(total);



    }

    private void init() {
        Calculate_Btn = (Button) findViewById(R.id.Calculate_Btn);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        tx_StockCalculator = (TextView) findViewById(R.id.tx_StockCalculator);
        tx_Input01 = (TextView) findViewById(R.id.tx_Input01);
        tx_Input02 = (TextView) findViewById(R.id.tx_Input02);
        tx_Input03 = (TextView) findViewById(R.id.tx_Input03);
        tx_Input04 = (TextView) findViewById(R.id.tx_Input04);
        tv_result = (TextView) findViewById(R.id.tv_result);
        textView2 = (TextView) findViewById(R.id.textView2);

        Calculate_Btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String num1 = editText1.getText().toString();
        String num2 = editText2.getText().toString();
        String num3 = editText3.getText().toString();
        String num4 = editText4.getText().toString();

        switch(v.getId()){
            case R.id.Calculate_Btn:
                double result = Integer.parseInt(num1) * 0.235+ Integer.parseInt(num1) * 0.135+ Integer.parseInt(num1) *0.09;
                tv_result.setText(String.valueOf(result));



                String stock = tv_result.getText().toString();
                String wages = textView2.getText().toString();
                Intent i = new Intent(getApplicationContext(),Income.class);
                i.putExtra("totalw",wages);
                i.putExtra("totals",stock );
                startActivity(i);

                break;
        }
    }

}

