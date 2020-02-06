package com.example.frame2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Thread_main extends AppCompatActivity implements View.OnClickListener {

    public TextView myTextView;
    private Button b1;
    private Button b2;
    private Button b3;
    private Handler myHandler;
    private int ii;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        myHandler = new Handler(Looper.getMainLooper());

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
                myTextView.setText("this is thread main");
                break;
            case R.id.botton2_start:
                myTextView.setText("counter start");
                Thread myThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 10; i >=0 ; i--) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            ii=i;
                            myHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    myTextView.setText(String.valueOf(ii));
                                }
                            });
                        }
                    }
                });
                Toast.makeText(this,"done",Toast.LENGTH_SHORT).show();
                myTextView.setText("done");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myTextView.setVisibility(View.GONE);
                myTextView.setText("this is thread main");
            case R.id.botton3_creat:
//                myacyn.cancel(true);
//                myTextView.setText("cansel");
//                break;
            default:
        }

    }
}
