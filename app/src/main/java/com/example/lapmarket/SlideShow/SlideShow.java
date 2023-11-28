package com.example.lapmarket.SlideShow;

import android.view.View;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.AnimationTypes;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.lapmarket.R;

import java.util.ArrayList;

public class SlideShow {
    public static void slideShow(View view, ImageSlider imageSlider, String url1, String url2, String url3) {
        ArrayList<SlideModel> imageList = new ArrayList<>(); // Create image list

        // imageList.add(new SlideModel("String Url" or R.drawable));
        // imageList.add(new SlideModel("String Url" or R.drawable, "title")); // You can add title

        imageList.add(new SlideModel(url1, ScaleTypes.FIT));
        imageList.add(new SlideModel(url2, ScaleTypes.CENTER_INSIDE));
        imageList.add(new SlideModel(url3, ScaleTypes.CENTER_CROP));


        imageSlider.setImageList(imageList);
        imageSlider.setSlideAnimation(AnimationTypes.ZOOM_OUT);
    }


    public static void slideShowFoDraw(View view, ImageSlider imageSlider, int url1, int url2, int url3, int url4) {
        ArrayList<SlideModel> imageList = new ArrayList<>(); // Create image list

        // imageList.add(new SlideModel("String Url" or R.drawable));
        // imageList.add(new SlideModel("String Url" or R.drawable, "title")); // You can add title

        imageList.add(new SlideModel(url1, ScaleTypes.FIT));
        imageList.add(new SlideModel(url2, ScaleTypes.CENTER_INSIDE));
        imageList.add(new SlideModel(url3, ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(url4, ScaleTypes.CENTER_INSIDE));


        imageSlider.setImageList(imageList);
        imageSlider.setSlideAnimation(AnimationTypes.ZOOM_OUT);
    }
}
