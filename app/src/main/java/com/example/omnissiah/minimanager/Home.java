package com.example.omnissiah.minimanager;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class Home extends Activity {


    private Button EmployeeList_Btn,Income_Btn,Stock_Btn,Wage_Btn,Calendar_Btn;



    public void Income(View view){
        Intent startNewActivity = new Intent(this,Income.class);
        startActivity(startNewActivity);
    }




    public void Wage(View view){
        Intent startNewActivity = new Intent(this,Wage.class);
        startActivity(startNewActivity);
    }

    public void CalendarActivity(View view){
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setType("vnd.android.cursor.item/event");

        Calendar cal = Calendar.getInstance();
        long startTime = cal.getTimeInMillis();
        long endTime = cal.getTimeInMillis()  + 60 * 60 * 1000;

        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startTime);
        intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime);
        intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);

        intent.putExtra(CalendarContract.Events.TITLE,"Birthday");
        intent.putExtra(CalendarContract.Events.DESCRIPTION, "Sample desc.");
        intent.putExtra(CalendarContract.Events.EVENT_LOCATION, "My Guest House");
        intent.putExtra(CalendarContract.Events.RRULE, "FREQ=YEARLY");

        startActivity(intent);
    }

    public void Stock(View view){
        Intent startNewActivity = new Intent(this,Stock.class);
        startActivity(startNewActivity);
    }

    public void LoginActivity(View view){
        Intent startNewActivity = new Intent(this,LoginActivity.class);
        startActivity(startNewActivity);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

}
