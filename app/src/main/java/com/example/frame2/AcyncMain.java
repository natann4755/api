package com.example.frame2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AcyncMain extends AppCompatActivity implements View.OnClickListener {

    public TextView myTextView;
    private Button b1;
    private Button b2;
    private Button b3;
    private conterAsyincTasc myacyn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acync);

        myTextView =findViewById(R.id.acM_textveiw);
        b1 = findViewById(R.id.botton1_creat);
        b2 = findViewById(R.id.botton2_start);
        b3 = findViewById(R.id.botton3_creat);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.botton1_creat:
                myTextView.setVisibility(View.VISIBLE);
                myTextView.setText("this is acync main");
                break;
            case R.id.botton2_start:
                myacyn = new conterAsyincTasc(this);
                myacyn.execute(15);
                break;
            case R.id.botton3_creat:
                myacyn.cancel(true);
                myTextView.setText("cansel");
                break;
            default:
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myacyn.cancel(true);
    }
}
