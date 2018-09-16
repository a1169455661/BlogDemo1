package com.example.administrator.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.base.WinBaseActivity;
import com.example.administrator.util.L;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends WinBaseActivity {

    //  打印Log
    @BindView(R.id.btn_01)
    Button btn01;
    //  字体设计封装
    @BindView(R.id.btn_02)
    Button btn02;
    //  sharedPreferences封装
    @BindView(R.id.btn_03)
    Button btn03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btn_01, R.id.btn_02, R.id.btn_03})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_01:
                L.d("你好，世界");
                break;
            case R.id.btn_02:
                startActivity(new Intent(this, FontActivity.class));
                break;
            case R.id.btn_03:
                startActivity(new Intent(this, ShareActivity.class));
                break;
        }
    }
}
