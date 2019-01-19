package com.example.gabrielmoro.xyz_reader.ui.mainScreen.detailScreen;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.gabrielmoro.xyz_reader.R;
import com.example.gabrielmoro.xyz_reader.model.XyzReaderJson;

public class DetailActivity extends AppCompatActivity {

    public static String INTENT_XYZ_READER_OBJECT_INTENT_KEY = "Intent XYZ Reader Object";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if(!getIntent().hasExtra(INTENT_XYZ_READER_OBJECT_INTENT_KEY)) {
            finish();
        } else {
            Parcelable parcel = getIntent().getParcelableExtra(INTENT_XYZ_READER_OBJECT_INTENT_KEY);
            if(parcel instanceof XyzReaderJson) {
                XyzReaderJson jsonReader = (XyzReaderJson) parcel;
            } else
                finish();
        }

    }

    public static void startActivity(Context context, XyzReaderJson xyzReaderJsonSelected) {
        Intent intentAction = new Intent(context, DetailActivity.class);
        intentAction.putExtra(INTENT_XYZ_READER_OBJECT_INTENT_KEY, xyzReaderJsonSelected);
        context.startActivity(intentAction);
    }

}
