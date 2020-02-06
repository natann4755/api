package com.example.frame2;

import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class conterAsyincTasc extends AsyncTask <Integer,Integer,String> {
   private WeakReference <AcyncMain> acync_mainWeakReference;

    public conterAsyincTasc(AcyncMain myacync_main) {
        acync_mainWeakReference = new WeakReference<AcyncMain>(myacync_main);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        AcyncMain acync = acync_mainWeakReference.get();
        if (acync == null || acync.isFinishing()){
            return;
        }

        acync.myTextView.setVisibility(View.VISIBLE);
        acync.myTextView.setText("counter start");
    }

    @Override
    protected String doInBackground(Integer... integers) {

         for (int i = integers[0]; i >=0 ; i--) {
                if (isCancelled()){
                    break;
                }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
             publishProgress(i);
        }
        return "Done";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {

        AcyncMain acync = acync_mainWeakReference.get();
        if (acync==null || acync.isFinishing()){
            return;
        }
        acync.myTextView.setText(String.valueOf(values[0]));
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        AcyncMain acync = acync_mainWeakReference.get();
        if (acync == null || acync.isFinishing()){
            return;
        }

        Toast.makeText(acync,s,Toast.LENGTH_SHORT).show();
        acync.myTextView.setText(s);

//        acync.myTextView.setText("this is acync main");
//
//        acync.myTextView.setVisibility(View.GONE);
    }
}
