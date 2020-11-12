package com.android.custom.androidkeyboard.util;

import android.content.Context;
import android.util.TypedValue;

/**
 * @ProjectName: CustomKeyBoard
 * @Package: com.android.custom.androidkeyboard.util
 * @ClassName: ScreenUtils
 * @Author: 1984629668@qq.com
 * @CreateDate: 2020/11/12 14:36
 */
public class ScreenUtils {
    public static float sp2px(Context context, int i) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, i, context.getResources().getDisplayMetrics());
    }
}
