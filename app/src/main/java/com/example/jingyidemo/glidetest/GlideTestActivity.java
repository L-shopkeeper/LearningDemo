package com.example.jingyidemo.glidetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.example.jingyidemo.R;

import jp.wasabeef.glide.transformations.BlurTransformation;


public class GlideTestActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView backTv;
    private Button showImageBtn;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_test);

        findView();
        initListener();
        SimpleTarget<GlideDrawable> simpleTarget = new SimpleTarget<GlideDrawable>() {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {

            }
        };
        Glide.with(this)
                .load("")
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                .into(simpleTarget);
        SimpleTarget<Bitmap> simpleTarget1 = new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {

            }
        };
        MyLayout myLayout = new MyLayout(this, null);
        Glide.with(this)
                .load("")
                .into(myLayout.getViewTarget());
        Glide.with(this)
                .load("")
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .preload();
        Glide.with(this)
                .load("")
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        return false;
                    }
                })
                .into(iv);

    }

    private void findView() {
        backTv = findViewById(R.id.act_glide_test_back_tv);
        showImageBtn = findViewById(R.id.act_glide_test_show_image_btn);
        iv = findViewById(R.id.act_glide_test_show_image_iv);
    }

    private void initListener() {
        backTv.setOnClickListener(this);
        showImageBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == backTv) {
            finish();
        } else if (v == showImageBtn) {
            showImage();
            //downloadImage();
        }
    }

    private void downloadImage() {
        String url = "http://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg";
        Glide.with(this)
                .load(url)
                .downloadOnly(new DownloadImageTarget());
    }

    private void showImage(){
        String url = "http://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg";
        //加载网络上的图片、加载手机本地的图片、加载应用资源中的图片
        //如果传入的是Activity或者Fragment的实例，那么当这个Activity或Fragment被销毁的时候，图片加载也会停止
        //Glide.with(this).load(url).into(iv);
        //那么回顾一下Glide最基本的使用方式，其实就是关键的三步走：先with()，再load()，最后into()。熟记这三步，你就已经入门Glide了

        //添加占位图，网络加载较慢，优化一下用户体验
//        Glide.with(this)
//                .load(url)
//                .placeholder(R.drawable.ic_launcher_background)
//                .into(iv);
        //只有第一次加载图片时可以看到占位图，后面就看不到了，因为Glide有缓存机制，
        //禁用掉缓存功能
        //添加加载失败的错误显示图片error
        //指定图片格式：Gif可以直接加载
//        Glide.with(this)
//                .load(url)
//                .placeholder(R.drawable.ic_launcher_background)
//                .error(R.drawable.error)
//                .diskCacheStrategy(DiskCacheStrategy.NONE)
//                .into(iv);
        //会显示错误图片，可能是已经访问不到了
//        url = "http://p1.pstatp.com/large/166200019850062839d3";
        //可以正常显示
        //url = "https://www.qqpao.com/uploads/allimg/170729/10-1FH9110925.gif";
        //指定是加载静态图，gif取第一帧，调用asBitmap
        //如果加载的是静态图，但调用了asGif,就会展示error图
        Glide.with(this)
                .load(url)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.error)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .bitmapTransform(new BlurTransformation(this))

                .into(iv);
        //内存浪费：比如说一张图片的尺寸是1000*1000像素，
        // 但是我们界面上的ImageView可能只有200*200像素，
        // 这个时候如果你不对图片进行任何压缩就直接读取到内存中，这就属于内存浪费了，
        // 因为程序中根本就用不到这么高像素的图片。
        //而使用Glide，我们就完全不用担心图片内存浪费，甚至是内存溢出的问题。
        // 因为Glide从来都不会直接将图片的完整尺寸全部加载到内存中，而是用多少加载多少。
        // Glide会自动判断ImageView的大小，然后只将这么大的图片像素加载到内存当中，帮助我们节省内存开支。

    }


}