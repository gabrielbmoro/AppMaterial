package com.example.gabrielmoro.xyz_reader.ui.mainScreen.adapter;

import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.example.gabrielmoro.xyz_reader.R;
import com.example.gabrielmoro.xyz_reader.model.XyzReaderJson;
import com.example.gabrielmoro.xyz_reader.ui.base.GeneralBaseAdapter;
import com.example.gabrielmoro.xyz_reader.ui.base.GeneralViewHolder;

import java.util.ArrayList;
import java.util.List;

public class XYZAdapterList extends GeneralBaseAdapter<XYZViewModel> {

    private LoadImageURLContract contract;

    public XYZAdapterList(LoadImageURLContract contractArgument) {
        super(new ArrayList<XYZViewModel>());

        contract = contractArgument;
    }

    public void setup(List<XyzReaderJson> elementsArgument) {
        for (int i = 0; i < elementsArgument.size(); i++) {
            XYZViewModel viewModel = new XYZViewModel();
            viewModel.setup(elementsArgument.get(i));
            elements.add(viewModel);
        }
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.view_holder_xyz_item;
    }

    @Override
    public void onBindViewHolder(@NonNull GeneralViewHolder generalViewHolder, int i) {
        super.onBindViewHolder(generalViewHolder, i);

        XYZViewModel viewModel = elements.get(i);
        if (!viewModel.isWasImageRequested()) {
            ImageView ivImageView = generalViewHolder.itemView.findViewById(R.id.ivCardImage);
            if (ivImageView != null) {
                contract.onLoadImage(elements.get(i).getURL(), ivImageView);
                elements.get(i).setWasImageRequested(true);
            }
        }
    }

}
