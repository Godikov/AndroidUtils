package com.humu.myutils;

import android.app.Activity;
import android.content.res.Resources;

/**
 * Created by Administrator on 2019/1/24.
 */

public class StateBarUtil {

    private StateBarUtil(){}

    /**
     * 获取状态栏的高度
     * @param activity
     * @return
     */
    public static int getStatusBarHeight(Activity activity) {
        // 插件式换肤：怎么获取资源的，先获取资源id，根据id获取资源
        Resources resources = activity.getResources();
        int statusBarHeightId = resources.getIdentifier("status_bar_height","dimen","android");
        return resources.getDimensionPixelOffset(statusBarHeightId);
    }

}
