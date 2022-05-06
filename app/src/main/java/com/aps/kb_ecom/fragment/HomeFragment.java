package com.aps.kb_ecom.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aps.kb_ecom.R;
import com.aps.kb_ecom.adapters.CategoryAdapter;
import com.aps.kb_ecom.adapters.HomeProductAdapter;
import com.aps.kb_ecom.adapters.SliderAdapter;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    SliderView image_slider ;
    View view ;
    RecyclerView rv_cat,rv_products ;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        initViews() ;
        return  view ;
    }

    private void initViews() {

        rv_products = view.findViewById(R.id.rv_products) ;
        rv_cat = view.findViewById(R.id.rv_cat) ;
        rv_cat.setLayoutManager(new LinearLayoutManager(getContext() , LinearLayoutManager.HORIZONTAL , false)) ;
        rv_products.setLayoutManager(new LinearLayoutManager(getContext())) ;

        rv_products.setAdapter(new HomeProductAdapter(getContext())) ;
        rv_cat.setAdapter(new CategoryAdapter()) ;




        image_slider = view.findViewById(R.id.image_slider) ;
        ArrayList<Integer> offerList = new ArrayList<>();
        offerList.add(R.drawable.b_one);
        offerList.add(R.drawable.b_one);
        offerList.add(R.drawable.b_one);
        offerList.add(R.drawable.b_one);

        SliderAdapter sliderAdapter = new SliderAdapter(getContext(), offerList);
        image_slider.setSliderAdapter(sliderAdapter);


        image_slider.setIndicatorAnimation(IndicatorAnimationType.SLIDE);
        image_slider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        image_slider.startAutoCycle();



    }



}