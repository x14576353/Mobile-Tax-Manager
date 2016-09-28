package com.example.omnissiah.minimanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Wage extends AppCompatActivity implements View.OnClickListener{
    private Button btn, btn1;
    private TextView lb1,lb2,lb3,lb4;
    private EditText editWR,editHours,editOHours;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wage__calculator);
        init();
    }

    private void init(){

        btn = (Button)findViewById(R.id.btn);
        btn1 = (Button)findViewById(R.id.btn1);
        lb1 = (TextView)findViewById(R.id.lb1);
        lb2 = (TextView)findViewById(R.id.lb2);
        lb3 = (TextView)findViewById(R.id.lb3);
        lb4 = (TextView)findViewById(R.id.lb4);


        editWR = (EditText)findViewById(R.id.editWR);
        editHours = (EditText)findViewById(R.id.editHours);
        editOHours = (EditText)findViewById(R.id.editOHours);

        btn.setOnClickListener(this);

    }


    public void Home(View view){
        String Total1 = lb1.getText().toString();
        Intent i = new Intent(getApplicationContext(),Stock.class);
        i.putExtra("total",Total1);
        startActivity(i);



    }

    public  JSONArray makeJSON(){
            JSONArray wageArr = new JSONArray();
            JSONObject wageObj = new JSONObject();
            try{

                wageObj.put("hours", editHours.getText().toString());
                wageObj.put("rate", editWR.getText().toString());
                wageObj.put("over time hours", editOHours.getText().toString());

                wageArr.put(wageObj);
            }
       catch (JSONException e) {
                System.out.println("Error:" + e);
            }

        return wageArr;
    }





    @Override
    public void onClick(View v){

        String Total2 = editWR.getText().toString();
        String Total3 = editHours.getText().toString();
        String Total4 = editOHours.getText().toString();
            switch (v.getId()){
                case R.id.btn:
                double wage = Integer.parseInt(Total2) * Integer.parseInt(Total3);
                double over = (Integer.parseInt(Total2) * Integer.parseInt(Total4)) * 1.5;
                double total = wage + over;
                    lb1.setText(String.valueOf(total));
                    makeJSON();
                    break;

                case R.id.btn1:
                    startActivity(new Intent(this, Income.class));
                    break;









            }

    }
}