package com.example.gabrielmoro.xyz_reader.ui.mainScreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.gabrielmoro.xyz_reader.R;
import com.example.gabrielmoro.xyz_reader.api.APICallBackResult;
import com.example.gabrielmoro.xyz_reader.api.APIRetrofitHandler;
import com.example.gabrielmoro.xyz_reader.model.XyzReaderJson;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        APIRetrofitHandler.getMyInstance().getAllXYZReaderObjects(new APICallBackResult<List<XyzReaderJson>>() {
            @Override
            public void onSucess(List<XyzReaderJson> result) {
                for(XyzReaderJson tmp : result) {
                    Log.d("TEST", tmp.getAuthor());
                }
            }

            @Override
            public void onFailure(Throwable problem) {

            }

            @Override
            public void onCompleted() {

            }
        });
    }
}
