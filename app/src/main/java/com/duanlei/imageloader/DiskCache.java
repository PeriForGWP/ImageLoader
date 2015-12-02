package com.duanlei.imageloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.duanlei.imageloader.Utils.CloseUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Author: duanlei
 * Date: 2015-12-02
 */
public class DiskCache implements ImageCache {
    static String cacheDir = "sdcard/cache/";

    //从缓存中获取图片
    public Bitmap get(String url) {
        return BitmapFactory.decodeFile(cacheDir + url);
    }

    //将图片缓存在内存中
    public void put(String url, Bitmap bmp) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(cacheDir + url);
            bmp.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            CloseUtils.closeQuietly(fileOutputStream);
        }
    }
}
