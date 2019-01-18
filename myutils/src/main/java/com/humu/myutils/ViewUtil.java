package com.humu.myutils;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 控件工具类
 * Created by humu on 2019/1/18.
 */

public class ViewUtil {

    /**
     * 设置TextView文字
     * @param textView
     * @param text
     */
    public static void setTextView(TextView textView,String text){
        if(textView == null){
            return;
        }
        if(TextUtils.isEmpty(text)){
            return;
        }
        textView.setText(text);
    }

    /**
     * 获取TextView文字
     * @param textView
     * @return
     */
    public static String getText(TextView textView){
        String text = "";
        if(textView != null){
            if(!TextUtils.isEmpty(textView.getText().toString())){
                text = textView.getText().toString();
            }
        }
        return text;
    }

    /**
     * 设置visiable
     * @param view
     */
    public static void setViewVisiable(View view){
        if(view == null){
            return;
        }
        if(view.getVisibility() != View.VISIBLE){
            view.setVisibility(View.VISIBLE);
        }
    }

    public static void setViewsVisiable(View... views){
        for(View view: views){
            if(view != null && view.getVisibility() != View.VISIBLE){
                view.setVisibility(View.VISIBLE);
            }
        }
    }

    /**
     * 设置INVISIBLE
     * @param view
     */
    public static void setViewInVisiable(View view){
        if(view == null){
            return;
        }
        if(view.getVisibility() != View.INVISIBLE){
            view.setVisibility(View.INVISIBLE);
        }
    }

    public static void setViewsInVisiable(View... views){
        for(View view: views){
            if(view != null && view.getVisibility() != View.INVISIBLE){
                view.setVisibility(View.INVISIBLE);
            }
        }
    }

    /**
     * 设置GONE
     * @param view
     */
    public static void setViewGone(View view){
        if(view == null){
            return;
        }
        if(view.getVisibility() != View.GONE){
            view.setVisibility(View.GONE);
        }
    }

    public static void setViewsGone(View... views){
        for(View view: views){
            if(view != null && view.getVisibility() != View.GONE){
                view.setVisibility(View.GONE);
            }
        }
    }

    public static void setImageResource(ImageView imageView,int imageResource){
        if(imageView == null){
            return;
        }
        imageView.setImageResource(imageResource);
    }

    public static void setImageBitmap(ImageView imageView, Bitmap bitmap){
        if(imageView == null){
            return;
        }
        if(bitmap == null){
            return;
        }
        imageView.setImageBitmap(bitmap);
    }

}
