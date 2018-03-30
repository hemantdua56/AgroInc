package com.example.hemant.agroinc;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hemant.agroinc.weather.WeatherFrag;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static final Integer[] XMEN = {R.drawable.jaijavan1, R.drawable.callcenter, R.drawable.agriculturepic, R.drawable.jaijavan2, R.drawable.jaijavan3
    };
    private ArrayList<Integer> XMENArray = new ArrayList<Integer>();


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_main, container, false);

        Button CropInformation = (Button) rootView.findViewById(R.id.cropInformation);

        CropInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(),AgricultureLib.class);

                startActivity(i);
            }
        });

        Button Weather = (Button) rootView.findViewById(R.id.Weather);

        Weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent i = new Intent(getActivity(),WeatherFrag.class);

                startActivity(i);
            }
        });

        Button Pesticide = (Button) rootView.findViewById(R.id.pesticide);

        Pesticide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(),AgricultureLib.class);

                startActivity(i);
            }
        });
        Button Fertilzer = (Button) rootView.findViewById(R.id.fertilizer);

        Fertilzer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(),AgricultureLib.class);

                startActivity(i);
            }
        });







        for (int i = 0; i < XMEN.length; i++)
            XMENArray.add(XMEN[i]);

        mPager = (ViewPager) rootView.findViewById(R.id.pager);
        mPager.setAdapter(new MySlideAdapter(getContext(), XMENArray));
        CircleIndicator indicator = (CircleIndicator) rootView.findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == XMEN.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2500, 2500);




    return rootView;
    }

}

