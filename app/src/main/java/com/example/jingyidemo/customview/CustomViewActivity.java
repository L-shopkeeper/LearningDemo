package com.example.jingyidemo.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jingyidemo.R;

public class CustomViewActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView backTv;
    private TitleBar mTitleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);

        findView();
        initListener();
    }

    private void findView() {
        backTv = findViewById(R.id.act_custom_view_back_tv);
        mTitleBar = findViewById(R.id.custom_act_title_bar);
        mTitleBar.setTitle("自定义组合控件");
    }

    private void initListener() {
        backTv.setOnClickListener(this);
        mTitleBar.setLeftListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CustomViewActivity.this, "点击左键", Toast.LENGTH_SHORT).show();
            }
        });
        mTitleBar.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CustomViewActivity.this, "点击右键", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v == backTv) {
            finish();
        }
    }
}