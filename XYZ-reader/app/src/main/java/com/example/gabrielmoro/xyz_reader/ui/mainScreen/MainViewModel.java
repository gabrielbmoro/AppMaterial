package com.example.gabrielmoro.xyz_reader.ui.mainScreen;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.gabrielmoro.xyz_reader.BR;
import com.example.gabrielmoro.xyz_reader.ui.mainScreen.adapter.XYZAdapterList;

public class MainViewModel extends BaseObservable {

    private XYZAdapterList adapterList;

    @Bindable
    public XYZAdapterList getAdapterList() {
        return adapterList;
    }

    public void setAdapterList(XYZAdapterList adapterList) {
        this.adapterList = adapterList;
        notifyPropertyChanged(BR.adapterList);
    }
}
