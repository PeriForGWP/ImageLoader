package com.duanlei.imageloader;

import android.graphics.Bitmap;

/**
 * Author: duanlei
 * Date: 2015-12-02
 * 双缓存，获取图片时先从内存缓存中获取，如果内存缓存中没有缓存该图片，再从sd卡中获取。
 * 缓存图片时在内存和sd卡中都缓存一份
 *
 */
public class DoubleCache implements ImageCache {
    MemoryCache mMemoryCache = new MemoryCache();
    DiskCache mDiskCache = new DiskCache();

    //先从内存缓存中获取图片，如果没有，再从sd卡中获取
    public Bitmap get(String url) {
        Bitmap bitmap = mMemoryCache.get(url);
        if (bitmap == null) {
            bitmap = mDiskCache.get(url);
        }
        return bitmap;
    }

    //将图片缓存到内存和sd卡中
    public void put(String url, Bitmap bmp) {
        mMemoryCache.put(url, bmp);
        mDiskCache.put(url, bmp);
    }

}
