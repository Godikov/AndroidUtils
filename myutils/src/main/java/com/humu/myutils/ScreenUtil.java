package com.humu.myutils;

import android.content.Context;
import android.content.res.Configuration;

/**
 * Created by Administrator on 2019/1/25.
 */

public class ScreenUtil {

    private ScreenUtil(){}

    /**
     * 判断当前是否是横屏
     * @param context
     * @return
     */
    public static boolean isLandscape(Context context) {
        return context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

    /**
     * 判断当前是否是竖屏
     * @param context
     * @return
     */
    public static boolean isPortrait(Context context) {
        return context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
    }


}
