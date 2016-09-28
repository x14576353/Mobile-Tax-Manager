package com.example.omnissiah.minimanager;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Income extends Activity implements View.OnClickListener {
    private Button calcBtn;
    private TextView stockLbl,wageLbl,incomeLbl;
    private EditText stockTotal,wageTotal,incomeTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_calculator);
        init();


        Intent i = getIntent();
        String wage = i.getStringExtra("totalw");
        wageTotal.setText(wage);
        String stock = i.getStringExtra("totals");
        stockTotal.setText(stock);


    }

    private void init(){
        calcBtn = (Button)findViewById(R.id.calcBtn);
        stockLbl = (TextView)findViewById(R.id.stockLbl);
        wageLbl = (TextView)findViewById(R.id.wageLbl);
        incomeLbl = (TextView)findViewById(R.id.incomeLbl);
        stockTotal = (EditText)findViewById(R.id.stockTotal);
        wageTotal = (EditText)findViewById(R.id.wageTotal);
        incomeTotal = (EditText)findViewById(R.id.incomeTotal);

        calcBtn.setOnClickListener(this);
    }

    public JSONArray createJSON(){
        JSONArray incomeArray = new JSONArray();
        JSONObject incomeObject = new JSONObject();
        try{
            incomeObject.put("Total", incomeTotal.getText().toString());

            incomeArray.put(incomeObject);
        }
        catch (JSONException e) {
            System.out.println("Error:" + e);
        }

        return incomeArray;
    }



    @Override
    public void onClick(View v) {
        String total1 = stockTotal.getText().toString();
        String total2 = wageTotal.getText().toString();
        switch(v.getId()){
            case R.id.calcBtn:
                double gross = Double.parseDouble(total1) - Double.parseDouble(total2);
                double tax = gross * 0.125;
                double total = gross - tax;
                incomeTotal.setText(String.valueOf(total));
                createJSON();
                break;
        }
    }
}
