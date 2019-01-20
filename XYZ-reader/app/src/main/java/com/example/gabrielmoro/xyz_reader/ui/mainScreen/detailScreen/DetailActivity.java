package com.example.gabrielmoro.xyz_reader.ui.mainScreen.detailScreen;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.example.gabrielmoro.xyz_reader.R;
import com.example.gabrielmoro.xyz_reader.databinding.ActivityDetailBinding;
import com.example.gabrielmoro.xyz_reader.model.XyzReaderJson;
import com.example.gabrielmoro.xyz_reader.ui.base.UIServices;

public class DetailActivity extends AppCompatActivity {

    public static String TITLE_INTENT_KEY = "Title";
    public static String SUB_TITLE_INTENT_KEY = "Subtitle";
    public static String BODY_ÌNTENT_KEY = "Body";
    public static String URL_INTENT_KEY = "Url";

    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DetailViewModel viewModel = ViewModelProviders.of(this).get(DetailViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        binding.setViewModel(viewModel);

        if (!getIntent().hasExtra(TITLE_INTENT_KEY)
                || !getIntent().hasExtra(SUB_TITLE_INTENT_KEY)
                || !getIntent().hasExtra(BODY_ÌNTENT_KEY)
                || !getIntent().hasExtra(URL_INTENT_KEY)) {
            finish();
        } else {
            String title = getIntent().getStringExtra(TITLE_INTENT_KEY);
            String subTitle = getIntent().getStringExtra(SUB_TITLE_INTENT_KEY);
            String body = getIntent().getStringExtra(BODY_ÌNTENT_KEY);
            String url = getIntent().getStringExtra(URL_INTENT_KEY);

            viewModel.setTitle(title);
            viewModel.setSubTitle(subTitle);
            viewModel.setBody(body);
            viewModel.setImageUrl(url);
            setupImageView(viewModel.getImageUrl());
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void setupImageView(@NonNull String url) {
        UIServices.loadImageUsingGlide(this, url, binding.mainBackdrop);
    }

    public static void startActivity(Context context, XyzReaderJson xyzReaderJsonSelected) {
        Intent intentAction = new Intent(context, DetailActivity.class);
        intentAction.putExtra(TITLE_INTENT_KEY, xyzReaderJsonSelected.getTitle());
        intentAction.putExtra(SUB_TITLE_INTENT_KEY, xyzReaderJsonSelected.getAuthor());
        intentAction.putExtra(BODY_ÌNTENT_KEY, UIServices.removingNewLines(xyzReaderJsonSelected.getBody()));
        intentAction.putExtra(URL_INTENT_KEY, xyzReaderJsonSelected.getPhoto());
        context.startActivity(intentAction);
    }

}
