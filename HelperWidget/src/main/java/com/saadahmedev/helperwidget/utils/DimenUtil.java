package com.saadahmedev.helperwidget.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class DimenUtil {
    public static float floatToDp(Context context, float value) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, metrics);
    }
}
