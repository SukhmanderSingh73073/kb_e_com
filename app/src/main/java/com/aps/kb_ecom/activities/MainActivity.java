package com.aps.kb_ecom.activities;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.aps.kb_ecom.R;
import com.aps.kb_ecom.adapters.ViewPagerAdapter;
import com.aps.kb_ecom.base.BaseActivity;
import com.aps.kb_ecom.fragment.HomeFragment;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    DrawerLayout drawer_layout ;
    ViewPagerAdapter viewPagerAdapter ;
    ViewPager2 view_pager ;
    List<Fragment> fragmentList = new ArrayList<>() ;
    View drawer_view ;
    NavigationView nav_view ;
    int NAV_POSITION = 0 ;
    TextView   txt_home , txt_offers , txt_reports ,txt_profile , txt_name ,txt_mobile ;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main) ;

        fragmentList.add(new HomeFragment()) ;
        fragmentList.add(new HomeFragment()) ;
        fragmentList.add(new HomeFragment()) ;
        fragmentList.add(new HomeFragment()) ;

        initViews() ;
        initDrawer() ;
        manageClickListener() ;
        navigationClickListener() ;
    }


    private void initDrawer() {

        txt_name = drawer_view.findViewById(R.id.txt_name) ;
        txt_mobile = drawer_view.findViewById(R.id.txt_mobile) ;




    }


    private void navigationClickListener() {
        txt_home.setOnClickListener(v->{
            navPositionClicked(0);
        });
        txt_offers.setOnClickListener(v->{
            navPositionClicked(1);
        });
        txt_reports.setOnClickListener(v->{
            navPositionClicked(2);
        });
        txt_profile.setOnClickListener(v->{
            navPositionClicked(3) ;
        });
    }

    @SuppressLint("NewApi")
    private void navPositionClicked(int pos) {
        view_pager.setCurrentItem(pos) ;
        txt_home.setTextColor(getColor(R.color.bg_color)) ;
        txt_offers.setTextColor(getColor(R.color.gray)) ;
        txt_reports.setTextColor(getColor(R.color.gray)) ;
        txt_profile.setTextColor(getColor(R.color.gray)) ;



        txt_home.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.ic_user, 0, 0);
        txt_offers.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.ic_user, 0, 0);
        txt_reports.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.ic_user, 0, 0);
        txt_profile.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.ic_user, 0, 0);





        if (pos == 0){
            txt_home.setTextColor(getColor(R.color.primary_color)) ;
            txt_home.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.ic_user, 0, 0);

        }else if (pos == 1){
            txt_offers.setTextColor(getColor(R.color.primary_color)) ;
            txt_offers.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.ic_user, 0, 0);

        }else if (pos == 2){
            txt_reports.setTextColor(getColor(R.color.primary_color)) ;
            txt_reports.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.ic_user, 0, 0);

        }else{
            txt_profile.setTextColor(getColor(R.color.primary_color)) ;
            txt_profile.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.ic_user, 0, 0);

        }

    }

    private void manageClickListener() {

        View headers = nav_view.getHeaderView(0) ;
        TextView txt_name   = headers.findViewById(R.id.txt_name);
        TextView txt_mobile = headers.findViewById(R.id.txt_mobile);

        headers.findViewById(R.id.iv_back).setOnClickListener(v->{
            drawer_layout.closeDrawers() ;
        });


        view_pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onPageSelected(int position) {
                NAV_POSITION = position  ;
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        //txt_title.setText("HOME") ;
                        break;

                    case 1:
                        //txt_title.setText("OFFERS") ;
                        break;

                    case 2:
                        //txt_title.setText("REPORTS") ;
                        break;

                    case 3:
                        //txt_title.setText("PROFILE") ;
                        break;




                }
            }
        });


    }

    private void initViews() {


        txt_home = findViewById(R.id.txt_home);
        txt_offers = findViewById(R.id.txt_offers);
        txt_reports = findViewById(R.id.txt_reports);
        txt_profile = findViewById(R.id.txt_profile);

        drawer_layout = findViewById(R.id.drawer_layout);
        nav_view = findViewById(R.id.nav_view);
        view_pager = findViewById(R.id.view_pager) ;
        viewPagerAdapter = new ViewPagerAdapter(this , fragmentList);
        view_pager.setAdapter(viewPagerAdapter);
        view_pager.setUserInputEnabled(false) ;


        nav_view = findViewById(R.id.nav_view) ;
        drawer_layout = findViewById(R.id.drawer_layout) ;
        view_pager = findViewById(R.id.view_pager) ;
        drawer_view = nav_view.getHeaderView(0) ;


    }

    @Override
    public void onBackPressed() {
        if (NAV_POSITION == 0){
            super.onBackPressed();
        }else {
            navPositionClicked(0) ;



        }
    }



}