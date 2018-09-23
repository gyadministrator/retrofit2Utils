package com.gy.android.librarydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gy.android.librarydemo.http.RetrofitFactory;
import com.gy.android.librarydemo.utils.LoadingUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoadingUtils.init(this);
        LoadingUtils.show("正在加载...");
    }
}
