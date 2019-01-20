package com.example.gabrielmoro.xyz_reader.ui.mainScreen;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.NonNull;

import com.example.gabrielmoro.xyz_reader.model.XyzReaderJson;
import com.example.gabrielmoro.xyz_reader.ui.mainScreen.adapter.XYZAdapterList;

import java.util.List;

public class MainViewModel extends BaseObservable {

    private XYZAdapterList adapterList;


    MainViewModel(@NonNull XYZAdapterList adapterListArgument) {
        adapterList = adapterListArgument;
    }

    @Bindable
    public XYZAdapterList getAdapterList() {
        return adapterList;
    }

    void updateAdapter(@NonNull List<XyzReaderJson> elements) {
        if (adapterList == null) return;
        adapterList.setup(elements);
    }

}
