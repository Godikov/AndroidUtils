package com.humu.myutils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

/**
 * Created by humu on 2019/1/18.
 */

public class FileUtil {

    /**
     * 获取Uri的绝对路径
     * @param uri
     * @return
     */
    public static String convertToFilePath(Context context, Uri uri) {
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = context.getContentResolver().query(uri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            return cursor.getString(cursor.getColumnIndex(MediaStore.MediaColumns.DATA));
        }
        return null;
    }

}
