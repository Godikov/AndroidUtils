package com.humu.myutils;

import android.text.TextUtils;

/**
 * Created by Administrator on 2019/1/24.
 */

public class ParseUtil {

    private ParseUtil(){}

    /**
     * String -> int，出现异常返回0
     * @param intStr
     * @return
     */
    public static int parseInt(String intStr){
        if(!TextUtils.isEmpty(intStr)){
            if(RegexUtil.checkDigit(intStr)){
                return Integer.parseInt(intStr);
            }
        }
        return 0;
    }

    public static long parseLong(String longStr){
        if(!TextUtils.isEmpty(longStr)){
            return Long.parseLong(longStr);
        }
        return 0;
    }

}
