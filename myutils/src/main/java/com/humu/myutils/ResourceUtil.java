package com.humu.myutils;

import android.content.Context;

/**
 * Created by Administrator on 2019/1/24.
 */

public class ResourceUtil {

    private ResourceUtil(){}

    /**
     * 获取颜色
     * @param context
     * @param colorId 颜色id
     * @return
     */
    public static int getColor(Context context, int colorId){
        return context.getResources().getColor(colorId);
    }

}
