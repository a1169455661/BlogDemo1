package com.example.administrator.app;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


import com.example.administrator.base.Application;
import com.example.administrator.util.FontSetting;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 舍长 on 2018/4/5.
 * 描述: Android字体工具类的使用
 */

public class FontActivity extends AppCompatActivity {
    @BindView(R.id.txt_01)
    TextView txt01;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.switch_item_layout);
        ButterKnife.bind(this);
        //字体工具类的使用
        FontSetting.setFont(FontActivity.this,txt01,"fonts/MengYuanti.ttf");
    }
}
