package com.example.gabrielmoro.xyz_reader.ui.mainScreen.detailScreen;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;

public class DetailViewModel extends AndroidViewModel {

    private String imageUrl;
    private String title;
    private String subTitle;
    private String body;


    public DetailViewModel(@NonNull Application application) {
        super(application);
    }

    /*
      Reference:
      - https://developer.android.com/training/sharing/send#java
       */
    public void onClick(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        String content = title + "\n\n" + body;
        sendIntent.putExtra(Intent.EXTRA_TEXT, content);
        sendIntent.setType("text/plain");
        view.getContext().startActivity(sendIntent);
    }

    String getImageUrl() {
        return imageUrl;
    }

    void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getBody() {
        return body;
    }

    void setBody(String body) {
        this.body = body;
    }
}
