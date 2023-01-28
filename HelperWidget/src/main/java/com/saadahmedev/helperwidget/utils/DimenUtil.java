package com.saadahmedev.helperwidget.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class DimenUtil {

    private final Context context;

    private DimenUtil(Context context) {
        this.context = context;
    }

    public static DimenUtil getInstance(Context context) {
        return new DimenUtil(context);
    }

    public float floatToDp(float value) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, metrics);
    }
}
