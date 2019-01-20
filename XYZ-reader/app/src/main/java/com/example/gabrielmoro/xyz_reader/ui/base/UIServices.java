package com.example.gabrielmoro.xyz_reader.ui.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class UIServices {

    public static void loadImageUsingGlide(@NonNull Context context, @NonNull String url, @NonNull ImageView ivImageView) {
        Glide.with(context)
                .load(url)
                .into(ivImageView);
    }

    public static String removingNewLines(@NonNull String text) {
        return text.trim().replaceAll("\n", "");
    }

}
