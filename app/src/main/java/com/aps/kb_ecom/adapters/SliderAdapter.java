package com.aps.kb_ecom.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.aps.kb_ecom.R;
import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SliderAdapter extends
        SliderViewAdapter<SliderAdapter.Holder> {

    private Context context;
    private List<Integer> mSliderItems = new ArrayList<>();

    public SliderAdapter(Context context , List<Integer> mSliderItems) {
        this.context = context;
        this.mSliderItems = mSliderItems;
    }

    public void renewItems(List<Integer> sliderItems) {
        this.mSliderItems = sliderItems;
        notifyDataSetChanged();
    }

    public void deleteItem(int position) {
        this.mSliderItems.remove(position);
        notifyDataSetChanged();
    }

    public void addItem(Integer sliderItem) {
        this.mSliderItems.add(sliderItem);
        notifyDataSetChanged();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new Holder(inflate);
    }

    @Override
    public void onBindViewHolder(Holder viewHolder, final int position) {

        Integer sliderItem = mSliderItems.get(position);


        Glide.with(viewHolder.itemView)
                .load(sliderItem)
                .fitCenter()
                .into(viewHolder.imageViewBackground);


    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return mSliderItems.size();
    }

public  class Holder extends ViewHolder {

        View itemView;
        ImageView imageViewBackground;
        ImageView imageGifContainer;


        public Holder(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            imageGifContainer = itemView.findViewById(R.id.iv_gif_container);
            this.itemView = itemView;
        }

}

}