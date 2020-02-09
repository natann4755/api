package com.example.frame2;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class mooveiFragment extends Fragment implements OnMooveiClickLisener {

    public OnMovieFragmentClickListener myonMovieFragmentClickListener ;

    private RecyclerView myRecyclerView;
    private RecyclerView.LayoutManager mylayoutManager;
    private RecyclerView.Adapter myAdapter;
    static final String key = "key";
    private ArrayList <Result> myresults = new ArrayList<>();

    static mooveiFragment newInstant (ArrayList<Result> mylist){
        mooveiFragment myMooveiFragment = new mooveiFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(key,mylist);
        myMooveiFragment.setArguments(bundle);
        return myMooveiFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnMovieFragmentClickListener){
            myonMovieFragmentClickListener = (OnMovieFragmentClickListener) context;
        }else {
            throw new RuntimeException(context.toString() + "must by implements OnMovieFragmentClickListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        myonMovieFragmentClickListener = null;
    }



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vveiw = inflater.inflate(R.layout.ferm1,container,false);
        myresults = getArguments().getParcelableArrayList(key);
        myRecyclerView = vveiw.findViewById(R.id.FM_rv);

        intimyRecyclerView();


        return vveiw;
    }

    private void intimyRecyclerView() {
        if (getContext() != null) {
            mylayoutManager = new LinearLayoutManager(getContext());
            myRecyclerView.setLayoutManager(mylayoutManager);
            myAdapter = new mooveyVeiwAdapter(getContext(), this, myresults);
            myRecyclerView.setAdapter(myAdapter);
        }
    }

    @Override
    public void OnMooveiClicedb(int ItemPositiom) {
        if (myonMovieFragmentClickListener != null) {
            myonMovieFragmentClickListener.OnMooveiClicked((myresults.get(ItemPositiom)),ItemPositiom);
        }
    }
}
