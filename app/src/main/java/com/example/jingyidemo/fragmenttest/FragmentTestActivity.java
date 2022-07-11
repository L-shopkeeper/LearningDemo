package com.example.jingyidemo.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.jingyidemo.R;

public class FragmentTestActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView backTv;
    private TextView addFragmentTv;
    private TextView deleteFragmentTv;

    private int fragmentIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);

        //初始化
        findViews();
        initListener();
    }

    private void findViews() {
        backTv = findViewById(R.id.act_fragment_test_back_tv);
        addFragmentTv = findViewById(R.id.add_one_fragment_tv);
        deleteFragmentTv = findViewById(R.id.delete_one_fragment_tv);
    }

    private void initListener() {
        backTv.setOnClickListener(this);
        addFragmentTv.setOnClickListener(this);
        deleteFragmentTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == backTv) {
            finish();
        } else if (v == addFragmentTv) {
            addFragment();
        } else if (v == deleteFragmentTv) {
            deleteFragment();
        }
    }

    private void addFragment() {
        //实例化一个Fragment对象
        String name = "MyFirstFragment" + (++fragmentIndex);
        Fragment fragment = MyFirstFragment.newInstance(name);

        //添加到Activity中
        //事务：一堆操作打包为整体，要么全部成功，要么全部失败
        getSupportFragmentManager().beginTransaction()
                .addToBackStack(null)   //支持back回退
                .add(R.id.my_first_fragment, fragment, "blank")
                .commit();
    }

    private void deleteFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag("blank");
        if(fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .remove(fragment)
                    .commit();
        }
    }
}