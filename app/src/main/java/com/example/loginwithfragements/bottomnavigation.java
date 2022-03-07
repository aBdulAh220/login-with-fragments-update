package com.example.loginwithfragements;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class bottomnavigation extends AppCompatActivity {

    BottomNavigationView bnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottomnavigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.FrameContainer,new HomeFragment()).commit();

        bnv =(BottomNavigationView) findViewById(R.id.bottom);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment temp=null;

                switch (item.getItemId())
                {
                    case R.id.menu_home: temp=new HomeFragment();
                    break;
                    case R.id.menu_call: temp=new CallFragment();
                    break;
                    case R.id.menu_search: temp=new SearchFragment();
                    break;
                    case R.id.menu_category: temp=new CategoryFragment();


                }
                    getSupportFragmentManager().beginTransaction().replace(R.id.FrameContainer,temp).commit();

                return true;
            }
        });
    }
}