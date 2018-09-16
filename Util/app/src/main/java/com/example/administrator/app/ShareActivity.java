package com.example.administrator.app;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.base.WinBaseActivity;
import com.example.administrator.util.L;
import com.example.administrator.util.ShareUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * SharedPreferences 的封装
 */
public class ShareActivity extends WinBaseActivity {

    //   原生存储数据
    @BindView(R.id.btn_01)
    Button btn01;
    //    原生取出数据
    @BindView(R.id.btn_02)
    Button btn02;
    //    使用工具类存储数据
    @BindView(R.id.btn_03)
    Button btn03;
    //    使用工具类取出数据
    @BindView(R.id.btn_04)
    Button btn04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_01, R.id.btn_02, R.id.btn_03, R.id.btn_04})
    public void onViewClicked(View view) {
        switch (view.getId()) {
//           原生储存数据
            case R.id.btn_01:
                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                editor.putString("name", "tonjies");
                editor.putInt("age", 20);
                editor.apply();
                break;
//           原生获取数据
            case R.id.btn_02:
                SharedPreferences preferences = getSharedPreferences("data", MODE_PRIVATE);
                String name = preferences.getString("name", "");
                int age = preferences.getInt("age", 18);
                L.d("name:" + name);
                L.d("age" + age);
                break;
//            使用工具类存储数据
            case R.id.btn_03:
//               存储String类型
                ShareUtils.putString(ShareActivity.this, "name2", "tonjies");
//               存储int类型
                ShareUtils.putInt(ShareActivity.this, "age2", 21);
                break;
//               使用工具类取出数据
            case R.id.btn_04:
//               取出String类型
                final String string = ShareUtils.getString(ShareActivity.this, "name2", "没有值可以取出来");
                L.d(string);
//                取出int类型
                final int age2 = ShareUtils.getInt(ShareActivity.this, "age2", 18);
                L.d(age2 + "");
                break;
        }
    }
}
