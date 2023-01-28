package com.saadahmedev.helperwidget.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.saadahmedev.helperwidget.Helper;
import com.saadahmedev.helperwidget.R;
import com.saadahmedev.helperwidget.interfaces.OnLongPressListener;

public class View extends android.view.View {
    public View(Context context) {
        super(context);

        init(context, null, 0);
    }

    public View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context, attrs, 0);
    }

    public View(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context, attrs, defStyleAttr);
    }

    @NonNull
    private static int[] cornerRadiusIds() {
        return new int[]{
                R.styleable.View_cornerRadius,
                R.styleable.View_topLeftCornerRadius,
                R.styleable.View_topRightCornerRadius,
                R.styleable.View_bottomRightCornerRadius,
                R.styleable.View_bottomLeftCornerRadius,
        };
    }

    @NonNull
    private static int[] colorIds() {
        return new int[]{
                R.styleable.View_backgroundColor,
                R.styleable.View_rippleColor
        };
    }

    @NonNull
    private static int[] strokeIds() {
        return new int[]{
                R.styleable.View_strokeWidth,
                R.styleable.View_strokeColor
        };
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.View, defStyleAttr, 0);
        Helper.initView(this, context, typedArray, new GradientDrawable());

        Helper.initDefaultColors(colorIds());
        Helper.initDefaultCornerRadius(cornerRadiusIds());
        Helper.initDefaultClickable(R.styleable.View_clickable);
        Helper.initDefaultShape(R.styleable.View_shape);
        Helper.initDefaultStroke(strokeIds());

        Helper.completeView();
        typedArray.recycle();
    }

    public void enable() {
        Helper.enable();
    }

    public void disable() {
        Helper.disable();
    }

    public void visible() {
        Helper.visible();
    }

    public void invisible() {
        Helper.invisible();
    }

    public void gone() {
        Helper.gone();
    }

    public void onClicked(com.saadahmedev.helperwidget.interfaces.OnClickListener listener) {
        Helper.onClicked(listener);
    }

    public void onLongPressed(OnLongPressListener listener) {
        Helper.onLongPressed(listener);
    }
}
