package com.duanlei.imageloader.Utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * Author: duanlei
 * Date: 2015-12-02
 */
public final class CloseUtils {
    private CloseUtils() {}

    /**
     * 关闭Closeable对象
     * @param closeable
     */
    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
