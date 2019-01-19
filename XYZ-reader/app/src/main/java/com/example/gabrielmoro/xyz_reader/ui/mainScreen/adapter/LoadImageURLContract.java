package com.example.gabrielmoro.xyz_reader.ui.mainScreen.adapter;

import android.support.annotation.NonNull;
import android.widget.ImageView;

public interface LoadImageURLContract {

    void onLoadImage(@NonNull String url, @NonNull ImageView ivImageView);

}
