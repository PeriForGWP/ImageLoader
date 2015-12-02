package com.duanlei.imageloader;

import android.graphics.Bitmap;

/**
 * Author: duanlei
 * <p/>
 * Date: 2015-12-02
 */

public interface ImageCache {
    public Bitmap get(String url);
    public void put(String url, Bitmap bmp);
}
