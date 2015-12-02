package com.duanlei.imageloader;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Author: duanlei
 * Date: 2015-12-01
 *
 * 处理图片缓存
 */
public class MemoryCache implements ImageCache {

    //图片加载
    LruCache<String, Bitmap> mImageCache;

    public MemoryCache() {
        initImageCache();
    }

    private void initImageCache() {
        //计算可使用的最大内存
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);

        //去四分之一的可用内存作为缓存,缓存只以kb为单位
        final int cacheSize = maxMemory / 4;
        mImageCache = new LruCache<String, Bitmap>(cacheSize) {

            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                //衡量每张图片的大小
                return bitmap.getByteCount() / 1024;
            }
        };
    }

    @Override
    public Bitmap get(String url) {
        return mImageCache.get(url);
    }

    @Override
    public void put(String url, Bitmap bmp) {
        mImageCache.put(url, bmp);
    }
}
