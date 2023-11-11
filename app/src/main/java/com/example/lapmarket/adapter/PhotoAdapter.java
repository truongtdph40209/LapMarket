package com.example.lapmarket.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.lapmarket.R;
import com.example.lapmarket.model.photo;

import java.util.List;

public class PhotoAdapter extends PagerAdapter {
    private Context context;
    private List<photo> mListPhoto;

    public PhotoAdapter(Context context, List<photo> mListPhoto) {
        this.context = context;
        this.mListPhoto = mListPhoto;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_photo, container, false);

        ImageView img_photo = view.findViewById(R.id.img_photo);

        photo phoTo = mListPhoto.get(position);
        if (phoTo != null){
            Glide.with(context).load(phoTo.getPhotoID()).into(img_photo);

        }
        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {

        if (mListPhoto != null){
            return mListPhoto.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object) ;
    }
}
