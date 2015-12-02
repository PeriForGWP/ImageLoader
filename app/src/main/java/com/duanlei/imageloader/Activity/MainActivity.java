package com.duanlei.imageloader.Activity;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.duanlei.imageloader.DiskCache;
import com.duanlei.imageloader.DoubleCache;
import com.duanlei.imageloader.ImageCache;
import com.duanlei.imageloader.ImageLoader;
import com.duanlei.imageloader.MemoryCache;
import com.duanlei.imageloader.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageLoader imageLoader = new ImageLoader();

        //使用内存缓存
        imageLoader.setImageCache(new MemoryCache());

        //使用sd卡缓存
        imageLoader.setImageCache(new DiskCache());

        //使用双缓存
        imageLoader.setImageCache(new DoubleCache());

        //使用自定义图片缓存
        imageLoader.setImageCache(new ImageCache() {
            @Override
            public Bitmap get(String url) {
                return null;
            }

            @Override
            public void put(String url, Bitmap bmp) {

            }
        });
    }
}
