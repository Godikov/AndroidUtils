package com.humu.myutils;

import android.app.Activity;
import android.content.Context;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by humu on 2019/1/19.
 */

public class KeyboardUtil {

    /**
     * 为给定的编辑器开启软键盘
     *
     * @param editText 给定的编辑器
     */
    public static void openSoftKeyboard(Context context, EditText editText) {
        if(context != null && editText != null){
            editText.requestFocus();
            InputMethodManager inputMethodManager
                    = (InputMethodManager) context.getSystemService(
                    Context.INPUT_METHOD_SERVICE);
            inputMethodManager.showSoftInput(editText,
                    InputMethodManager.SHOW_IMPLICIT);
            editText.setSelection(editText.getText().toString().length());
        }
    }


    /**
     * 关闭软键盘
     * @param activity
     */
    public static void hideSoftInput(Activity activity) {
        if (activity.getCurrentFocus() != null)
            ((InputMethodManager) activity
                    .getSystemService(Context.INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(activity.getCurrentFocus()
                            .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * 获取软键盘是否是弹出状态
     * @param mActivity
     * @return
     */
    public boolean keyboardIsShow(Activity mActivity) {
        if (mActivity.getWindow().getAttributes().softInputMode == WindowManager.LayoutParams.SOFT_INPUT_STATE_UNSPECIFIED) {
            //隐藏软键盘
            //mActivity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
            return true;
        }
        else {
            return false;
        }
    }

}
