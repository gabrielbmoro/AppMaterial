package com.example.gabrielmoro.xyz_reader.ui.mainScreen.adapter;

import android.support.annotation.NonNull;

import com.example.gabrielmoro.xyz_reader.R;
import com.example.gabrielmoro.xyz_reader.ui.base.GeneralBaseAdapter;

import java.util.List;

public class XYZAdapterList extends GeneralBaseAdapter<XYZViewModel> {

    public XYZAdapterList(@NonNull List<XYZViewModel> aLstElements) {
        super(aLstElements);
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.view_holder_xyz_item;
    }
}
