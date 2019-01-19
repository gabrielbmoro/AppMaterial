package com.example.gabrielmoro.xyz_reader.ui.mainScreen.adapter;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.example.gabrielmoro.xyz_reader.BR;
import com.example.gabrielmoro.xyz_reader.model.XyzReaderJson;
import com.example.gabrielmoro.xyz_reader.ui.base.AdapterViewModels;
import com.example.gabrielmoro.xyz_reader.ui.mainScreen.detailScreen.DetailActivity;

public class XYZViewModel extends BaseObservable implements AdapterViewModels<XyzReaderJson> {

    private String title;
    private XyzReaderJson item;
    private boolean wasImageRequested = false;

    @Override
    public void setup(XyzReaderJson itemArgument) {
        item = itemArgument;
        setTitle(itemArgument.getTitle());
    }

    @Override
    public void onClick(View view) {
        DetailActivity.startActivity(view.getContext(), item);
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String titleArgument) {
        this.title = titleArgument;
        notifyPropertyChanged(BR.title);
    }

    public String getURL() {
        return item.getPhoto();
    }

    public boolean isWasImageRequested() {
        return wasImageRequested;
    }

    public void setWasImageRequested(boolean wasImageRequested) {
        this.wasImageRequested = wasImageRequested;
    }


}
