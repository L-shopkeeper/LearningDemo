package com.example.jingyidemo.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jingyidemo.R;

/**
 * 自定义顶部标题栏
 */
public class TitleBar extends RelativeLayout {
    private ImageView mTitleBarLeftIv;
    private ImageView mTitleBarRightIv;
    private TextView mTitleBarTitleTv;
    private RelativeLayout mTitleBarRootRl;
    private int mColor = Color.BLUE;
    private int mTextColor = Color.WHITE;
    private String titleName;



    public TitleBar(Context context) {
        super(context);
        initView(context);
    }



    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray mTypeArray = context.obtainStyledAttributes(R.styleable.TitleBar);
        mColor = mTypeArray.getColor(R.styleable.TitleBar_title_bg, Color.BLUE);
        mTextColor = mTypeArray.getColor(R.styleable.TitleBar_title_text_color, Color.WHITE);
        titleName = mTypeArray.getString(R.styleable.TitleBar_title_text);
        mTypeArray.recycle();
        initView(context);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_customtitle, this, true);
        mTitleBarLeftIv = findViewById(R.id.iv_titlebar_left);
        mTitleBarRightIv = findViewById(R.id.iv_titlebar_right);
        mTitleBarTitleTv = findViewById(R.id.tv_titlebar_title);
        mTitleBarRootRl = findViewById(R.id.layout_titlebar_rootlayout);
        //设置背景颜色
        mTitleBarRootRl.setBackgroundColor(mColor);
        //设置标题文字颜色
        mTitleBarTitleTv.setTextColor(mTextColor);
    }

    public void setTitle(String titleName) {
        if (!TextUtils.isEmpty(titleName)) {
            mTitleBarTitleTv.setText(titleName);
        }
    }

    public void setLeftListener(OnClickListener onClickListener) {
        mTitleBarLeftIv.setOnClickListener(onClickListener);
    }

    public void setRightListener(OnClickListener onClickListener) {
        mTitleBarRightIv.setOnClickListener(onClickListener);
    }
}
