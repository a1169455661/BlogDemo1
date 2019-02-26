package com.example.administrator.app;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;


import com.example.administrator.base.WinBaseActivity;
import com.example.administrator.util.FontSetting;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 舍长 on 2018/4/5.
 * 描述: Android字体设置
 */

public class FontActivity extends WinBaseActivity {
    @BindView(R.id.txt_01)
    TextView txt01;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.switch_item_layout);
        ButterKnife.bind(this);
        FontSetting.setFont(FontActivity.this,txt01,"fonts/MengYuanti.ttf");
    }
}
