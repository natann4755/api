package com.example.frame2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements OnMovieFragmentClickListener {

    private ViewPager tabletframeLayout = null;
    private Toolbar mytoolbar;
    private static final String keyMoovey = "566b08e0f0f5d9d9ba6089a67537433c";
    private List<Result> mylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mytoolbar = findViewById(R.id.toolbar);

        loadMoveis();

        setSupportActionBar(mytoolbar);
        mytoolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId()== R.id.menu_async)
                {
                    Log.e("menu_async","menu_async");
                    Intent intent = new Intent(getApplicationContext(), AcyncMain.class);
                    startActivity(intent);
                }
                else if(item.getItemId()== R.id.menu_threads)
                {
                    Log.e("menu_threads","menu_threads");
                    Intent intent = new Intent(MainActivity.this, Thread_main.class);
                    startActivity(intent);
                }
                return false;
            }
        });

        if (savedInstanceState == null) {
            mooveiFragment mymooveiFragment = mooveiFragment.newInstant((ArrayList<Result>) mylist);
            getSupportFragmentManager().beginTransaction().add(R.id.AM_FrameLayout, mymooveiFragment).commit();
        }
        tabletframeLayout = findViewById(R.id.AM_F2_ViewPager);
        if (tabletframeLayout != null) {
            simpelPageAdapter mysimpelPageAdapter = new simpelPageAdapter(getSupportFragmentManager(), fragmentList());
            tabletframeLayout.setAdapter(mysimpelPageAdapter);
        }
    }

    private List<Fragment> fragmentList() {
        List<Fragment> myFragment = new ArrayList<Fragment>();
        for (int i = 0; i < mylist.size(); i++) {
            myFragment.add(fragment2.newIntent(mylist.get(i)));
        }
        return myFragment;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);


        return true;
    }


//    static ArrayList arryListMooveis() {
//        ArrayList<datamoovei> arr = new ArrayList<datamoovei>();
//        arr.add(new datamoovei("cars", "1", R.drawable.cars, "https://www.youtube.com/watch?v=UND7XDWgLF0"));
//        arr.add(new datamoovei("code", "2", R.drawable.code_8, "https://www.youtube.com/watch?v=DqO90q0WZ0M"));
//        arr.add(new datamoovei("forzon", "3", R.drawable.frozen_2, "https://www.youtube.com/watch?v=bwzLiQZDw2I"));
//        arr.add(new datamoovei("interstellar", "4", R.drawable.interstellar, "https://www.youtube.com/watch?v=UDVtMYqUAyw"));
//        arr.add(new datamoovei("jurassic_world", "5", R.drawable.jurassic_world, "https://www.youtube.com/watch?v=vJ0BB9nRS_I&t=1827s"));
//
//        arr.add(new datamoovei("rabbi_jacob", "6", R.drawable.rabbi_jacob, "https://www.youtube.com/watch?v=dFZHMHjdB8w"));
//        arr.add(new datamoovei("rick_and_morty", "7", R.drawable.rick_and_morty, "https://www.youtube.com/watch?v=dFZHMHjdB8w"));
//        arr.add(new datamoovei("spider_man", "8", R.drawable.spider_man, "https://www.youtube.com/watch?v=dFZHMHjdB8w"));
//        arr.add(new datamoovei("the_lion_king", "9", R.drawable.the_lion_king, "https://www.youtube.com/watch?v=dFZHMHjdB8w"));
//        arr.add(new datamoovei("the_simpsons", "10", R.drawable.the_simpsons, "https://www.youtube.com/watch?v=dFZHMHjdB8w"));
//        arr.add(new datamoovei("toy_story_4", "11", R.drawable.toy_story_4, "https://www.youtube.com/watch?v=dFZHMHjdB8w"));
//        arr.add(new datamoovei("young_sheldon", "12", R.drawable.young_sheldon, "https://www.youtube.com/watch?v=dFZHMHjdB8w"));
//
//        return arr;
//    }

    private void loadMoveis(){
        Call <ImegeSearchResult> myCall = TMDBRetrofistRest.myMooveiServich.searchMobiesByPepuler(keyMoovey);
        myCall.enqueue(new Callback<ImegeSearchResult>() {
            @Override
            public void onResponse(Call<ImegeSearchResult> call, Response<ImegeSearchResult> response) {
                if (response.isSuccessful()){
                    mylist = response.body().getResults();
                }
//                mylist = call.
            }

            @Override
            public void onFailure(Call<ImegeSearchResult> call, Throwable t) {

            }
        });

    }

    @Override
    public void OnMooveiClicked(Result moovei) {
        fragment2 f2 = fragment2.newIntent(moovei);
        if (tabletframeLayout == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.AM_FrameLayout, f2).commit();
        } else {
//            mPager.setCurrentItem(2, true);
            tabletframeLayout.setCurrentItem(mooveiFragment.corectPosishen);
//                    .layoutManager.scrollToPosition(x)
//            getSupportFragmentManager()
//                    .beginTransaction()
//                    .addToBackStack(null)
//                    .replace(R.id.AM_F2_ViewPager,f2).commit();
//        }
        }
    }
}
