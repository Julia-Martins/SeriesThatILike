package com.example.seriesthatilike.models;

import android.widget.ImageView;
import android.widget.TextView;

public class ItemSeriesGalleryModel {
    private ImageView img_series_gallery;
    private TextView txt_series_gallery;

    public ItemSeriesGalleryModel(ImageView img_series_gallery,
                                  TextView txt_series_gallery){
        this.img_series_gallery = img_series_gallery;
        this.txt_series_gallery = txt_series_gallery;
    }
    public ImageView getImg_series_gallery() {
        return img_series_gallery;
    }
    public TextView getTxt_series_gallery() {
        return txt_series_gallery;
    }
}
