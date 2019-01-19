package com.example.gabrielmoro.xyz_reader.ui.mainScreen;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.gabrielmoro.xyz_reader.R;
import com.example.gabrielmoro.xyz_reader.api.APICallBackResult;
import com.example.gabrielmoro.xyz_reader.api.APIRetrofitHandler;
import com.example.gabrielmoro.xyz_reader.databinding.ActivityMainBinding;
import com.example.gabrielmoro.xyz_reader.model.XyzReaderJson;
import com.example.gabrielmoro.xyz_reader.ui.mainScreen.adapter.LoadImageURLContract;
import com.example.gabrielmoro.xyz_reader.ui.mainScreen.adapter.XYZAdapterList;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        binding.rvXYZItems.setLayoutManager(llm);

        binding.setViewModel(new MainViewModel());

        final Context context = this;
        APIRetrofitHandler.getMyInstance().getAllXYZReaderObjects(new APICallBackResult<List<XyzReaderJson>>() {
            @Override
            public void onSucess(List<XyzReaderJson> result) {
                XYZAdapterList adapter = new XYZAdapterList(getImageLoader(context));
                adapter.setup(result);
                binding.getViewModel().setAdapterList(adapter);
            }

            @Override
            public void onFailure(Throwable problem) {

            }

            @Override
            public void onCompleted() {

            }
        });
    }


    LoadImageURLContract getImageLoader(final Context context) {
        return new LoadImageURLContract() {
            @Override
            public void onLoadImage(@NonNull String url, @NonNull ImageView ivImageView) {
                Glide.with(context)
                        .load(url)
                        .into(ivImageView);
            }
        };
    }
}
