package com.example.frame2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class mooveyVeiwAdapter extends RecyclerView.Adapter <mooveyVeiwAdapter.VeiwHolder> {


    private OnMooveiClickLisener MyonMooveiClickLisener;
    private LayoutInflater inflater;
    private ArrayList<Result> mydata = new ArrayList<>();

    @NonNull
    @Override
    public VeiwHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.itemmoovi,parent,false);
        return new VeiwHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VeiwHolder holder, int position) {
        holder.onbindSet(mydata.get(position));


    }

    @Override
    public int getItemCount() {
        return mydata.size();
    }



    public mooveyVeiwAdapter (Context context, OnMooveiClickLisener lisiner,  ArrayList<Result> data){
        MyonMooveiClickLisener = lisiner;
        mydata=data;
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    public class VeiwHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView imeg;
        public TextView titel;
        public TextView text;

        public VeiwHolder(@NonNull View view) {
            super(view);
            view.setOnClickListener(this);


            imeg = view.findViewById(R.id.ImageView);
            titel = view.findViewById(R.id.TextViewTitel);
            text = view.findViewById(R.id.TextViewText);
        }

        public void onbindSet (Result moovei){
//            imeg.setImageResource(moovei.getImeg());
            titel.setText(moovei.getTitle());
            text.setText(moovei.getOverview());
        }


        @Override
        public void onClick(View v) {
            if (MyonMooveiClickLisener == null) return;
            MyonMooveiClickLisener.OnMooveiClicedb(getAdapterPosition());

        }
    }
}
