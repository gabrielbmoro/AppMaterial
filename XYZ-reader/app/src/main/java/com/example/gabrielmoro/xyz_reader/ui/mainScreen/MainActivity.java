package com.example.gabrielmoro.xyz_reader.ui.mainScreen;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.example.gabrielmoro.xyz_reader.R;
import com.example.gabrielmoro.xyz_reader.api.APICallBackResult;
import com.example.gabrielmoro.xyz_reader.api.APIRetrofitHandler;
import com.example.gabrielmoro.xyz_reader.databinding.ActivityMainBinding;
import com.example.gabrielmoro.xyz_reader.model.XyzReaderJson;
import com.example.gabrielmoro.xyz_reader.ui.base.UIServices;
import com.example.gabrielmoro.xyz_reader.ui.mainScreen.adapter.LoadImageURLContract;
import com.example.gabrielmoro.xyz_reader.ui.mainScreen.adapter.XYZAdapterList;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MainViewModel viewModel = new MainViewModel(new XYZAdapterList(getImageLoader(this)));

        binding.setViewModel(viewModel);

        StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        binding.rvXYZItems.setLayoutManager(sglm);

        binding.srSwipeRefreshComponent.setOnRefreshListener(this);

        getElementsFromServer();
    }

    private void getElementsFromServer() {
        binding.srSwipeRefreshComponent.setRefreshing(true);
        APIRetrofitHandler.getMyInstance().getAllXYZReaderObjects(new APICallBackResult<List<XyzReaderJson>>() {
            @Override
            public void onSucess(List<XyzReaderJson> result) {
                binding.getViewModel().updateAdapter(result);
            }

            @Override
            public void onFailure(Throwable problem) {
            }

            @Override
            public void onCompleted() {
                binding.srSwipeRefreshComponent.setRefreshing(false);
            }
        });
    }


    private LoadImageURLContract getImageLoader(final Context context) {
        return new LoadImageURLContract() {
            @Override
            public void onLoadImage(@NonNull String url, @NonNull ImageView ivImageView) {
                UIServices.loadImageUsingGlide(context, url, ivImageView);
            }
        };
    }


    @Override
    public void onRefresh() {
        getElementsFromServer();
    }
}
