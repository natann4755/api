package com.example.frame2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragment2 extends Fragment {

    private static final String moovei_bandel_string = "moovei string";
    private Result data;
    private Button bbb;

    private ImageView imageView1;
    private ImageView imageView2;
    private TextView titel;
    private TextView ttext;


    public static fragment2 newIntent (Result data){
        fragment2 f2 = new fragment2();
        Bundle bundle = new Bundle();
        bundle.putParcelable(moovei_bandel_string,data);
        f2.setArguments(bundle);
        return f2;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data = getArguments().getParcelable(moovei_bandel_string);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vveiw = inflater.inflate(R.layout.farm2, container, false);
        initveiw(vveiw);
        if (data != null){
            setdata(vveiw);
        }
        return vveiw;
    }

    private void initveiw(View vveiw) {
        imageView1 = vveiw.findViewById(R.id.imeg1);
        imageView2 = vveiw.findViewById(R.id.imeg2);
        titel = vveiw.findViewById(R.id.titel);
        ttext = vveiw.findViewById(R.id.textt);
        bbb = vveiw.findViewById(R.id.f2_butun);

    }

    private void setdata(View vveiw) {
//        imageView1.setImageResource(data.getImeg());
//        imageView2.setImageResource(data.getImeg());
        titel.setText(data.getTitle());
        ttext.setText(data.getOverview());

//        bbb.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(data.getUrl()));
//                startActivity(intent);
//            }
//        });
    }


}
